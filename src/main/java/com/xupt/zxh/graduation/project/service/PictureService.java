package com.xupt.zxh.graduation.project.service;

import com.xupt.zxh.graduation.project.bean.Picture;

import java.util.List;

/**
 * Created by 张涛 on 2017/4/24.
 */
public interface PictureService {

    /**
     * 插入图片
     * @param picture
     */
    void insertPicture(Picture picture);

    /**
     * 通过商品ID和图片类型获取图片
     * @param picture
     * @return
     */
    List<Picture> getPictureByCIdAndType(Picture picture);
}
