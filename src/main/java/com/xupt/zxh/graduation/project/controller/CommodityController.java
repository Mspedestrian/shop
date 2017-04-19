package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.Commodity;
import com.xupt.zxh.graduation.project.bean.ResponseInfo;
import com.xupt.zxh.graduation.project.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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

    /**
     * 测试文件上传
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadFile")
    public @ResponseBody ResponseInfo uploadFile(HttpServletRequest request) throws IOException {
        ResponseInfo responseInfo = new ResponseInfo();
        System.out.println("=====================>");

        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="D:/springUpload/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");

        return responseInfo;
    }




}
