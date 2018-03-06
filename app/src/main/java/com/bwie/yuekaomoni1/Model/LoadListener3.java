package com.bwie.yuekaomoni1.Model;

import com.bwie.yuekaomoni1.Bean.XiangQingBean;

/**
 * Created by dell on 2018/3/3.
 */

public interface LoadListener3 {
    //成功
    void Success(XiangQingBean xiangQingBean);

    //失败
    void Error(String Error);
}
