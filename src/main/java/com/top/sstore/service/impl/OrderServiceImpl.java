package com.top.sstore.service.impl;

import com.top.sstore.dao.OrderMapper;
import com.top.sstore.dao.OrderitemMapper;
import com.top.sstore.pojo.*;
import com.top.sstore.service.IAddressService;
import com.top.sstore.service.ICartService;
import com.top.sstore.service.IOrderService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.StaticValues;
import com.top.sstore.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@org.springframework.stereotype.Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderitemMapper orderitemMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private StaticValues staticValues;

    /**
     * @param addressId
     * @param userId
     * @author zh
     * @date 2019/6/6/006 21:54
     * 下单，操作两个类（order， orderitem）
     */
    @Override
    public boolean pushOrder(Integer addressId, Integer userId, List<Integer> cartIds) {
        Address address = addressService.selectAddressById(addressId, userId);
        if (address == null)
            return false;
        /*获取购物车ID*/
        List<Cart> carts = cartService.selectServiceInCart(userId, cartIds);

        /*获取购物车的商品ID*/
        List<Integer> servIds = carts.stream().map(Cart::getServId).collect(Collectors.toList());
        List<Service> services = serviceService.selectServiceOfAllByIds(servIds);

        //订单号
        Integer orderId = UUIDUtils.getUUIDInOrderId();

        /*商品价格 及 数量*/
        Map<Integer, BigDecimal> servicePrices = services.stream().collect(Collectors.toMap(Service::getServId, Service::getPrice));
//        for (Map.Entry<Integer, BigDecimal> servicePrice :
//        servicePrices.entrySet()) {
//            System.out.println(servicePrice.getKey()+","+servicePrice.getValue());
//        }

        Map<Integer, Integer> serviceNums = carts.stream().collect(Collectors.toMap(Cart::getServId, Cart::getServNumber));
//        for (Map.Entry<Integer, Integer> serviceNum :
//                serviceNums.entrySet()) {
//            System.out.println(serviceNum.getKey()+","+serviceNum.getValue());
//        }


        //商品ID作为key
        Set<Integer> serviceIds = servicePrices.keySet();
        /*计算订单项价格 及 总额*/
        Map<Integer, BigDecimal> totals = new HashMap<>();  //订单项总价格
        BigDecimal totalMoney=new BigDecimal(0);        //总额
        for (Integer id : serviceIds) {
            BigDecimal money = servicePrices.get(id).multiply(new BigDecimal(serviceNums.get(id)));
            totals.put(id, money);
            totalMoney = totalMoney.add(money);
        }
//        for (Map.Entry<Integer, BigDecimal> total :
//                totals.entrySet()) {
//            System.out.println(total.getKey()+","+total.getValue());
//        }
//        System.out.println(totalMoney);

        /*生成订单项List*/
        List<Orderitem> items = new ArrayList<>();
        for (Integer id : serviceIds){
            Orderitem orderitem = new Orderitem();
            orderitem.setOrderId(orderId);  //订单号
            orderitem.setServId(id);        //商品ID
            orderitem.setItemNumber(serviceNums.get(id));//数量
            orderitem.setItemPrice(servicePrices.get(id));
            items.add(orderitem);
        }

        /*生成订单*/
        Order order = new Order();

        order.setUserId(userId);
        order.setOrderId(orderId);     //订单号
        order.setAddressee(address.getAddressee());
        order.setOrderAddress(address.getAddress());
        order.setOrderAddressPhone(address.getAddressPhone());
        order.setOrderPrice(totalMoney);
        order.setOrderCreateTime(new Date());
        order.setOrderStatus(staticValues.getOrderPushOrder()); //下单状态

        /*添加订单信息*/
        orderMapper.insertSelective(order);
        /*添加订单项*/
        for (Orderitem orderitem : items){
            int a = orderitemMapper.insertSelective(orderitem);
            if (a != 1) //添加失败，抛异常回滚
                throw new RuntimeException();
            /*修改库存*/
            Integer volume = serviceService.selectServNum(orderitem.getServId());    //商品库存
            Integer number = orderitem.getItemNumber();                                 //下单数量
            Integer newVolume = volume.intValue() - number.intValue();
            if (newVolume.intValue() >= 0) {    //库存不会降为0
                boolean b = serviceService.updateServNum(orderitem.getServId(), newVolume);
                if (!b) //更新库存失败，抛异常回滚
                    throw new RuntimeException();
            }else
                throw new RuntimeException();
        }
        /*删除购物车，成功失败无所谓*/
        cartService.deleteServiceFromCartByIdAndUserid(cartIds, userId);
        return true;
    }

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 付款
     */
    @Override
    public boolean payOrder(Integer orderId, Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId);
        Order order = new Order();
        order.setOrderStatus(staticValues.getOrderPayOrder());
        int a = orderMapper.updateByExampleSelective(order, example);
        if (a == 1)
            return true;
        return false;
    }

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 发货
     */
    @Override
    public boolean distributeOrder(Integer orderId, Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId);
        Order order = new Order();
        order.setOrderStatus(staticValues.getOrderDistributeOrder());
        int a = orderMapper.updateByExampleSelective(order, example);
        if (a == 1)
            return true;
        return false;
    }

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 签收
     */
    @Override
    public boolean completeOrder(Integer orderId, Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId);
        Order order = new Order();
        order.setOrderStatus(staticValues.getOrderCompleteOrder());
        int a = orderMapper.updateByExampleSelective(order, example);
        if (a == 1)
            return true;
        return false;
    }

    /**
     * @author zh
     * @date 2019/6/6/006 22:28
     * 取消订单
     */
    @Override
    public boolean cancelOrder(Integer orderId, Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId);
        Order order = new Order();
        order.setOrderStatus(staticValues.getOrderCancelOrder());
        int a = orderMapper.updateByExampleSelective(order, example);
        if (a == 1)
            return true;
        return false;
    }

    /**
     * @param userId
     * @author zh
     * @date 2019/6/6/006 22:59
     * 查看所有订单通过用户ID
     */
    @Override
    public List<Order> selectOrderOfAll(Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return orderMapper.selectByExample(example);
    }

    /**
     * @param userId
     * @param orderId
     * @author zh
     * @date 2019/6/6/006 23:01
     * 查看订单信息通过 用户ID + 订单ID
     */
    @Override
    public Order selectOrderById(Integer userId, Integer orderId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId);
        List<Order> orders = orderMapper.selectByExample(example);
        return orders.get(0);
    }

    /**
     * @param orderId
     * @author zh
     * @date 2019/6/6/006 23:07
     * 查看订单详情
     */
    @Override
    public List<Orderitem> selectItemByOrderId(Integer orderId) {
        OrderitemExample example = new OrderitemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<Orderitem> orderitems = orderitemMapper.selectByExample(example);
        return orderitems;
    }
}
