package com.top.sstore.service.impl;

import com.github.pagehelper.PageInfo;
import com.top.sstore.dao.IndexMapper;
import com.top.sstore.dao.ServiceLabelMapper;
import com.top.sstore.dao.ServiceMapper;
import com.top.sstore.pojo.*;
import com.top.sstore.service.ISearchService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@org.springframework.stereotype.Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ServiceLabelMapper labelMapper;
    @Autowired
    private IndexMapper indexMapper;
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private ISearchService searchService;
    @Autowired
    private StaticValues staticValues;
    @Autowired
    private IServiceService serviceService;

    @Override
    public List<Integer> selectLabelByName(String labelName) {

//        List<ServiceLabel> labels = new ArrayList<>();
//            System.out.println(labelName);
        ServiceLabelExample labelExample = new ServiceLabelExample();
        labelExample.createCriteria().andLabelNameLike("%"+labelName+"%");
        List<ServiceLabel> labels = labelMapper.selectByExample(labelExample);
//        if (labels1.size() == 0)
//            continue;

        /*并集*/
//            if (labels.size() == 0) {
//                labels.addAll(labels1);
//            }
//            else {
//                labels.retainAll(labels1);
//            }
        /*合集*/
//        labels.removeAll(labels1);  //去重复
//        labels.addAll(labels1);
//            for (ServiceLabel label : labels1) {
//                System.out.println(label.getLabelName());
//            }

        /*去重复*/
//        labels = new ArrayList<ServiceLabel>(new LinkedHashSet<>(labels));

        //提取数字串
        List<Integer> labelIds = labels.stream().map(ServiceLabel::getLabelId).collect(Collectors.toList());
        return labelIds;
    }

    @Override
    public List<Integer> selectIndexByLabel(List<Integer> labelIds) {
        IndexExample indexExample = new IndexExample();
        indexExample.createCriteria().andLabelIdIn(labelIds);
        /*有重复*/
        List<Index> indices = indexMapper.selectByExample(indexExample);
        List<Integer> serviceIds = indices.stream().map(Index::getServId).collect(Collectors.toList());
        return serviceIds;
    }

    @Override
    public PageInfo<Service> selectServiceByLabel(List<String> labelBits, Integer pageNum, String orderBy) {
        List<Integer> serviceIds = new ArrayList<>();
        for (String label : labelBits) {
            //初步匹配标签
            List<Integer> labels = searchService.selectLabelByName(label);
            //查询索引
            List<Integer> serviceIds1 = searchService.selectIndexByLabel(labels);
            //查询商品
//            ServiceExample example = new ServiceExample();
//            example.createCriteria().andServIdIn(serviceIds);
            //分页
//            PageHelper.startPage(pageNum, staticValues.getPageSizeBySort());
//            List<Service> services1 = serviceMapper.selectByExample(example);
            /*去重复*/
//            serviceIds1 = new ArrayList<Integer>(new LinkedHashSet<>(serviceIds));
//            for (Service service : services1)
//                System.out.println(service.getServId());
//            System.out.println("========");

            if (serviceIds.size() == 0)
                serviceIds.addAll(serviceIds1);
            else
                serviceIds.retainAll(serviceIds1);  //取交集
//                services.retainAll(services1);    //对象求交集，永远没有交集
        }

        PageInfo<Service> services = serviceService.selectServiceOfAllByIds(serviceIds, pageNum, orderBy);
        /*循环替换*/
        for (Service service : services.getList()){
            serviceService.linkLabelToName(service);
        }
        return services;
    }

    @Override
    public List<Integer> resolveLabel(Integer serviceId) {
        Service service = serviceMapper.selectByPrimaryKey(serviceId);
        String label = service.getLabelId();
        //以逗号为分隔
        String[] labelbits = label.split(",");
        List<Integer> labels = Arrays.stream(labelbits).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        return labels;
    }

    @Override
    public List<String> selectLabelnameByServiceId(Integer serviceId) {
        List<Integer> labelIds = searchService.resolveLabel(serviceId);
        ServiceLabelExample example = new ServiceLabelExample();
//        System.out.println(labelIds);

        /*商品名 乱序， order in 排序*/
        String s="";
        for (Integer labelId : labelIds ) {
            s+=(","+labelId);
        }
        example.setOrderByClause("field(label_id"+s+")");
//        System.out.println("field(label_id"+s+")");
        example.createCriteria().andLabelIdIn(labelIds);

        List<ServiceLabel> labels = labelMapper.selectByExample(example);
        List<String> list = labels.stream().map(ServiceLabel::getLabelName).collect(Collectors.toList());
        return list;
    }

    @Override
    public boolean addLabel(ServiceLabel label) {
        int a = labelMapper.insertSelective(label);
        if (a == 1)
            return true;
        return false;
    }

    @Override
    public List<ServiceLabel> selectLabel(List<Integer> labelId) {
        ServiceLabelExample example = new ServiceLabelExample();
        example.createCriteria().andLabelIdIn(labelId);
        List<ServiceLabel> list = labelMapper.selectByExample(example);
        return list;
    }

}
