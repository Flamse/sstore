package com.top.sstore.dao;

import com.top.sstore.pojo.*;
import net.sf.jsqlparser.statement.select.First;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortMapperTest {

    @Autowired
    private FirstsortMapper firstsortMapper;
    @Autowired
    private SecondsortMapper secondsortMapper;
    @Autowired
    private ThirdsortMapper thirdsortMapper;


    @Test
    public void test1(){
        List<Firstsort> list = firstsortMapper.selectByExample(new FirstsortExample());
        for (Firstsort firstsort : list){
            System.out.println(firstsort.getFirstName());
        }
    }

    @Test
    public void test2(){
        List<Secondsort> list = secondsortMapper.selectByExample(new SecondsortExample());
        for (Secondsort secondsort : list){
            System.out.println(secondsort.getSecondName());
        }
    }

    @Test
    public void test3(){
        List<Thirdsort> list = thirdsortMapper.selectByExample(new ThirdsortExample());
        for (Thirdsort thirdsort : list){
            System.out.println(thirdsort.getThirdName());
        }
    }

    @Test
    public void test(){
//        List<Firstsort firstsortList, Secondsort secondsort, Thirdsort thirdsort> =
    }

}
