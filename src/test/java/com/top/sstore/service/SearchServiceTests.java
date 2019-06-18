package com.top.sstore.service;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Service;
import com.top.sstore.pojo.ServiceLabel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTests {
    @Autowired
    private ISearchService searchService;
    @Autowired
    private IServiceService serviceService;

    @Test
    public void selectLabelByNameTest(){
//        List<String> list = new ArrayList<>();
//        list.add("小米");
//        list.add("电视");
//        System.out.println(list);
        List<Integer> integers = searchService.selectLabelByName("小米");
//        for (Integer integer : integers){
//            System.out.println(integer);
//        }
        List<ServiceLabel> labels = searchService.selectLabel(integers);

        if (labels.size() != 0)
            for (ServiceLabel label : labels){
                System.out.println(label.getLabelName());
            }
    }

    @Test
    public void resolveLabelTest(){
        List<Integer> list = searchService.resolveLabel(3);
        for (Integer labelId : list){
            System.out.println(labelId);
        }
    }

    @Test
    public void searchTest(){
        List<String> list = new ArrayList<>();
        list.add("小米");
        list.add("创维");
        PageInfo<Service> services = searchService.selectServiceByLabel(list, 1);
        for (Service service : services.getList()){
            System.out.println(service.getServId());
        }
    }

    @Test
    public void selectLabelnameByServiceIdTest(){
        List<String> list = searchService.selectLabelnameByServiceId(3);
        for (String s : list){
            System.out.println(s.toString());
        }
    }

    @Test
    public void selectServiceByLabelTest(){
        List<String> list = new ArrayList<>();
        list.add("tcl");
//        list.add("65英寸");
        PageInfo info = searchService.selectServiceByLabel(list, 1);
        for (Service service : (List<Service>)info.getList()){
            serviceService.linkLabelToName(service);
            System.out.println(service.getLabelId()+service.getServId());
        }
    }

}
