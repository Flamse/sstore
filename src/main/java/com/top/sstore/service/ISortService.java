package com.top.sstore.service;

import com.top.sstore.pojo.Firstsort;
import com.top.sstore.pojo.Secondsort;
import com.top.sstore.pojo.Thirdsort;
import org.springframework.stereotype.Service;

@Service
public interface ISortService {

    /**
     * @author zh
     * @date 2019/6/5/005 9:07
     * 查找所有一级分类
     */
    public Firstsort showAllFirst();

    /**
     * @author zh
     * @date 2019/6/5/005 9:09
     * 查找一级分类下的所有二级分类
     */
    public Secondsort showAllSecondWithFirst(Firstsort firstsort);

    /**
     * @author zh
     * @date 2019/6/5/005 10:10
     * 查找二级分类下的所有三级分类
     */
    public Thirdsort showAllThirdWithSecond(Firstsort firstsort, Secondsort secondsort);

}
