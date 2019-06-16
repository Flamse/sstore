package com.top.sstore.service;

import com.top.sstore.pojo.Address;
import com.top.sstore.pojo.District;

import java.util.List;

public interface IAddressService {

    /**
     * @author zh
     * @date 2019/6/6/006 20:59
     * 添加地址
     */
    boolean addAddress(Address address, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 20:59
     * 查找所有地址 通过用户ID
     */
    List<Address> selectAddressOfAllById(Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 20:57
     * 查找单个地址通过 地址ID + 用户ID（校验）
     */
    Address selectAddressById(Integer addressId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 20:59
     * 修改地址内容
     */
    boolean updateAddress(Address address, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 21:01
     * 删除地址通过 地址ID + 用户ID（校验）
     */
    boolean deleteAddress(Integer addressId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 23:18
     * 按省查询
     */
    List<District> selectProvince();

    /**
     * @author zh
     * @date 2019/6/6/006 23:27
     * 按市查询
     */
    List<District> selectCity(Short provinceId);

    /**
     * @author zh
     * @date 2019/6/6/006 23:27
     * 按县查询
     */
    List<District> selectCounty(Short cityId);

}
