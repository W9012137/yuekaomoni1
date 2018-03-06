package com.bwie.yuekaomoni1.Presenter;

import com.bwie.yuekaomoni1.Bean.AddBena;
import com.bwie.yuekaomoni1.Bean.GoodBean;
import com.bwie.yuekaomoni1.Bean.LunBoBean;
import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.Bean.XiangQingBean;
import com.bwie.yuekaomoni1.Model.LoadListener;
import com.bwie.yuekaomoni1.Model.LoadListener2;
import com.bwie.yuekaomoni1.Model.LoadListener3;
import com.bwie.yuekaomoni1.Model.LoadListener4;
import com.bwie.yuekaomoni1.Model.LoadListener5;
import com.bwie.yuekaomoni1.Model.iMdelImpl;
import com.bwie.yuekaomoni1.Model.iModel;
import com.bwie.yuekaomoni1.View.GoodView;
import com.bwie.yuekaomoni1.View.MyFragment.f2_iView;
import com.bwie.yuekaomoni1.View.MyFragment.iView;
import com.bwie.yuekaomoni1.View.ShowGoodsActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2018/3/4.
 */

public class iPresenterImpl implements iPresenter {

    private iModel iModel;

    public iPresenterImpl() {
        if (iModel == null) {
            iModel = new iMdelImpl();
        }
    }

    @Override
    public void Lunbozhongjianren(final iView iView) {
        iModel.LunboData(new LoadListener() {
            @Override
            public void Success(LunBoBean lunBoBean) {
                iView.InitLunBo(lunBoBean);
            }

            @Override
            public void Error(String Error) {
                iView.Error(Error);
            }
        });
    }

    @Override
    public void Goodjianren(String page, final f2_iView f2_iView) {
        Map<String, String> map = new HashMap<>();
        map.put("pscid", "39");
        map.put("page", page);
        iModel.GoodData(map, new LoadListener2() {
            @Override
            public void Success(GoodBean goodBean) {
                f2_iView.GoodInit(goodBean);
            }

            @Override
            public void Error(String Error) {
                f2_iView.Error(Error);
            }
        });
    }

    @Override
    public void XiangQingren(String pid, final GoodView goodView) {
        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("source", "android");
        iModel.XiangQingData(map, new LoadListener3() {
            @Override
            public void Success(XiangQingBean xiangQingBean) {
                goodView.InitData(xiangQingBean);
            }

            @Override
            public void Error(String Error) {
                goodView.Error(Error);
            }
        });
    }

    @Override
    public void Addren(String pid, String uid, final GoodView goodView) {
        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("uid", uid);
        map.put("source", "android");
        iModel.AddCart(map, new LoadListener4() {
            @Override
            public void Success(AddBena addBena) {
                goodView.Addcart(addBena);
            }

            @Override
            public void Error(String Error) {
                goodView.Error(Error);
            }
        });
    }

    @Override
    public void Showren(String uid, final ShowGoodsActivity showGoodsActivity) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("source", "android");
        iModel.ShowCart(map, new LoadListener5() {
            @Override
            public void Success(ShowCartBean showCartBean) {
                showGoodsActivity.InitCart(showCartBean);
            }

            @Override
            public void Error(String Error) {
                showGoodsActivity.Error(Error);
            }
        });
    }

    @Override
    public void ShuaCartIPrensenter(final int index, final List<ShowCartBean.DataBean.ListBean> list, final ShowGoodsActivity showGoodsActivity) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", "10792");
        map.put("sellerid", list.get(index).getSellerid() + "");
        map.put("pid", list.get(index).getPid() + "");
        map.put("selected", list.get(index).getSelected() + "");
        map.put("num", list.get(index).getNum() + "");
        iModel.ShuaCart(map, new LoadListener5() {
            @Override
            public void Success(ShowCartBean showCartBean) {
                showGoodsActivity.ShuaCart(index, list);
            }

            @Override
            public void Error(String Error) {
                showGoodsActivity.Error(Error);
            }
        });
    }
}
