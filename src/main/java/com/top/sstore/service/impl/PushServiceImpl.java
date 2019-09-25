package com.top.sstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.top.sstore.dao.ActivityMapper;
import com.top.sstore.dao.RecommendMapper;
import com.top.sstore.pojo.*;
import com.top.sstore.service.IPushService;
import com.top.sstore.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushServiceImpl implements IPushService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Autowired
    private StaticValues staticValues;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Recommend> selectRecommend(Integer type) {
        RecommendExample example = new RecommendExample();
        example.createCriteria().andRecomTypeEqualTo(type);
        PageHelper.startPage(1, staticValues.getPageSizeByRecommend()); //只展示第一页
        List<Recommend> recommends = recommendMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(recommends);
        List<Recommend> recommends1 = pageInfo.getList();   //转成List
        return recommends1;
    }

    @Override
    public List<News> selectNews() {

        return null;
    }

    @Override
    public List<Activity> selectActivity() {
        return activityMapper.selectByExample(new ActivityExample());
    }
}
