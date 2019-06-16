package com.top.sstore.service;

import com.top.sstore.pojo.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureServiceTests {
    @Autowired
    private IPictureService pictureService;

    @Test
    public void testSelectPictureByServids(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Picture> pictures = pictureService.selectPictureByServids(list);
        for (Picture picture : pictures){
            System.out.println(picture.getPicture());
        }
    }
}
