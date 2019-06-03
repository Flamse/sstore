package com.top.sstore.dao;

import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    long countByExample(PictureExample example);

    int deleteByExample(PictureExample example);

    int deleteByPrimaryKey(Integer pictureId);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    Picture selectByPrimaryKey(Integer pictureId);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}