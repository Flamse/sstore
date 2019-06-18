package com.top.sstore.controller;

import com.top.sstore.pojo.Firstsort;
import com.top.sstore.pojo.Secondsort;
import com.top.sstore.pojo.Thirdsort;
import com.top.sstore.service.ISortService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private ISortService sortService;

    @GetMapping("/firstOfGetAll")
    public Message getAllFirst(){
//       System.out.println("==========");
////        System.out.println(request.getRequestURI());
////        System.out.println(request.getRequestURL());
////        System.out.println(request.getContextPath());
////        System.out.println(request.getServletPath());
////        System.out.println(request.getRemoteAddr());
        List<Firstsort> firstsortList = sortService.selectAllFirst();
        return Message.success().add("firstsortAboutAll",firstsortList);
    }

    @PostMapping("/firstOfRename")
    public Message renameFirstsort(Firstsort firstsort){
        if (sortService.updateFirstById(firstsort))
            return Message.success();
        return Message.fail();
    }

    @PostMapping("/firstOfAdd")
    public Message addFirst(Firstsort firstsort){
        if (sortService.addFirstsort(firstsort))
            return Message.success();
        return Message.fail();
    }

    /*二级*/
    @GetMapping("/secondOfGetAll")
    public Message getAllSecondByFirst(Firstsort firstsort){
        List<Secondsort> secondsorts = sortService.selectAllSecondByFirst(firstsort.getFirstId());
        if (secondsorts.size() > 0)
            return Message.success().add("secondsortAboutAll",secondsorts);
        return Message.fail();
    }

    @PostMapping("/secondOfRename")
    public Message renameSecondsort(Secondsort secondsort){
        if (sortService.updateSecondById(secondsort))
            return Message.success();
        return Message.fail();
    }

    @PostMapping("/secondOfAdd")
    public Message addSecond(Secondsort secondsort){
        if (sortService.addSecondsort(secondsort))
            return Message.success();
        return Message.fail();
    }

    /*三级*/
    @GetMapping("/thirdOfGetAll")
    public Message getAllThirdBySecond(Secondsort secondsort){
        List<Thirdsort> thirdsortList = sortService.selectAllThirdBySecond(secondsort.getSecondId());
        if (thirdsortList.size() > 0)
            return Message.success().add("thirdsortAboutAll",thirdsortList);
        return Message.fail();
    }

    @PostMapping("/thirdOfRename")
    public Message renameThirdsort(Thirdsort thirdsort){
        if (sortService.updateThirdById(thirdsort))
            return Message.success();
        return Message.fail();
    }

    @PostMapping("/thirdOfAdd")
    public Message addThird(Thirdsort thirdsort){
        if (sortService.addThirdsort(thirdsort))
            return Message.success();
        return Message.fail();
    }

}
