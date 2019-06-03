package com.top.sstore.dao;

import com.top.sstore.pojo.ServiceLabel;
import com.top.sstore.pojo.ServiceLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceLabelMapper {
    long countByExample(ServiceLabelExample example);

    int deleteByExample(ServiceLabelExample example);

    int deleteByPrimaryKey(Integer labelId);

    int insert(ServiceLabel record);

    int insertSelective(ServiceLabel record);

    List<ServiceLabel> selectByExample(ServiceLabelExample example);

    ServiceLabel selectByPrimaryKey(Integer labelId);

    int updateByExampleSelective(@Param("record") ServiceLabel record, @Param("example") ServiceLabelExample example);

    int updateByExample(@Param("record") ServiceLabel record, @Param("example") ServiceLabelExample example);

    int updateByPrimaryKeySelective(ServiceLabel record);

    int updateByPrimaryKey(ServiceLabel record);
}