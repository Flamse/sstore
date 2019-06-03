package com.top.sstore.dao;

import com.top.sstore.pojo.District;
import com.top.sstore.pojo.DistrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictMapper {
    long countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(Short disrictId);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Short disrictId);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}