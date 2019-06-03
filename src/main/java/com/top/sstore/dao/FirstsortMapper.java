package com.top.sstore.dao;

import com.top.sstore.pojo.Firstsort;
import com.top.sstore.pojo.FirstsortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstsortMapper {
    long countByExample(FirstsortExample example);

    int deleteByExample(FirstsortExample example);

    int deleteByPrimaryKey(Integer firstId);

    int insert(Firstsort record);

    int insertSelective(Firstsort record);

    List<Firstsort> selectByExample(FirstsortExample example);

    Firstsort selectByPrimaryKey(Integer firstId);

    int updateByExampleSelective(@Param("record") Firstsort record, @Param("example") FirstsortExample example);

    int updateByExample(@Param("record") Firstsort record, @Param("example") FirstsortExample example);

    int updateByPrimaryKeySelective(Firstsort record);

    int updateByPrimaryKey(Firstsort record);
}