package com.top.sstore.service.impl;

import com.top.sstore.dao.AddressMapper;
import com.top.sstore.dao.DistrictMapper;
import com.top.sstore.pojo.Address;
import com.top.sstore.pojo.AddressExample;
import com.top.sstore.pojo.District;
import com.top.sstore.pojo.DistrictExample;
import com.top.sstore.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public boolean addAddress(Address address, Integer userId) {

        address.setUserId(userId);
        address.setAddressStatus(0);

        Integer a = addressMapper.insertSelective(address);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public List<Address> selectAddressOfAllById(Integer userId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andAddressStatusEqualTo(0);
        List<Address> addresses = addressMapper.selectByExample(example);
        return addresses;
    }

    @Override
    public Address selectAddressById(Integer addressId, Integer userId) {
        AddressExample example = new AddressExample();

        example.createCriteria().andUserIdEqualTo(userId).andAddressIdEqualTo(addressId);

        List<Address> addresses = addressMapper.selectByExample(example);
        return addresses.get(0);
    }

    @Override
    public boolean updateAddress(Address address, Integer userId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andAddressIdEqualTo(address.getAddressId()).andUserIdEqualTo(userId);
        Integer a = addressMapper.updateByExampleSelective(address, example);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteAddress(Integer addressId, Integer userId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andAddressIdEqualTo(addressId).andUserIdEqualTo(userId);

        Address address = new Address();
        address.setAddressStatus(1);
        int a = addressMapper.updateByExampleSelective(address, example);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public List<District> selectProvince() {
        DistrictExample example = new DistrictExample();
//        short i = 0;
//        Short aShort = new Short(i);
//        short aShort = 0;
        example.createCriteria().andParentIdEqualTo((short)0);
        List<District> districts = districtMapper.selectByExample(example);
        return districts;
    }

    @Override
    public List<District> selectCity(Short provinceId) {
        DistrictExample districtExample = new DistrictExample();
        districtExample.createCriteria().andParentIdEqualTo(provinceId);
        List<District> districts = districtMapper.selectByExample(districtExample);
        return districts;
    }

    @Override
    public List<District> selectCounty(Short cityId) {
        DistrictExample districtExample = new DistrictExample();
        districtExample.createCriteria().andParentIdEqualTo(cityId);
        List<District> districts = districtMapper.selectByExample(districtExample);
        return districts;
    }
}