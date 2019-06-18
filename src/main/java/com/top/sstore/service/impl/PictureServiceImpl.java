package com.top.sstore.service.impl;

import com.top.sstore.dao.PictureMapper;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.PictureExample;
import com.top.sstore.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> selectPictureByServid(Integer serviceId) {
        PictureExample example = new PictureExample();
        example.createCriteria().andServIdEqualTo(serviceId);
        List<Picture> pictures = pictureMapper.selectByExample(example);
        return pictures;
    }

    @Override
    public Picture selectDefaultPicture(Integer serviceId) {
        PictureExample example = new PictureExample();
        //  1为默认图片
        example.createCriteria().andServIdEqualTo(serviceId).andPictureTypeEqualTo(1);
        List<Picture> pictures = pictureMapper.selectByExample(example);
        Picture picture = pictures.get(0);
        return picture;
    }

    @Override
    public List<Picture> selectDefaultPicture(List<Integer> serviceId) {
        PictureExample example = new PictureExample();
        //  1为默认图片
        example.createCriteria().andServIdIn(serviceId).andPictureTypeEqualTo(1);
        List<Picture> pictures = pictureMapper.selectByExample(example);
        return pictures;
    }

    @Override
    public List<Picture> selectPictureByServids(List<Integer> serviceIds) {
        PictureExample example = new PictureExample();
        example.createCriteria().andServIdIn(serviceIds).andPictureTypeEqualTo(1);
//        example.createCriteria().andPictureIdIn(serviceIds).andPictureTypeEqualTo(1);
        List<Picture> pictures = pictureMapper.selectByExample(example);
        return pictures;
    }
}
