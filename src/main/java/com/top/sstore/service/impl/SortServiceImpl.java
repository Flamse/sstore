package com.top.sstore.service.impl;

import com.top.sstore.dao.FirstsortMapper;
import com.top.sstore.dao.SecondsortMapper;
import com.top.sstore.dao.ThirdsortMapper;
import com.top.sstore.pojo.*;
import com.top.sstore.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class SortServiceImpl implements ISortService {
    @Autowired
    private FirstsortMapper firstsortMapper;
    @Autowired
    private SecondsortMapper secondsortMapper;
    @Autowired
    private ThirdsortMapper thirdsortMapper;
    @Autowired
    private ISortService sortService;

    /*=============一级分类*/
    @Override
    public boolean addFirstsort(Firstsort firstsort) {
        int a = firstsortMapper.insertSelective(firstsort);
        if (a == 1) {
//            return true;
            throw new RuntimeException();
        }
        else
            return false;
    }

    @Override
    public boolean updateFirstById(Firstsort firstsort) {
        int a = firstsortMapper.updateByPrimaryKeySelective(firstsort);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public List<Firstsort> selectAllFirst() {
        List<Firstsort> firstsorts = firstsortMapper.selectByExample(new FirstsortExample());    // 条件为空查询所有
        return firstsorts;
    }

    @Override
    public List<Integer> selectAllFirstId() {
        List<Firstsort> firstsorts = sortService.selectAllFirst();
        List<Integer> firstIds = firstsorts.stream().map(Firstsort::getFirstId).collect(Collectors.toList());
        return firstIds;
    }


    /*==============二级分类*/
    @Override
    public boolean addSecondsort(Secondsort secondsort) {
        int a = secondsortMapper.insertSelective(secondsort);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateSecondById(Secondsort secondsort) {
        int a = secondsortMapper.updateByPrimaryKeySelective(secondsort);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public List<Secondsort> selectAllSecondByFirst(Integer firstsort) {
        SecondsortExample example = new SecondsortExample();
        example.createCriteria().andFirstIdEqualTo(firstsort);
        List<Secondsort> secondIds = secondsortMapper.selectByExample(example);
        return secondIds;
    }

    @Override
    public List<Integer> selectAllSecondIdByFirst(Integer firstsort) {
        List<Secondsort> list = sortService.selectAllSecondByFirst(firstsort);
        List<Integer> secondIds = list.stream().map(Secondsort::getSecondId).collect(Collectors.toList());
        return secondIds;
    }

    @Override
    public List<Integer> selectAllSecondIdByAllFirst(List<Integer> firstId) {
        SecondsortExample example = new SecondsortExample();
        example.createCriteria().andFirstIdIn(firstId);
        List<Secondsort> secondsorts = secondsortMapper.selectByExample(example);
        List<Integer> secondIds = secondsorts.stream().map(Secondsort::getSecondId).collect(Collectors.toList());
        return secondIds;
    }


    /*===============三级分类*/
    @Override
    public boolean addThirdsort(Thirdsort thirdsort) {
        int a = thirdsortMapper.insertSelective(thirdsort);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateThirdById(Thirdsort thirdsort) {
        int a = thirdsortMapper.updateByPrimaryKeySelective(thirdsort);
        if (a == 1)
            return true;
        else
            return false;
    }

    @Override
    public List<Thirdsort> selectAllThirdBySecond(Integer secondsortId) {
        ThirdsortExample example = new ThirdsortExample();
        example.createCriteria().andSecondIdEqualTo(secondsortId);
        List<Thirdsort> thirdsortList = thirdsortMapper.selectByExample(example);
        return thirdsortList;
    }

    @Override
    public List<Integer> selectAllThirdIdBySecond(Integer secondsortId) {
        List<Thirdsort> thirdsortList = sortService.selectAllThirdBySecond(secondsortId);
        List<Integer> thirdIds = thirdsortList.stream().map(Thirdsort::getThirdId).collect(Collectors.toList());
        return thirdIds;
    }

    @Override
    public List<Integer> selectAllThirdIdByAllSecond(List<Integer> secondsortIds) {
        ThirdsortExample example = new ThirdsortExample();
        example.createCriteria().andSecondIdIn(secondsortIds);
        List<Thirdsort> thirdsorts = thirdsortMapper.selectByExample(example);
        List<Integer> thirdIds = thirdsorts.stream().map(Thirdsort::getThirdId).collect(Collectors.toList());
        return thirdIds;
    }
}
