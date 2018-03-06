package com.bwie.yuekaomoni1.View;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.View.MyFragment.F1;
import com.bwie.yuekaomoni1.View.MyFragment.F2;
import com.bwie.yuekaomoni1.View.MyFragment.F3;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private F1 f1;
    private RadioGroup rg;
    private F2 f2;
    private F3 f3;
    private TextView tv;
    private String   title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        rg = findViewById(R.id.rg);
        tv = findViewById(R.id.tv);
        //获取管理者
        fragmentManager = getSupportFragmentManager();
        //将所有Fragment添加到占位布局
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //默认展示第一个fragment
        f1 = new F1();
        fragmentTransaction.add(R.id.frame,f1).commit();
        //RadioGroup点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //隐藏所有Fragment
                hidefragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.rb1:
                        //展示第一个
                        fragmentTransaction.show(f1).commit();
                        title="首页";
                        break;
                    case R.id.rb2:
                        //展示第二个
                        if(f2==null){
                            f2 = new F2();
                            fragmentTransaction.add(R.id.frame,f2).commit();
                        }else{
                            fragmentTransaction.show(f2).commit();
                        }
                        title="商品列表";
                        break;
                    case R.id.rb3:
                        //展示第三个
                        if(f3==null){
                            f3 = new F3();
                            fragmentTransaction.add(R.id.frame,f3).commit();
                        }else{
                            fragmentTransaction.show(f3).commit();
                        }
                        title="发现";
                        break;
                }
                tv.setText(title);
            }
        });
    }

    private void hidefragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //如果Fragment不为空并且已经添加,就隐藏
        if(f1!=null&&f1.isAdded()){
            fragmentTransaction.hide(f1);
        }
        if(f2!=null&&f2.isAdded()){
            fragmentTransaction.hide(f2);
        }
        if(f3!=null&&f3.isAdded()){
            fragmentTransaction.hide(f3);
        }
        fragmentTransaction.commit();
    }
}
