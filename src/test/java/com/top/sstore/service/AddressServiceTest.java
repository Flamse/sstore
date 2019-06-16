package com.top.sstore.service;

import com.top.sstore.pojo.Address;
import com.top.sstore.pojo.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addAddress() {
    }

    @Test
    public void selectAddressOfAllById() {
    }

    @Test
    public void selectAddressById() {

        Address address = addressService.selectAddressById(1, 6);
        System.out.println(address.getAddressee());
    }

    @Test
    public void updateAddress() {
    }

    @Test
    public void deleteAddress() {
    }

    @Test
    public void selectProvince() {
        List<District> districts = addressService.selectProvince();
        for (District district : districts){
            System.out.println(district.getName());
        }
    }

    @Test
    public void selectCity() {
    }

    @Test
    public void selectCounty() {
    }
}