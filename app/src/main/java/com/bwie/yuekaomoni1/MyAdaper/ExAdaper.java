package com.bwie.yuekaomoni1.MyAdaper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.Presenter.iPresenterImpl;
import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.View.ShowGoodsActivity;
import com.bwie.yuekaomoni1.ZiDingYi.AmountView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */

public class ExAdaper extends BaseExpandableListAdapter {
    List<ShowCartBean.DataBean> data;
    Context context;
    private iPresenterImpl p;
    List<ShowCartBean.DataBean> list=new ArrayList<>();
    public ExAdaper(iPresenterImpl p,List<ShowCartBean.DataBean> data,
                    Context context) {
        this.data = data;
        this.context = context;
        this.p=p;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if (data.size()==0){
            return 0;
        }
        return data.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return data.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view,
                             ViewGroup viewGroup) {
        final MyHolder1 h1;
        if(view==null){
            view=View.inflate(context,R.layout.group_item,null);
            h1 = new MyHolder1();
            h1.g_cb=view.findViewById(R.id.g_cb);
            h1.g_tv=view.findViewById(R.id.g_tv);
            view.setTag(h1);
        }else{
            h1= (MyHolder1) view.getTag();
        }
        //因为会重新调用,接口中没有isGrooup_flag,这个属性,
        // 所以有BUG,直接遍历子元素,如果都选中,则父元素选中
        h1.g_cb.setChecked(setGroup(i));
        h1.g_tv.setText(data.get(i).getSellerName());
        //父点击选择改变子
        h1.g_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变父元素的选择状态,用于改变子元素
                data.get(i).setGrooup_flag(!data.get(i).isGrooup_flag());
                for (int j = 0; j <data.get(i).getList().size(); j++) {
                    if(data.get(i).isGrooup_flag()){
                        data.get(i).getList().get(j).setSelected(1);
                    }else{
                        data.get(i).getList().get(j).setSelected(0);
                    }
                }
                data.get(i).getList();//当前父元素的所以孩子,用于递归刷新接口数据
                //掉刷新的接口方法
                p.ShuaCartIPrensenter(0,data.get(i).getList(), (ShowGoodsActivity) context);
            }
        });
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view,
                             ViewGroup viewGroup) {
        final MyHolder2 h2;
        if(view==null){
            view=View.inflate(context,R.layout.cart_child,null);
            h2=new MyHolder2();
            h2.c_cb=view.findViewById(R.id.c_cb);
            h2.c_iv=view.findViewById(R.id.c_iv);
            h2.c_title=view.findViewById(R.id.c_title);
            h2.c_price=view.findViewById(R.id.c_price);
            h2.c_delete=view.findViewById(R.id.c_delete);
            h2.amountView=view.findViewById(R.id.amount_view);
            h2.editText=view.findViewById(R.id.etAmount);
            h2.jian=view.findViewById(R.id.btnDecrease);
            h2.jia=view.findViewById(R.id.btnIncrease);
            view.setTag(h2);
        }else{
            h2= (MyHolder2) view.getTag();
        }
        h2.c_cb.setChecked(data.get(i).getList().get(i1).getSelected()==1?true:false);
        String images = data.get(i).getList().get(i1).getImages();
        String s = images.split(".jpg")[0] + ".jpg";
        Glide.with(context).load(s).into( h2.c_iv);
        h2.c_title.setText(data.get(i).getList().get(i1).getTitle());
        double round = round(data.get(i).getList().get(i1).getNum()*data.get(i).getList().get(i1).getBargainPrice(), 2);
        h2.c_price.setText("优惠价: ¥"+round);
        h2.editText.setText(data.get(i).getList().get(i1).getNum()+"");



        //减的点击事件
        h2.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = data.get(i).getList().get(i1).getNum();
                if(num==0){
                    return;
                }
                data.get(i).getList().get(i1).setNum(--num);
                //刷新接口
                p.ShuaCartIPrensenter(0,data.get(i).getList(), (ShowGoodsActivity) context);;
            }
        });

        //加的点击事件
        h2.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = data.get(i).getList().get(i1).getNum();
                data.get(i).getList().get(i1).setNum(++num);
                //刷新接口
                p.ShuaCartIPrensenter(0,data.get(i).getList(), (ShowGoodsActivity) context);
            }
        });

        //子条目点击事件
        h2.c_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.get(i).getList().get(i1).getSelected()==0){
                    data.get(i).getList().get(i1).setSelected(1);
                }else{
                    data.get(i).getList().get(i1).setSelected(0);
                }
                //刷新接口
                p.ShuaCartIPrensenter(0,data.get(i).getList(), (ShowGoodsActivity) context);
            }
        });





        //删除的点击事件
        h2.c_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调删除的接口
                ShowCartBean.DataBean.ListBean listBean = data.get(i).getList().get(i1);
                //p.DeleterCartPresenter(listBean,new iModelImpl(), (IView) context);
                //直接删除集合的数据
                data.get(i).getList().remove(i1);
                //判读子有没有,如果没有就删除父
                if(data.get(i).getList().size()==0){
                    data.remove(i);
                }
            }
        });
        //判断如果孩子全选了就要选择父元素
        data.get(i).setGrooup_flag(setGroup(i));
        return view;
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    //遍历所以子元素,给父元素赋值选择状态,看是否全部选中
    private boolean setGroup(int i){
        for (int j = 0; j <data.get(i).getList().size(); j++) {
            if(data.get(i).getList().get(j).getSelected()==0){
                return false;
            }
        }
        return true;
    }

    class MyHolder1{
        CheckBox g_cb;
        TextView g_tv;
    }
    class MyHolder2{
        CheckBox c_cb;
        ImageView c_iv;
        TextView  c_title;
        TextView  c_price;
        TextView c_delete;
        AmountView amountView;
        TextView editText;
        Button   jia;
        Button   jian;
    }

    public double round(double v, int scale) {

        if (scale < 0) {

            throw new IllegalArgumentException("The scale must be a positive integer or zero");

        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}
