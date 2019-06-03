package com.top.sstore.dao;

import com.top.sstore.pojo.Thirdsort;
import com.top.sstore.pojo.ThirdsortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdsortMapper {
    long countByExample(ThirdsortExample example);

    int deleteByExample(ThirdsortExample example);

    int deleteByPrimaryKey(Integer thirdId);

    int insert(Thirdsort record);

    int insertSelective(Thirdsort record);

    List<Thirdsort> selectByExample(ThirdsortExample example);

    Thirdsort selectByPrimaryKey(Integer thirdId);

    int updateByExampleSelective(@Param("record") Thirdsort record, @Param("example") ThirdsortExample example);

    int updateByExample(@Param("record") Thirdsort record, @Param("example") ThirdsortExample example);

    int updateByPrimaryKeySelective(Thirdsort record);

    int updateByPrimaryKey(Thirdsort record);
}