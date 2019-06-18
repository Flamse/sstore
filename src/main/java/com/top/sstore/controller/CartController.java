package com.top.sstore.controller;

import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.ICartService;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.Message;
import com.top.sstore.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private StaticValues staticValues;

    /**
     * @author zh
     * @date 2019/6/12/012 16:23
     * 展示购物车
     */
    @GetMapping("/show")
    public Message s_show(HttpSession session){
        List<Cart> carts = cartService.selectServiceOfAllInCart((Integer)session.getAttribute("userAccountId"));
        List<Integer> serviceIds = carts.stream().map(Cart::getServId).collect(Collectors.toList());
        List<Service> services = serviceService.selectServiceOfAllByIds(serviceIds);
        List<Picture> pictures = pictureService.selectPictureByServids(serviceIds);

        return Message.success().add("carts", carts).add("services", services).add("pictures", pictures);
    }

    /*结算页 展示购物项*/
    @GetMapping("/select")
    public Message s_select(HttpSession session, Integer[] integers){
//        for (Integer userId : integers){
//            System.out.println(userId.toString());
//        }
        Integer userId = (Integer)session.getAttribute(staticValues.getSessionUserId());
        List<Integer> cartIds = Arrays.asList(integers);    //数组转list
//        System.out.println(cartIds);

        List<Cart> carts = cartService.selectServiceInCart(userId, cartIds);
        List<Integer> serviceIds = carts.stream().map(Cart::getServId).collect(Collectors.toList());
        List<Service> services = serviceService.selectServiceOfAllByIds(serviceIds);
        List<Picture> pictures = pictureService.selectPictureByServids(serviceIds);

        return Message.success().add("carts", carts).add("services", services).add("pictures", pictures);
    }

    /**
     * @author zh
     * @date 2019/6/12/012 16:24
     * 添加商品到 购物车
     */
    @GetMapping("/add")
    public Message s_add(Cart cart, HttpSession session){
        /* 获取用户session */
        Integer userId = (Integer)session.getAttribute("userAccountId");
        //需要商品的 ID和数量。需要对cart校验
        cart.setUserId(userId);

        Cart cart1 = cartService.selectCartByServId(cart.getServId(), userId);
        if (cart1 != null){ //购物车有这个商品
            Integer serviceNumber = cart1.getServNumber().intValue()+cart.getServNumber().intValue();
            cartService.updateNumberOfServiceInCartById(cart1.getCartId(), serviceNumber);
            return Message.success();
        }
        /*购物车无此商品*/
        boolean b = cartService.addServiceToCart(cart);
        if (b)
            return Message.success();
        return Message.fail();
    }

    /**
     * @author zh
     * @date 2019/6/12/012 16:24
     * 修改商品数量 在购物车
     */
    @GetMapping("/update")
    public Message s_update(Integer cartId, Integer cartNum, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");

        if (cartService.checkUserIDInCartId(cartId, userId)){ //检查用户是否有这个商品在购物车
            boolean b = cartService.updateNumberOfServiceInCartById(cartId, cartNum);
            if (b)
                return Message.success();
        }
        return Message.fail();
    }

    /**
     * @author zh
     * @date 2019/6/12/012 16:24
     * 删除商品 在购物车
     */
    @GetMapping("/delete")
    public Message s_delete(Integer cartId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");

        boolean b = cartService.deleteServiceFromCartByIdAndUserid(cartId, userId);

        if (b){
            return Message.success();
        }
        return Message.fail();
    }
}
