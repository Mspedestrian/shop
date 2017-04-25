package com.xupt.zxh.graduation.project.service;

import com.xupt.zxh.graduation.project.bean.Commodity;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */
public interface CommodityService {

    List<Commodity> listCommodity();

    List<Commodity> listCommodityByCondition(Commodity commodity);

    Commodity insertCommodity(Commodity commodity);

    void updateCommodity(Commodity commodity);

    void  deleteCommodity(Integer id);
}
