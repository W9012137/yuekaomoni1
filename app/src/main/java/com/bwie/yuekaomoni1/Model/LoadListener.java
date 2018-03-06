package com.bwie.yuekaomoni1.Model;

import com.bwie.yuekaomoni1.Bean.LunBoBean;

/**
 * Created by dell on 2018/3/3.
 */

public interface LoadListener {
    //成功
    void Success(LunBoBean lunBoBean);
    //失败
    void Error(String Error);
}
