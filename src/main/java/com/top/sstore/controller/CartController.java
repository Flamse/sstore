package com.top.sstore.controller;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.ICartService;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    /**
     * @author zh
     * @date 2019/6/12/012 16:23
     * 展示购物车
     */
    @GetMapping("/show")
    public Message show(HttpSession session){
        List<Cart> carts = cartService.selectServiceOfAllInCart((Integer)session.getAttribute("userAccountId"));
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
    public Message add(Cart cart, HttpSession session){
        /* 获取用户session */
        Integer userId = (Integer)session.getAttribute("userAccountId");
        //需要商品的 ID和数量。需要对cart校验
        cart.setUserId(userId);

        boolean b = cartService.addServiceToCart(cart);

        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    /**
     * @author zh
     * @date 2019/6/12/012 16:24
     * 修改商品数量 在购物车
     */
    @GetMapping("/update")
    public Message update(Integer cartId, Integer cartNum, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");

        if (cartService.checkUserIDInCartId(cartId, userId)){ //检查用户是否有这个商品在购物车

            boolean b = cartService.updateNumberOfServiceInCartById(cartId, cartNum);

            if (b){
                return Message.success();
            }
        }
        return Message.fail();
    }

    /**
     * @author zh
     * @date 2019/6/12/012 16:24
     * 删除商品 在购物车
     */
    @GetMapping("/delete")
    public Message delete(Integer cartId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");

        boolean b = cartService.deleteServiceFromCartByIdAndUserid(cartId, userId);

        if (b){
            return Message.success();
        }
        return Message.fail();
    }
}
