package com.bwie.yuekaomoni1.View.MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.yuekaomoni1.Bean.GoodBean;
import com.bwie.yuekaomoni1.MyAdaper.GoodAdaper;
import com.bwie.yuekaomoni1.Presenter.iPresenter;
import com.bwie.yuekaomoni1.Presenter.iPresenterImpl;
import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.View.GoodActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by dell on 2018/3/3.
 */

public class F2 extends Fragment implements f2_iView{

    private iPresenter p;
    int page=1;
    private XRecyclerView xlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2, container, false);
        xlv = view.findViewById(R.id.s_xlv);
        xlv.setLayoutManager(new GridLayoutManager(getActivity(),1, OrientationHelper.VERTICAL,false));
        p = new iPresenterImpl();
        p.Goodjianren(page+"",this);
        return view;
    }

    @Override
    public void GoodInit(GoodBean goodBean) {
        GoodAdaper goodAdaper = new GoodAdaper(getActivity(), goodBean.getData());
        xlv.setAdapter(goodAdaper);
        goodAdaper.diao(new GoodAdaper.Ondianji() {
            @Override
            public void diji(View view, int position) {
                Intent intent=new Intent(getActivity(), GoodActivity.class);
                intent.putExtra("pid",position+"");
                startActivity(intent);
            }
        });

        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//上拉刷新
                page=1;
                p.Goodjianren(page+"",F2.this);
                xlv.refreshComplete(); }
            //下拉加载更多
            @Override
            public void onLoadMore() {
                ++page;
                Log.e("TAG",""+page);
                p.Goodjianren(page+"",F2.this);
                xlv.loadMoreComplete();
            }
        });
    }

    @Override
    public void Error(String error) {
        Log.e("asd",error);
    }
}
