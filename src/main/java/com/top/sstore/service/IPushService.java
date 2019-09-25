package com.top.sstore.service;


import com.github.pagehelper.PageInfo;
import com.top.sstore.pojo.Activity;
import com.top.sstore.pojo.News;
import com.top.sstore.pojo.Recommend;
import sun.security.krb5.internal.PAData;

import java.util.List;

public interface IPushService {

    List<Recommend> selectRecommend(Integer type);

    List<News> selectNews();

    List<Activity> selectActivity();

}
