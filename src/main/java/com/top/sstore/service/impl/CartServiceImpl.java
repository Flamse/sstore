package com.top.sstore.service.impl;

import com.top.sstore.dao.CartMapper;
import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.CartExample;
import com.top.sstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
     * @author zh
     * @date 2019/6/6/006 20:39
     * 选择商品在购物车（准备下单）
     */
    @Override
    public List<Cart> selectServiceInCart(Integer userId, List<Integer> cartIds) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId).andCartIdIn(cartIds);
        List<Cart> carts = cartMapper.selectByExample(example);
//        for (Cart cart : carts){
//            System.out.println(cart.getCartId());
//        }
        return carts;
    }

    @Override
    public boolean addServiceToCart(Cart cart) {
        int a = cartMapper.insertSelective(cart);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public boolean updateNumberOfServiceInCartById(Integer cartId, Integer cartNum) {
        CartExample example = new CartExample();

        example.createCriteria().andCartIdEqualTo(cartId);

        Cart cart = new Cart();
        cart.setServNumber(cartNum);
        int a = cartMapper.updateByExampleSelective(cart, example);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteServiceFromCartByIdAndUserid(Integer cartId, Integer userId) {
        CartExample example = new CartExample();

        example.createCriteria().andCartIdEqualTo(cartId).andUserIdEqualTo(userId);

        int a = cartMapper.deleteByExample(example);
        if (a == 1 )
            return true;
        return false;
    }

    @Override
    public boolean deleteServiceFromCartByIdAndUserid(List<Integer> cartId, Integer userId) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId).andCartIdIn(cartId);
        int a = cartMapper.deleteByExample(example);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public boolean checkUserIDInCartId(Integer cartId, Integer useId) {
        CartExample example = new CartExample();
        example.createCriteria().andCartIdEqualTo(cartId).andUserIdEqualTo(useId);
        long a = cartMapper.countByExample(example);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public Cart selectCartByServId(Integer serviceId, Integer userId) {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId).andServIdEqualTo(serviceId);
        List<Cart> carts = cartMapper.selectByExample(example);
        if (carts.size() == 1){
            return carts.get(0);
        }else if (carts.size() == 0)
            return null;
        throw new RuntimeException();
    }
}
