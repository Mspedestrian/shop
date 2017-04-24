package com.xupt.zxh.graduation.project.bean;

/**
 * 图片类
 * Created by 张涛 on 2017/4/24.
 */
public class Picture {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer cId;

    /**
     * 图片类型：1：商品图片；2：属性图片； 3：详情图片
     */
    private Integer type;

    /**
     * 图片的路径
     */
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
