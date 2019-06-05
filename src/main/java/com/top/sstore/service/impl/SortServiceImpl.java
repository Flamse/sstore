package com.top.sstore.service.impl;

import com.top.sstore.pojo.Firstsort;
import com.top.sstore.pojo.Secondsort;
import com.top.sstore.pojo.Thirdsort;
import com.top.sstore.service.ISortService;

public class SortServiceImpl implements ISortService {
    @Override
    public Firstsort showAllFirst() {
        return null;
    }

    @Override
    public Secondsort showAllSecondWithFirst(Firstsort firstsort) {
        return null;
    }

    @Override
    public Thirdsort showAllThirdWithSecond(Firstsort firstsort, Secondsort secondsort) {
        return null;
    }
}
