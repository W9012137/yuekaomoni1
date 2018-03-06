package com.bwie.yuekaomoni1.ZiDingYi;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bwie.yuekaomoni1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/3/3.
 */

public class AutoBanner extends RelativeLayout {
    DianJi dianji;
    private ViewPager viewPager;
    private LinearLayout llt;
    private Myhandler h;

    public AutoBanner(Context context) {
        this(context,null);
    }

    public AutoBanner(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AutoBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //将布局绘制到控件
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lunbo_item, this, true);
        //通过id获取控件
        viewPager = view.findViewById(R.id.viewpager);
        llt = view.findViewById(R.id.llt);
    }

    //写一个获取数据的方法,同时获取适配器
    public void setAdaper(Context context,List<String> data){
        Myadaper m=new Myadaper(context,data);
        viewPager.setAdapter(m);

        //写一个集合用于放指示器,也就是小圆点
        final List<ImageView> yuandian=new ArrayList();
        //有多少图片放几个圆点
        for (int i = 0; i < data.size(); i++) {
            ImageView yuan=new ImageView(context);
            //给图片添加选中和未选中的状态
            yuan.setBackgroundResource(R.drawable.dot_drawable);
            //添加到集合
            yuandian.add(yuan);
            //这是布局参数,,刚开始小圆点之间没有距离,所以使用java代码指定宽度高度,并且指定小圆点之间的距离
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,0,5,0);
            //放到LinearLayout,也就是圆点布局中
            llt.addView(yuan,params);
        }
        //默认第一个选中
        yuandian.get(0).setSelected(true);
        //给viewpager添加滑动监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position=position%yuandian.size();
                for (int i = 0; i <yuandian.size(); i++) {
                    //如果滑动的图片下标等于圆点下标就是圆点选中
                    if(i==position){
                        yuandian.get(i).setSelected(true);
                    }else{
                        //不等于就不选中
                        yuandian.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //2.手动的可以无限滑动  可以左滑
        viewPager.setCurrentItem(yuandian.size()*100000);//设置当前展示中间某个足够大的位置
        //设置自动轮播
        h = new Myhandler();
        autoPlay();
    }

    private void autoPlay() {
        h.sendEmptyMessageDelayed(0,2000);
    }

    //自动轮播
    class  Myhandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //显示下一页的消息
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            //再次发送
            h.sendEmptyMessageDelayed(0,2000);
        }
    }

    //适配器
    class Myadaper extends PagerAdapter {
        Context con;
        List<String> data;

        public Myadaper(Context con,List<String> data){
            this.con=con;
            this.data=data;
        }
        /**
         * viewPager具有预加载,默认的前后加载一页,,,默认的容器里面最多三页
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            //写一个ImageView控件
            ImageView iv=new ImageView(con);
            //给控件设置图片
            Glide.with(con).load(data.get(position%data.size())).into(iv);
            //添加到容器当中
            container.addView(iv);

            //给imageView设置触摸的监听事件,再点击的时候要暂停发送
            iv.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()){
                        case MotionEvent.ACTION_DOWN://按下的时候应该取消发送消息的操作
                            h.removeCallbacksAndMessages(null);
                            break;
                        case MotionEvent.ACTION_MOVE://移动的动作
                            h.removeCallbacksAndMessages(null);
                            break;
                        case MotionEvent.ACTION_CANCEL://取消
                            h.sendEmptyMessageDelayed(0,2000);
                            break;
                        case MotionEvent.ACTION_UP://抬起的时候
                            h.sendEmptyMessageDelayed(0,2000);
                            break;
                    }
                    return false;
                }
            });

            //2.把当前展示的视图返回
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //销毁视图
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;//设置成最大,无限轮播
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }


    //写一个接口,用于ImageView点击事件
    public interface DianJi{
        void dian(int position);
    }
    //写一个方法供外部访问
    public void  fang(DianJi dianji){
        this.dianji=dianji;
    }
}
