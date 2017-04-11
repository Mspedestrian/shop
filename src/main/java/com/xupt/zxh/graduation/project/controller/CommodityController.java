package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.Commodity;
import com.xupt.zxh.graduation.project.bean.ResponseInfo;
import com.xupt.zxh.graduation.project.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */
@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * 获取所有的
     * @return
     */
    @RequestMapping(value = "/getAllConmodity")
    public @ResponseBody ResponseInfo getAllCommodity(){
        ResponseInfo responseInfo = new ResponseInfo();
        List<Commodity> commodities = commodityService.listCommodity();
        responseInfo.setData(commodities);
        return responseInfo;
    }

    /**
     * 按条件查找，名称模糊查询，类别
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/getCommodityByCondition",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo getCommodityByCondition(@RequestBody Commodity commodity){
        ResponseInfo responseInfo = new ResponseInfo();
        List<Commodity> commodities = commodityService.listCommodityByCondition(commodity);
        responseInfo.setData(commodities);
        return responseInfo;
    }

    /**
     * 插入商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/addCommodity",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo addCommodity(@RequestBody Commodity commodity){
        ResponseInfo responseInfo = new ResponseInfo();
        commodityService.insertCommodity(commodity);
        return responseInfo;
    }

    /**
     * 更新商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/updateCommodity",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo updateCommodity(@RequestBody Commodity commodity){
        ResponseInfo responseInfo = new ResponseInfo();
        commodityService.updateCommodity(commodity);
        return responseInfo;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteCommodity/{id}",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo deleteCommodity(@PathVariable Integer id){
        ResponseInfo responseInfo = new ResponseInfo();
        commodityService.deleteCommodity(id);
        return responseInfo;
    }




}
