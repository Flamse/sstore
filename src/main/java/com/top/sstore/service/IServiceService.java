package com.top.sstore.service;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Service;

import java.util.List;

public interface IServiceService {

    /**
     * @author zh
     * @date 2019/6/11/011 16:28
     * 拼接商品名（根据商品ID）
     */
    Service linkLabelToName(Service service);

    /**
     * @author zh
     * @date 2019/6/6/006 20:24
     * 查找所有商品
     */
    PageInfo<Service> selectServiceOfAll(Integer pageNum);

    /**
     * @author zh
     * @date 2019/6/6/006 20:24
     * 查找所有商品 通过ID群，购物车
     */
    List<Service> selectServiceOfAllByIds(List<Integer> serviceIds);

    /**
     * @author zh
     * @date 2019/6/6/006 20:24
     * 查找所有商品 通过ID群
     */
    PageInfo<Service> selectServiceOfAllByIds(List<Integer> serviceIds, Integer pageNum, String orderBy);

    /**
     * @author zh
     * @date 2019/6/6/006 20:24
     * 查找商品通过ID
     */
    Service selectServiceById(Integer serviceId);

    /**
     * @author zh
     * @date 2019/6/6/006 20:25
     * 查找商品通过一级分类
     */
    PageInfo<Service>  selectServiceByFirstsort(Integer firstsortId, Integer pageNum);

    /**
     * @author zh
     * @date 2019/6/6/006 20:25
     * 查找商品通过二级标签
     */
    PageInfo<Service> selectServiceBySecondsort(Integer secondtsortId, Integer pageNum);

    /**
     * @author zh
     * @date 2019/6/6/006 20:25
     * 查找商品通过三级标签
     */
    PageInfo<Service> selectServiceByThirdsort(Integer thirdsortId, Integer pageNum);

    /**
     * @author zh
     * @date 2019/6/11/011 21:53
     * 添加商品
     *  太复杂了。。。图片没有上传
     */
    boolean addService(Service service);

    /**
     * @author zh
     * @date 2019/6/11/011 21:54
     * 修改商品
     * 一样一样
     */
    boolean updateServNum(Integer serviceId, Integer servVolume);

    Integer selectServNum(Integer serviceId);

    /**
     * @author zh
     * @date 2019/6/11/011 21:56
     * 删除商品 通过商品ID（下架）
     */
    boolean deleteService(Integer serviceId);
}
