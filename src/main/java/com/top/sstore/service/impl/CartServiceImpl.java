package com.top.sstore.service.impl;

import com.top.sstore.dao.CartMapper;
import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.CartExample;
import com.top.sstore.pojo.Orderitem;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.ICartService;
import com.top.sstore.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> selectServiceOfAllInCart(Integer userId) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Cart> carts = cartMapper.selectByExample(example);

//        List<Integer> serviceIds = carts.stream().map(Cart::getServId).collect(Collectors.toList());
//        PageInfo<Service> servicePageInfo = serviceService.selectServiceOfAllByIds(serviceIds, pageNum);

//        List<Service> services = serviceService.selectServiceOfAllByIds(serviceIds);
        return carts;
    }

    /**
     * @param userId
     * @param serviceId
     * @author zh
     * @date 2019/6/6/006 20:39
     * 选择商品在购物车（准备下单）
     */
    @Override
    public List<Cart> selectServiceInCart(Integer userId, List<Integer> serviceId) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId).andServIdIn(serviceId);
        List<Cart> carts = cartMapper.selectByExample(example);
        return carts;
    }

    @Override
    public boolean addServiceToCart(Cart cart) {
        int a = cartMapper.insertSelective(cart);
        if (a == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNumberOfServiceInCartById(Integer cartId, Integer cartNum) {
        CartExample example = new CartExample();

        example.createCriteria().andCartIdEqualTo(cartId);

        Cart cart = new Cart();
        cart.setServNumber(cartNum);
        int a = cartMapper.updateByExampleSelective(cart, example);
        if (a == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteServiceFromCartByIdAndUserid(Integer cartId, Integer userId) {
        CartExample example = new CartExample();

        example.createCriteria().andCartIdEqualTo(cartId).andUserIdEqualTo(userId);

        int a = cartMapper.deleteByExample(example);
        if (a == 1 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUserIDInCartId(Integer cartId, Integer userId) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId).andCartIdEqualTo(cartId);
        List<Cart> carts = cartMapper.selectByExample(example);
        if (carts.size() == 1){
            return true;
        }
        return false;
    }
}
