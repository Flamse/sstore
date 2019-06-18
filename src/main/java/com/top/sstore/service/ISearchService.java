package com.top.sstore.service;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Service;
import com.top.sstore.pojo.ServiceLabel;

import java.util.List;

public interface ISearchService {

    /**
     * @author zh
     * @date 2019/6/10/010 9:22
     * 查找标签通过 标签名（字符匹配）
     */
    List<Integer> selectLabelByName(String labelName);

    /**
     * @author zh
     * @date 2019/6/10/010 14:45
     * 查询索引通过 标签
     */
    List<Integer> selectIndexByLabel(List<Integer> labelIds);

    /**
     * @author zh
     * @date 2019/6/6/006 20:25
     * 查找商品通过标签（模糊查询，单个关键词）
     */
    PageInfo<Service> selectServiceByLabel(List<String> labelBits, Integer pageNum);

    /**
     * @author zh
     * @date 2019/6/11/011 8:22
     * 分解标签 通过商品ID
     */
    List<Integer> resolveLabel(Integer serviceId);

    /**
     * @author zh
     * @date 2019/6/11/011 9:41
     * 查找标签名 通过商品ID（用于拼接商品名）
     */
    List<String> selectLabelnameByServiceId(Integer serviceId);

    /**
     * @author zh
     * @date 2019/6/10/010 9:23
     * 增加标签
     */
    boolean addLabel(ServiceLabel label);

    List<ServiceLabel> selectLabel(List<Integer> labelId);

    /**
     * @author zh
     * @date 2019/6/10/010 16:42
     * 更新索引表
     */


}
