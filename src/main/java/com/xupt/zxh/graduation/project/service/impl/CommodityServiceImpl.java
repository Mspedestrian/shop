package com.xupt.zxh.graduation.project.service.impl;

import com.xupt.zxh.graduation.project.bean.Commodity;
import com.xupt.zxh.graduation.project.dao.CommodityDao;
import com.xupt.zxh.graduation.project.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> listCommodity() {
        List<Commodity> commodities = commodityDao.listCommodity();
        return commodities;
    }

    @Override
    public List<Commodity> listCommodityByCondition(Commodity commodity) {
        List<Commodity> commodities = commodityDao.listCommodityByCondition(commodity);
        return commodities;
    }

    @Override
    public void insertCommodity(Commodity commodity) {
        commodityDao.insertCommodity(commodity);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityDao.updateCommodity(commodity);
    }

    @Override
    public void deleteCommodity(Integer id) {
        commodityDao.deleteCommodity(id);
    }
}
