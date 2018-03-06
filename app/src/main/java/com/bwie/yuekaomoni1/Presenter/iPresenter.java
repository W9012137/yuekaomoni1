package com.bwie.yuekaomoni1.Presenter;

import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.View.GoodView;
import com.bwie.yuekaomoni1.View.MyFragment.f2_iView;
import com.bwie.yuekaomoni1.View.MyFragment.iView;
import com.bwie.yuekaomoni1.View.ShowGoodsActivity;

import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */

public interface iPresenter {
    //轮播中间人
    void Lunbozhongjianren(iView iView);
    //商品中间人
    void Goodjianren(String page,f2_iView f2_iView);
    //详情
    void XiangQingren(String pid, GoodView goodView);
    //加入购物车
    void Addren(String pid,String uid ,GoodView goodView);
    //查询购物车
    void Showren(String uid , ShowGoodsActivity showGoodsActivity);
    //刷新购物车中间人
    void ShuaCartIPrensenter(final int index, final List<ShowCartBean.DataBean.ListBean> list,ShowGoodsActivity showGoodsActivity);
}
