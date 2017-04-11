package com.xupt.zxh.graduation.project.dao;

import com.xupt.zxh.graduation.project.bean.Commodity;

import java.util.List;

/**
 *
 * Created by admin on 2017/4/3.
 */
public interface CommodityDao {

    List<Commodity> listCommodity();

    List<Commodity> listCommodityByCondition(Commodity commodity);

    void insertCommodity(Commodity commodity);

    void updateCommodity(Commodity commodity);

    void  deleteCommodity(Integer id);
}
