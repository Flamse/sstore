package com.top.sstore.controller;

import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.ISearchService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;
    @Autowired
    private ISearchService searchService;
    @Autowired
    private IPictureService pictureService;

    /*搜索框 查询*/
    @GetMapping("/search")
    public Message getServiceByLabel(String label, String orderBy, Integer pageNum){
        String[] labelBits = label.split(" ");
//        List<String> labelss = Arrays.stream(labels).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        List<String> labels = Arrays.asList(labelBits); //数组转List
//        System.out.println(labels);
        PageInfo<Service> servicePageInfo = searchService.selectServiceByLabel(labels, pageNum, orderBy);
//        List<Integer> serviceId = servicePageInfo.getList().stream().map(Service::getServId).collect(Collectors.toList());

        List<Picture> pictures=new ArrayList<>();
        for (Service service : servicePageInfo.getList()){
            Picture picture = pictureService.selectDefaultPicture(service.getServId());
            pictures.add(picture);
        }

        return Message.success().add("servicePageInfo", servicePageInfo).add("pictures",pictures);
    }

    /*展示商品详情*/
    @GetMapping("/show")
    public Message getServiceById(Integer serviceId){
        Service service = serviceService.selectServiceById(serviceId);
        List<Picture> picture = pictureService.selectPictureByServid(service.getServId());
        return Message.success().add("service", service).add("picture", picture);
    }

    /*test*/
//    @GetMapping("/test1")
    public Message test1(){
        return Message.success().add("time", new Date());
    }

    /*显示一级分类下的所有商品*/
    @GetMapping("/firstOfAll")
    public Message getAllServiceByFirst(Integer firstsortId, Integer pageNum ){
        PageInfo<Service> servicePageInfo = serviceService.selectServiceByFirstsort(firstsortId, pageNum);

        List<Picture> pictures=new ArrayList<>();
        for (Service service : servicePageInfo.getList()){
            Picture picture = pictureService.selectDefaultPicture(service.getServId());
            pictures.add(picture);
        }

        return Message.success().add("servicePageInfo", servicePageInfo).add("pictures",pictures);
    }

    /*显示二级分类下的所有商品*/
    @GetMapping("/secondOfAll")
    public Message getAllServiceBySecond(Integer secondsortId, Integer pageNum){
        PageInfo<Service> servicePageInfo = serviceService.selectServiceBySecondsort(secondsortId, pageNum);

        /* 传送图片 */
        List<Picture> pictures=new ArrayList<>();
        for (Service service : servicePageInfo.getList()){
            Picture picture = pictureService.selectDefaultPicture(service.getServId());
            pictures.add(picture);
        }

        return Message.success().add("servicePageInfo", servicePageInfo).add("pictures",pictures);
    }

    /*显示三级分类下的所有商品*/
    @GetMapping("/thirdOfAll")
    public Message getAllServiceByThird(Integer thirdsortId, Integer pageNum){
//        PageHelper.startPage(1);
        PageInfo<Service> servicePageInfo = serviceService.selectServiceByThirdsort(thirdsortId, pageNum);
//        PageInfo<Service> pageInfo = new PageInfo(services, 10);
//        return Message.success().add("service", pageInfo);

        List<Picture> pictures=new ArrayList<>();
        for (Service service : servicePageInfo.getList()){
            Picture picture = pictureService.selectDefaultPicture(service.getServId());
            pictures.add(picture);
        }

        return Message.success().add("servicePageInfo", servicePageInfo).add("pictures",pictures);
    }
}
