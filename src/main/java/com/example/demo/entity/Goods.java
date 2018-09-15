package com.example.demo.entity;

/**
 * Created by losho on 2018-09-15.
 */

public class Goods {

    private Integer id;//商品id

    private String goodsName;//商品名

    private double goodsPrice;//单价

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoogsPrice() {
        return goodsPrice;
    }

    public void setGoogsPrice(double googsPrice) {
        this.goodsPrice = googsPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", googsPrice=" + goodsPrice +
                '}';
    }
}
