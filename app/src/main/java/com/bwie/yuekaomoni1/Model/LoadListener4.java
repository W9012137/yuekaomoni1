package com.bwie.yuekaomoni1.Model;

import com.bwie.yuekaomoni1.Bean.AddBena;

/**
 * Created by dell on 2018/3/3.
 */

public interface LoadListener4 {
    //成功
    void Success(AddBena addBena);

    //失败
    void Error(String Error);
}
