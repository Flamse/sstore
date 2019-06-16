package com.top.sstore.service;

import com.top.sstore.pojo.Firstsort;
import com.top.sstore.pojo.Secondsort;
import com.top.sstore.pojo.Thirdsort;

import java.util.List;

public interface ISortService {

    /**
     * @author zh
     * @date 2019/6/9/009 19:58
     * 增加一级分类
     */
    boolean addFirstsort(Firstsort firstsort);
    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 修改一级分类的内容
     */
    boolean updateFirstById(Firstsort firstsort);

    /**
     * @author zh
     * @date 2019/6/6/006 20:18
     * 查找所有一级分类
     */
    List<Firstsort> selectAllFirst();
    List<Integer> selectAllFirstId();

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 增加二级分类
     */
    boolean addSecondsort(Secondsort secondsort);

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 修改二级分类 通过ID
     */
    boolean updateSecondById(Secondsort secondsort);

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 查找所有二级分类 通过一级分类
     */
    List<Secondsort> selectAllSecondByFirst(Integer firstId);
    List<Integer> selectAllSecondIdByFirst(Integer firstId);
    List<Integer> selectAllSecondIdByAllFirst(List<Integer> firstId);

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 增加三级分类
     */
    boolean addThirdsort(Thirdsort thirdsort);

//    public void deleteThird(Thirdsort thirdsort);

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 修改三级分类 通过ID
     */
    boolean updateThirdById(Thirdsort thirdsort);

    /**
     * @author zh
     * @date 2019/6/9/009 19:59
     * 查找三级分类 通过二级
     */
    List<Thirdsort> selectAllThirdBySecond(Integer secondsortId);
    List<Integer> selectAllThirdIdBySecond(Integer secondsortId);
    List<Integer> selectAllThirdIdByAllSecond(List<Integer> secondsortId);

    /**
     * @author zh
     * @date 2019/6/10/010 16:34
     * 查找三级分类 通过一级分类
     */

}
