package com.top.sstore.dao;

import com.top.sstore.pojo.Service;
import com.top.sstore.pojo.ServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceMapper {
    long countByExample(ServiceExample example);

    int deleteByExample(ServiceExample example);

    int deleteByPrimaryKey(Integer servId);

    int insert(Service record);

    int insertSelective(Service record);

    List<Service> selectByExample(ServiceExample example);

    Service selectByPrimaryKey(Integer servId);

    int updateByExampleSelective(@Param("record") Service record, @Param("example") ServiceExample example);

    int updateByExample(@Param("record") Service record, @Param("example") ServiceExample example);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);
}