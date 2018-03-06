package com.bwie.yuekaomoni1.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.MyAdaper.ExAdaper;
import com.bwie.yuekaomoni1.Presenter.iPresenterImpl;
import com.bwie.yuekaomoni1.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class  ShowGoodsActivity extends AppCompatActivity implements ShowCartView,View.OnClickListener {

    private iPresenterImpl p;
    private List<ShowCartBean.DataBean> data;
    private ExpandableListView elv;
    private TextView sum;
    private CheckBox qx;
    private ExAdaper ea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goods);
        elv = findViewById(R.id.elv);
        sum = findViewById(R.id.zj);
        qx = findViewById(R.id.qx);
        qx.setOnClickListener(this);
        p = new iPresenterImpl();
        p.Showren("10792",this);
    }

    @Override
    public void InitCart(ShowCartBean showCartBean) {
        this.data=showCartBean.getData();
        ea = new ExAdaper(p, this.data,this);
        elv.setAdapter(ea);
        //设置总价
        setZj();
        //展开二级列表
        for (int i = 0; i < this.data.size(); i++) {
            elv.expandGroup(i);
        }
    }
    //设置总价
    private void setZj() {
        double zj=0;
        for (int i = 0; i <data.size(); i++) {
            for (int j = 0; j <data.get(i).getList().size() ; j++) {
                if(data.get(i).getList().get(j).getSelected()==1){
                    zj=zj+(data.get(i).getList().get(j).getBargainPrice()*
                            data.get(i).getList().get(j).getNum());
                }
            }
        }
        double round = round(zj, 2);
        sum.setText("总价:  ¥"+round);
    }

    public double round(double v, int scale) {

        if (scale < 0) {

            throw new IllegalArgumentException("The scale must be a positive integer or zero");

        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    @Override
    public void Error(String error) {
        Log.e("tag",error);
    }

    @Override
    public void ShuaCart(int index,List<ShowCartBean.DataBean.ListBean> list) {
        index=index+1;
        if(index<list.size()){
            p.ShuaCartIPrensenter(index,list,this);
        }else{
            //不用重新调用接口,直接刷新适配器即可,因为接口改变在调用会刷新页面
            ea.notifyDataSetChanged();
            //重新调取计算总价的方法
            setZj();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qx:
                //点击全选是,遍历所有子元素,改变其状态
                //新建集合用于放数据,去访问接口
                List<ShowCartBean.DataBean.ListBean> list =new ArrayList<>();
                boolean aa = qx.isChecked();//获取全选的状态
                for (int i = 0; i < data.size(); i++) {
                    for (int j = 0; j <data.get(i).getList().size() ; j++) {
                        if(aa){
                            data.get(i).getList().get(j).setSelected(1);
                        }else{
                            data.get(i).getList().get(j).setSelected(0);
                        }
                        list.add(data.get(i).getList().get(j));
                    }
                }
                //调取刷新数据的接口
                p.ShuaCartIPrensenter(0,list,this);
                break;
        }
    }
}
