package com.top.sstore.dao;

import com.top.sstore.pojo.Secondsort;
import com.top.sstore.pojo.SecondsortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondsortMapper {
    long countByExample(SecondsortExample example);

    int deleteByExample(SecondsortExample example);

    int deleteByPrimaryKey(Integer secondId);

    int insert(Secondsort record);

    int insertSelective(Secondsort record);

    List<Secondsort> selectByExample(SecondsortExample example);

    Secondsort selectByPrimaryKey(Integer secondId);

    int updateByExampleSelective(@Param("record") Secondsort record, @Param("example") SecondsortExample example);

    int updateByExample(@Param("record") Secondsort record, @Param("example") SecondsortExample example);

    int updateByPrimaryKeySelective(Secondsort record);

    int updateByPrimaryKey(Secondsort record);
}