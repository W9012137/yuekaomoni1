package com.bwie.yuekaomoni1.View;

import com.bwie.yuekaomoni1.Bean.ShowCartBean;

import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */

public interface ShowCartView {
   void InitCart(ShowCartBean showCartBean);
   void Error(String error);
   //刷新购物车
   void ShuaCart(int index,List<ShowCartBean.DataBean.ListBean> list);
}
