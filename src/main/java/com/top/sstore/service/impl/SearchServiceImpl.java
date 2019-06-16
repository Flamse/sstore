package com.top.sstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.top.sstore.dao.IndexMapper;
import com.top.sstore.dao.ServiceLabelMapper;
import com.top.sstore.dao.ServiceMapper;
import com.top.sstore.pojo.*;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.ISearchService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private IPictureService pictureService;

    @Override
    public List<Integer> selectLabelByName(String labelName) {

        ServiceLabelExample labelExample = new ServiceLabelExample();
        labelExample.createCriteria().andLabelNameLike("%"+labelName+"%");
        //只需要数字串即可
        List<ServiceLabel> labels = labelMapper.selectByExample(labelExample);
        List<Integer> labelIds = labels.stream().map(ServiceLabel::getLabelId).collect(Collectors.toList());

        return labelIds;
    }

    @Override
    public List<Integer> selectIndexByLabel(List<Integer> labelIds) {
        IndexExample indexExample = new IndexExample();
        indexExample.createCriteria().andLabelIdIn(labelIds);
        List<Index> indices = indexMapper.selectByExample(indexExample);
        List<Integer> serviceIds = indices.stream().map(Index::getServId).collect(Collectors.toList());
        return serviceIds;
    }

    @Override
    public PageInfo<Service> selectServiceByLabel(String label, Integer pageNum) {
        //初步匹配标签
        List<Integer> libels = searchService.selectLabelByName(label);
        //查询索引
        List<Integer> serviceIds = searchService.selectIndexByLabel(libels);
        //查询商品
        ServiceExample example = new ServiceExample();
        example.createCriteria().andServIdIn(serviceIds);

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
        for (Integer labelId:
            labelIds ) {
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
        if (a == 1){
            return true;
        }
        return false;
    }

}
