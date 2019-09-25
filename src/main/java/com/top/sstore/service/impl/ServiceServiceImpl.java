package com.top.sstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.top.sstore.dao.ServiceMapper;
import com.top.sstore.pojo.Service;
import com.top.sstore.pojo.ServiceExample;
import com.top.sstore.service.ISearchService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.service.ISortService;
import com.top.sstore.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private ISortService sortService;
    @Autowired
    private ISearchService searchService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private StaticValues staticValues;

    /*需要AOP的支持，或者手动添加*/
    @Override
    public Service linkLabelToName(Service service) {
        List<String> labelName = searchService.selectLabelnameByServiceId(service.getServId()); //  提取标签名
        /*https://blog.csdn.net/benben683280/article/details/78716295*/
        String s = labelName.stream().collect(Collectors.joining(" "));     //拼接成商品名

        //转换
        service.setLabelId(s);
        return service;
    }

    @Override
    public PageInfo<Service> selectServiceOfAll(Integer pageNum) {
        PageHelper.startPage(pageNum, staticValues.getPageSizeBySort());
        List<Service> services = serviceMapper.selectByExample(new ServiceExample());
//        services.stream().collect(Collectors.toSet(serviceService.linkLabelToName(services)));
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }
        PageInfo<Service> pageInfo = new PageInfo<>(services);
        return pageInfo;
    }

    /**
     * @param serviceIds
     * @author zh
     * @date 2019/6/6/006 20:24
     * 查找所有商品 通过ID群，购物车
     */
    @Override
    public List<Service> selectServiceOfAllByIds(List<Integer> serviceIds) {
        ServiceExample example = new ServiceExample();

        /*购物车 排序问题*/
        example.createCriteria().andServIdIn(serviceIds);

//        PageHelper.startPage(pageNum, staticValues.getPageSizeByCart());
        List<Service> services = serviceMapper.selectByExample(example);
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }
//        PageInfo<Service> pageInfo = new PageInfo<>(services);
//        return pageInfo;
        return services;
    }

    @Override
    public PageInfo<Service> selectServiceOfAllByIds(List<Integer> serviceIds, Integer pageNum, String orderBy) {
        ServiceExample example = new ServiceExample();

        example.setOrderByClause(orderBy);  //排序
        example.createCriteria().andServIdIn(serviceIds);

        PageHelper.startPage(pageNum, staticValues.getPageSizeBySearch());
        List<Service> services = serviceMapper.selectByExample(example);
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }
        PageInfo<Service> pageInfo = new PageInfo<>(services);
        return pageInfo;
    }

    @Override
    public Service selectServiceById(Integer serviceId) {
        Service service = serviceMapper.selectByPrimaryKey(serviceId);
        if (service != null)
            return serviceService.linkLabelToName(service);
        return null;
    }

    @Override
    public PageInfo<Service> selectServiceByFirstsort(Integer firstsortId, Integer pageNum) {
        List<Integer> secondIds = sortService.selectAllSecondIdByFirst(firstsortId);
        List<Integer> thirdIds = sortService.selectAllThirdIdByAllSecond(secondIds);

        ServiceExample example = new ServiceExample();
        example.createCriteria().andThirdIdIn(thirdIds);

        PageHelper.startPage(pageNum, staticValues.getPageSizeBySort());
        List<Service> services = serviceMapper.selectByExample(example);
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }
        PageInfo<Service> pageInfo = new PageInfo<>(services);
        return pageInfo;
    }

    @Override
    public PageInfo<Service> selectServiceBySecondsort(Integer secondtsortId, Integer pageNum) {
        List<Integer> thirdsortList = sortService.selectAllThirdIdBySecond(secondtsortId);
        ServiceExample example = new ServiceExample();
        example.createCriteria().andThirdIdIn(thirdsortList);

        PageHelper.startPage(pageNum, staticValues.getPageSizeBySort());
        List<Service> services = serviceMapper.selectByExample(example);
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }

        PageInfo<Service> pageInfo = new PageInfo<>(services);
        return pageInfo;
    }

    @Override
    public PageInfo<Service> selectServiceByThirdsort(Integer thirdsortId, Integer pageNum) {
        ServiceExample example = new ServiceExample();
        example.createCriteria().andThirdIdEqualTo(thirdsortId);

        PageHelper.startPage(pageNum, staticValues.getPageSizeBySort());
        List<Service> services = serviceMapper.selectByExample(example);
        /*循环替换*/
        for (Service service : services){
            serviceService.linkLabelToName(service);
        }

        PageInfo<Service> pageInfo = new PageInfo<>(services);
        return pageInfo;
    }

    @Override
    public boolean addService(Service service) {

        return false;
    }

    @Override
    public boolean updateServNum(Integer serviceId, Integer servVolume) {
        Service service = new Service();
        service.setServVolume(servVolume);

        ServiceExample example = new ServiceExample();
        example.createCriteria().andServIdEqualTo(serviceId);
        int a = serviceMapper.updateByExampleSelective(service, example);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public Integer selectServNum(Integer serviceId) {
        ServiceExample example = new ServiceExample();
        example.createCriteria().andServIdEqualTo(serviceId);
        List<Service> services = serviceMapper.selectByExample(example);
        return services.get(0).getServVolume();
    }

    /**
     * @author zh
     * @date 2019/6/11/011 21:57
     *
     */
    @Override
    public boolean deleteService(Integer serviceId) {
        ServiceExample example = new ServiceExample();
        example.createCriteria().andServIdEqualTo(serviceId);

        Service service = new Service();
        service.setServStatus(staticValues.getServiceOutstock());

        int a = serviceMapper.updateByExampleSelective(service, example);
        if (a == 1)
            return true;
        return false;
    }
}
