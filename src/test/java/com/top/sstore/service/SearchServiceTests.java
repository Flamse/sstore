package com.top.sstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTests {
    @Autowired
    private ISearchService searchService;

    @Test
    public void resolveLabelTest(){
        List<Integer> list = searchService.resolveLabel(3);
        for (Integer labelId : list){
            System.out.println(labelId);
        }
    }

    @Test
    public void searchTest(){
//        List<Service> services = searchService.selectServiceByLabel("小米");
//        for (Service service : services){
//            System.out.println(service.getServId());
//        }
    }

    @Test
    public void selectLabelnameByServiceIdTest(){
        List<String> list = searchService.selectLabelnameByServiceId(3);
        for (String s : list){
            System.out.println(s.toString());
        }
    }

}
