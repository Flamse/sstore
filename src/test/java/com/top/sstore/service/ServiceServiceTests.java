package com.top.sstore.service;

import com.top.sstore.pojo.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceServiceTests {
    @Autowired
    private IServiceService serviceService;

    @Test
    public void linkLabelToNameTest(){
        Service service = new Service();
        service.setServId(1);
        service = serviceService.linkLabelToName(service);
        System.out.println(service.getLabelId());
    }

    @Test
    public void selectServiceByIdTest(){
//        Service service = serviceService.selectServiceById(2);
        Service service = serviceService.selectServiceById(999);
//        if (service != null)
            System.out.println(service.getLabelId());
//        System.out.println("没找到");
    }

    @Test
    public void selectServiceOfAllTest(){
//        List<Service> services = serviceService.selectServiceOfAll();
//        for (Service service : services){
//            System.out.println(service.getServId()+service.getLabelId());
//        }
    }

    @Test
    public void selectServiceByFirstsortTest(){
//        List<Service> services = serviceService.selectServiceByFirstsort(1);
        //System.out.println(pageInfo.getList());
    }

    @Test
    public void selectServiceByThirdsortTest(){
//        List<Service> services = serviceService.selectServiceByThirdsort(3);
//        for (Service service : services){
//            System.out.println(service.getServDescribe());
//        }
    }
}
