package com.bwie.yuekaomoni1.View;

import com.bwie.yuekaomoni1.Bean.AddBena;
import com.bwie.yuekaomoni1.Bean.XiangQingBean;

/**
 * Created by dell on 2018/3/4.
 */

public interface GoodView {
    void InitData(XiangQingBean xiangQingBean);
    void Addcart(AddBena addBena);
    void Error(String error);
}
