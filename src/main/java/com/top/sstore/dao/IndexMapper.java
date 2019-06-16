package com.top.sstore.dao;

import com.top.sstore.pojo.Index;
import com.top.sstore.pojo.IndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexMapper {
    long countByExample(IndexExample example);

    int deleteByExample(IndexExample example);

    int deleteByPrimaryKey(Integer indexId);

    int insert(Index record);

    int insertSelective(Index record);

    List<Index> selectByExample(IndexExample example);

    Index selectByPrimaryKey(Integer indexId);

    int updateByExampleSelective(@Param("record") Index record, @Param("example") IndexExample example);

    int updateByExample(@Param("record") Index record, @Param("example") IndexExample example);

    int updateByPrimaryKeySelective(Index record);

    int updateByPrimaryKey(Index record);
}