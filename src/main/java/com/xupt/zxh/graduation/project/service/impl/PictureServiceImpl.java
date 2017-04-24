package com.xupt.zxh.graduation.project.service.impl;

import com.xupt.zxh.graduation.project.bean.Picture;
import com.xupt.zxh.graduation.project.dao.PictureDao;
import com.xupt.zxh.graduation.project.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张涛 on 2017/4/24.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public void insertPicture(Picture picture) {
        pictureDao.insertPicture(picture);
    }

    @Override
    public List<Picture> getPictureByCIdAndType(Picture picture) {
        List<Picture> pictures = pictureDao.getPictureByCIdAndType(picture);
        return pictures;
    }
}
