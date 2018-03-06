package com.bwie.yuekaomoni1.View.MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.yuekaomoni1.Bean.LunBoBean;
import com.bwie.yuekaomoni1.MyAdaper.LunBoAdaper;
import com.bwie.yuekaomoni1.MyAdaper.TuiJianAdaper;
import com.bwie.yuekaomoni1.Presenter.iPresenter;
import com.bwie.yuekaomoni1.Presenter.iPresenterImpl;
import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.View.GoodActivity;
import com.bwie.yuekaomoni1.ZiDingYi.AutoBanner;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by dell on 2018/3/3.
 */

public class F1 extends Fragment implements iView{

    private AutoBanner ban;
    private iPresenter p;
    private CountdownView cdm;
    private RecyclerView rlv;
    private RecyclerView rlv1;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1, container, false);
        ban = view.findViewById(R.id.ban);
        cdm = view.findViewById(R.id.cdm);
        rlv = view.findViewById(R.id.rlv);
        rlv1= view.findViewById(R.id.rlv1);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rlv1.setLayoutManager(new GridLayoutManager(getActivity(),2, OrientationHelper.VERTICAL,false));
        p = new iPresenterImpl();
        p.Lunbozhongjianren(this);
        return view;
    }

    @Override
    public void InitLunBo(LunBoBean lunBoBean) {
        List<LunBoBean.DataBean> data = lunBoBean.getData();
        list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getIcon());
        }
        ban.setAdaper(getActivity(),list);
        cdm.start(lunBoBean.getMiaosha().getTime());
        //秒杀
        LunBoAdaper lunBoAdaper = new LunBoAdaper(getActivity(), lunBoBean.getMiaosha().getList());
        rlv.setAdapter(lunBoAdaper);
        lunBoAdaper.diao(new LunBoAdaper.Ondianji() {
            @Override
            public void diji(View view, int position) {
                Tiao(position+"");
            }
        });
        //推荐
        TuiJianAdaper tuiJianAdaper = new TuiJianAdaper(getActivity(), lunBoBean.getTuijian().getList());
        rlv1.setAdapter(tuiJianAdaper);
        tuiJianAdaper.diao(new TuiJianAdaper.Ondianji() {
            @Override
            public void diji(View view, int position) {
                Tiao(position+"");
            }
        });
    }

    @Override
    public void Error(String error) {
        Log.e("error", "Error: "+error);
    }

    //跳转的方法
    public void Tiao(String pid){
        Intent intent=new Intent(getActivity(), GoodActivity.class);
        intent.putExtra("pid",pid);
        startActivity(intent);
    }
}
