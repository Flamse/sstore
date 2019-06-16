package com.top.sstore.service;

import com.top.sstore.pojo.Firstsort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortServiceTests {
    @Autowired
    private ISortService service;

    @Test
    public void findAllFirstTest(){
        List<Firstsort> firstsorts =  service.selectAllFirst();
        for (Firstsort firstsort : firstsorts){
            System.out.println(firstsort.getFirstName());
        }
    }
}
