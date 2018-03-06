package com.bwie.yuekaomoni1.Model;

import java.util.Map;

/**
 * Created by dell on 2018/3/3.
 */

public interface iModel {
    //轮播图
    void  LunboData(LoadListener loadListener);
    //商品
    void GoodData(Map<String ,String> map , LoadListener2 loadListener2);
    //详情
    void XiangQingData(Map<String,String> map,LoadListener3 loadListener3);
    //加入购物车
    void AddCart(Map<String,String> map,LoadListener4 loadListener4);
    //查询购物车
    void ShowCart(Map<String,String> map,LoadListener5 loadListener5);
    //刷新购物车的方法
    void ShuaCart(Map<String,String>map,LoadListener5 loadListener5);
}
