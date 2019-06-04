package com.top.sstore.dao;

import com.top.sstore.pojo.ServiceLabel;
import com.top.sstore.pojo.ServiceLabelExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceLabelMapper {

//    @Autowired
//    private ServiceLabelMapper userMapper;
    @Autowired
    private ServiceLabelMapper serviceLabelMapper;
//    @Autowired
//    private ServiceLabelExample example;
//    @Autowired
//    private ServiceLabelExample.Criteria ServiceLabelExampleCriteria;

    @Test
    public void test1(){
//        List<ServiceLabel> serviceLabelList= serviceLabelMapper.selectByExample(new ServiceLabelExample());
//        for (ServiceLabel serviceLable:
//                serviceLabelList ) {
//            System.out.println(serviceLable.getLabelName()+","+serviceLable.getSalerId());
//        }

        /*条件查询有效；参考https://blog.csdn.net/leyili_s/article/details/79721592*/
        ServiceLabelExample example = new ServiceLabelExample();
//        ServiceLabelExample.Criteria criteria = example.createCriteria();
        //查询条件
        example.or().andLabelNameEqualTo("aaa");
        example.or().andSalerIdEqualTo(2);

        //        criteria.andLabelNameEqualTo("aaa");
//        criteria.andSalerIdEqualTo(2);

        //这步看不懂
        List<ServiceLabel> serviceLabels = serviceLabelMapper.selectByExample(example);
        for (ServiceLabel serviceLabel: serviceLabels){
            System.out.println("条件查询"+serviceLabel.getLabelName());
        }
        System.out.println("labelName的数量："+serviceLabelMapper.countByExample(example));

//        System.out.println("################"+new ServiceLabelExample().createCriteria().andLabelNameEqualTo("bbb"));

//        System.out.println(serviceLabelMapper.selectByExample(new ServiceLabelExample()).size());
//        System.out.println(serviceLabelMapper.countByExample(new ServiceLabelExample()));
//        serviceLabelMapper.countByExample(serviceLabelExample);
//        System.out.println(serviceLabelExample.getOredCriteria());
//        serviceLabelMapper.countByExample(example.getOrderByClause().andLabelNameEqualTo("aaa"));
//        System.out.println(example.createCriteria(ServiceLabel.class).andLabelNameEqualTo("aaa").getCriteria().size());
    }

    @Test
    public void TestExample(){
        ServiceLabel serviceLabel = new ServiceLabel();
        serviceLabel.setSalerId(0);
        serviceLabel.setLabelName("台式电脑");
        int a = serviceLabelMapper.insert(serviceLabel);
        //插入成功，返回1
        System.out.println("=========================:"+a);
    }
}
