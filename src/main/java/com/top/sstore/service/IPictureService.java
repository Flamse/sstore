package com.top.sstore.service;

import com.top.sstore.pojo.Picture;

import java.util.List;

public interface IPictureService {

    List<Picture> selectPictureByServid(Integer serviceId);

    Picture selectDefaultPicture(Integer serviceId);

    List<Picture> selectDefaultPicture(List<Integer> serviceId);

    List<Picture> selectPictureByServids(List<Integer> serviceIds);

}
