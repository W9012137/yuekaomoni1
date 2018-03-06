package com.bwie.yuekaomoni1.Model;

import com.bwie.yuekaomoni1.Bean.ShowCartBean;

/**
 * Created by dell on 2018/3/3.
 */

public interface LoadListener5 {
    //成功
    void Success(ShowCartBean showCartBean);

    //失败
    void Error(String Error);
}
