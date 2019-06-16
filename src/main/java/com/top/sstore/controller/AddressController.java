package com.top.sstore.controller;

import com.top.sstore.pojo.Address;
import com.top.sstore.pojo.District;
import com.top.sstore.service.IAddressService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping("/show")
    public Message show(HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        List<Address> addresses =  addressService.selectAddressOfAllById(userId);
        return Message.success().add("addresses", addresses);
    }

    @GetMapping("/showById")
    public Message showById(Integer addressId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        Address address = addressService.selectAddressById(addressId, userId);
        if (address != null){
            return Message.success().add("address", address);
        }
        return Message.fail();
    }

    @PostMapping("/add")
    public Message addAddress(Address address, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = addressService.addAddress(address, userId);
        if (b){ //添加成功
            return Message.success();
        }
        return Message.fail();
    }

    @PostMapping("/update")
    public Message updateAddress(Address address, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userAccountId");
        boolean b = addressService.updateAddress(address, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/delete")
    public Message deleteAddress(Integer addressId, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userAccountId");
        boolean b = addressService.deleteAddress(addressId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }


    @GetMapping("/province")
    public Message findProvince(){
        List<District> districts = addressService.selectProvince();
        return Message.success().add("districts", districts);
    }

    @GetMapping("/city")
    public Message findCity(Short provinceId){
        List<District> districts = addressService.selectCity(provinceId);
        return Message.success().add("city", districts);
    }

    @GetMapping("/county")
    public Message findCounty(Short cityId){
        List<District> districts = addressService.selectCounty(cityId);
        return Message.success().add("county", districts);
    }
}
