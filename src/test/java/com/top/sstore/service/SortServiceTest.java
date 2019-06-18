package com.top.sstore.service;

import com.top.sstore.pojo.Firstsort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortServiceTest {
    @Autowired
    private ISortService sortService ;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addFirstsort() {
        Firstsort firstsort = new Firstsort();
        firstsort.setFirstName("运动户外");
        sortService.addFirstsort(firstsort);
    }
}