package com.mlj.tshop.pojo;

import java.io.Serializable;

/**
 * 2018/12/05：商品
 *
 * @author mlj
 */
public class Product implements Serializable {
    /**
     * 商品id：8位整数
     */
    private Integer id;
    /**
     * 商品名称：100个字符以内
     */
    private String name;
    /**
     * 商品价格：10位以内
     */
    private Double price;
    /**
     * 商品信息：100个字符以内
     */
    private String info;
    /**
     * 商品图片绝对地址：200个字符以内
     */
    private String image;
    /**
     * 商品状态：1表示可用，0表示禁用
     */
    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
