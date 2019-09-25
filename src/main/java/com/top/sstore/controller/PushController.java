package com.top.sstore.controller;

import com.top.sstore.pojo.Activity;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.Recommend;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.IPushService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/push")
public class PushController {
    @Autowired
    private IPushService pushService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IPictureService pictureService;

    /*首页展示*/
    @GetMapping("/recommend")
    public Message recommend(Integer type){
        List<Recommend> recommends =  pushService.selectRecommend(type);
        if (recommends.size() >= 0){
            List<Integer> serviceIds = recommends.stream().map(Recommend::getServId).collect(Collectors.toList());
            List<Service> services = serviceService.selectServiceOfAllByIds(serviceIds);
            List<Picture> pictures = pictureService.selectDefaultPicture(serviceIds);
            return Message.success().add("recommends", recommends).add("services", services).add("pictures", pictures);
        }
        else
            return Message.fail("类型无效");
    }

    @GetMapping("/activity")
    public Message activity(){
        List<Activity> activities = pushService.selectActivity();
        if (activities.size() >= 0)
            return Message.success().add("activities",activities);
        else
            return Message.fail("错误");
    }
}
