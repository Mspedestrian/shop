package com.xupt.zxh.graduation.project.controller;

import com.alibaba.fastjson.JSON;
import com.xupt.zxh.graduation.project.bean.Commodity;
import com.xupt.zxh.graduation.project.bean.Picture;
import com.xupt.zxh.graduation.project.bean.ResponseInfo;
import com.xupt.zxh.graduation.project.service.CommodityService;
import com.xupt.zxh.graduation.project.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2017/4/3.
 */
@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private HttpServletResponse response;

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
     * 上传图片
     * @param request
     * @param cId
     * @param type
     * @return
     */
    @RequestMapping(value = "/uploadPicture/{cId}/{type}")
    public @ResponseBody ResponseInfo uploadFile(HttpServletRequest request,@PathVariable Integer cId,@PathVariable Integer type){
        ResponseInfo responseInfo = new ResponseInfo();
//        System.out.println("=====================>");

//        long  startTime=System.currentTimeMillis();
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
//                    path="D:/springUpload/"+file.getOriginalFilename();
                    String suf = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
                    String path ="D:/springUpload/" + UUID.randomUUID()+suf;
                    //将结果插入数据库
                    Picture picture  = new Picture();
                    picture.setcId(cId);
                    picture.setType(type);
                    picture.setPath(path);
                    pictureService.insertPicture(picture);
                    //上传
                    try {
                        file.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("上传文件出错！文件名："+file.getOriginalFilename());
                    }

                }


            }

        }
//        long  endTime=System.currentTimeMillis();
//        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");

        return responseInfo;
    }

    /**
     * 通过图片ID和图片类型获取图片
     * @return
     */
    @RequestMapping(value = "/getPicture/{cId}/{type}",method = RequestMethod.GET)
    public @ResponseBody ResponseInfo getPicture(@PathVariable Integer cId,@PathVariable Integer type){
        ResponseInfo responseInfo = new ResponseInfo();
        Picture picture = new Picture();
        picture.setcId(cId);
        picture.setType(type);
        List<Picture> pictures = pictureService.getPictureByCIdAndType(picture);
        responseInfo.setData(pictures);
        return responseInfo;
    }


    /**
     * 通过路径获取图片
     * @param path
     * @throws Exception
     */
    @RequestMapping(value = "/getPictureByPath", method = RequestMethod.GET)
    public @ResponseBody void getPictureByPath(String path) throws Exception {
        System.out.println(path);
        FileInputStream inputStream = new FileInputStream(path);
        int i = inputStream.available();
        // byte数组用于存放图片字节数据
        byte[] buff = new byte[i];
        inputStream.read(buff);
        // 记得关闭输入流
        inputStream.close();
        // 设置发送到客户端的响应内容类型
        response.setContentType("image/*");
        OutputStream out = response.getOutputStream();
        out.write(buff);
        // 关闭响应输出流
        out.close();
    }





}
