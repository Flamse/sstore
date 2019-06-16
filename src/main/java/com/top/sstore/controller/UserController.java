package com.top.sstore.controller;

import com.top.sstore.pojo.User;
import com.top.sstore.service.IUserService;
import com.top.sstore.utils.Message;
import com.top.sstore.utils.StaticValues;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private StaticValues staticValues;

    /*只能处理当前controller的异常*/
//    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return "error："+e.getMessage();
    }


    /*注册*/
    @PostMapping("/join")
    public Message SignUp(User user){
        /*非空校验，用户名、密码、Email不能为空*/
        if(user.getUserName() != null && user.getUserPassword() != null && user.getUserEmail() != null ) {
            /*检查邮箱格式*/
            if (user.getUserEmail().matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
                if (user.getUserPassword() != null) {
                    /*密码为空，加密时会报错*/
                    user.setUserPassword(DigestUtils.md5Hex(user.getUserPassword()));   //MD5加密，32位
                    userService.userRegistration(user);
                    return Message.success();

                } else
                    return Message.fail("密码不能为空");
            } else
                return Message.fail("邮箱格式错误");
        } else
            return Message.fail("属性不能为空");
    }

    /*账户激活，通过链接*/
    @GetMapping("/activate")
    public Message activate(User user){
//        System.out.println(user.getUserName()+user.getUserPassword());
//        return userService.updateStatus(user);
        userService.updateStatus(user);
        return Message.success();
    }



    /*登录*/
    @PostMapping("/signin")
    public Message login(User user, HttpSession session){
        /*非空校验*/
        if (user.getUserName() != null && user.getUserPassword() != null) {
            if (userService.checkStatus(user)) {    // 若账号为激活态
                //            System.out.println(user.getUserName());
                if (user.getUserPassword() != null) {
                    user.setUserPassword(DigestUtils.md5Hex(user.getUserPassword()));   //MD5加密，32位
                }
                //            System.out.println(user.getUserPassword());
                User user1 = userService.userLogin(user);
                if (user1 != null) {
                    //把用户信息存入session
                    session.setAttribute("userAccountId", user1.getUserId());
                    return Message.success().add("username", user1.getUserName());
                } else {
                    return Message.fail();
                }

                //            Integer a = user1.getUserId();  //ID由Integer转化成String
                //            String userId= new String();
                //            if (a != null){
                //                userId = a.toString();
                //            }

                //发送Cookie
                //            Cookie cookie1 = new Cookie("uaername", user1.getUserName()); //1,zhangsan
                //            Cookie cookie2 = new Cookie("password", user1.getUserPassword()); //1,zhangsan
                ////            cookie.setMaxAge();
                //            System.out.println(cookie.getValue());
                //            response.addCookie(cookie);
            } else {  //账号未激活
                return Message.fail();
            }
            ////        Session.Cookie cookie = new Session.Cookie();
            //        cookie.setName(user1.getUserName());
            //        cookie.set
        } else {
            return Message.fail("不能为空");
        }
    }

    @GetMapping("/signout")
    public Message signout(HttpSession session){
        Integer userId = (Integer) session.getAttribute("userAccountId");
        if (userId != null){
            session.removeAttribute("userAccountId");
            return Message.success();
        } else {
            return Message.fail();
        }
    }


    /**
     * @author zh
     * @date 2019/6/14/014 15:17
     * 校验字段 重复性
     */
    @GetMapping("/checkIfBeing")
    public Message checkIfBeing(String string){
        boolean b = userService.checkIfBeing(string);
        if (b)
            return Message.success();
        return Message.fail();
    }

    /*test*/
    @GetMapping("/findUser")
    public Message findUser(User user, HttpServletRequest request){
        System.out.println("==========");
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getRemoteAddr());
//        return new ResponseResult<>(0,"查询用户成功",userService.showUserById(user));
        return Message.success().add("user", userService.showUser(user));
    }

//    @GetMapping("/test")
//    public String  test(){
//        return "test";
//    }
//
//    @GetMapping("/help")
//    public String help() throws IllegalAccessException {
//        throw new IllegalAccessException("args is empty");
//    }


}
