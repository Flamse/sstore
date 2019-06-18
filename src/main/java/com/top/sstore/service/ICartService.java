package com.top.sstore.service;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.Orderitem;
import com.top.sstore.pojo.Service;

import java.util.List;

public interface ICartService {

    /**
     * @author zh
     * @date 2019/6/6/006 20:39
     * 查看所有商品在购物车
     */
    List<Cart> selectServiceOfAllInCart(Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 20:39
     * 选择商品在购物车
     */
    List<Cart> selectServiceInCart(Integer userId, List<Integer> cartIds);

    /**
     * @author zh
     * @date 2019/6/6/006 20:39
     * 添加商品到购物车
     */
    boolean addServiceToCart(Cart cart);

    /**
     * @author zh
     * @date 2019/6/6/006 20:39
     * 修改商品的数量在购物车
     */
    boolean updateNumberOfServiceInCartById(Integer cartId, Integer cartNum);

    /**
     * @author zh
     * @date 2019/6/6/006 20:39
     * 删除商品从购物车
     */
    boolean deleteServiceFromCartByIdAndUserid(Integer cartId, Integer userId);
    boolean deleteServiceFromCartByIdAndUserid(List<Integer> cartId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/12/012 16:12
     * 检查用户是否有这个商品
     */
    boolean checkUserIDInCartId(Integer cartId, Integer useId);
    /**
     * @author zh
     * @date 2019/6/18/018 11:22
     * 查看商品是否在用户的购物车
     */
    Cart selectCartByServId(Integer serviceId, Integer userId);
}
