package com.entity;

import com.until.VeDate;

import java.util.ArrayList;
import java.util.List;

public class Cate {
    private String cateid="Cate"+ VeDate.getStringId();
    private String catename;
    private String memo;

    private List<Goods> goodsList =new ArrayList<>();
    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
