package com.bwie.yuekaomoni1.View;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yuekaomoni1.Bean.AddBena;
import com.bwie.yuekaomoni1.Bean.XiangQingBean;
import com.bwie.yuekaomoni1.Presenter.iPresenter;
import com.bwie.yuekaomoni1.Presenter.iPresenterImpl;
import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.ZiDingYi.AutoBanner;

import java.util.ArrayList;
import java.util.List;

public class GoodActivity extends AppCompatActivity implements GoodView,View.OnClickListener {

    private List<String> list;
    private AutoBanner ban1;
    private TextView g_t1;
    private TextView g_t2;
    private TextView g_t3;
    private XiangQingBean.DataBean data;
    private Button bt1;
    private Button bt2;
    private iPresenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ban1 = findViewById(R.id.ban1);
        g_t1 = findViewById(R.id.g_t1);
        g_t2 = findViewById(R.id.g_t2);
        g_t3 = findViewById(R.id.g_t3);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        p = new iPresenterImpl();
        p.XiangQingren(pid,this);

    }

    @Override
    public void InitData(XiangQingBean xiangQingBean) {
        data = xiangQingBean.getData();
        String images = data.getImages();
        String[] split = images.split("\\|");
        list = new ArrayList<>();
        for (int i = 0; i <split.length ; i++) {
            list.add(split[i]+".jpg");
        }
        ban1.setAdaper(this,list);
        g_t1.setText(data.getTitle()+"a");
        g_t2.setText("原价:  ¥ "+ data.getPrice());
        g_t2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        g_t3.setText("优惠价:  ¥ "+ data.getBargainPrice());
    }

    @Override
    public void Addcart(AddBena addBena) {
        Toast.makeText(this,addBena.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Error(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                p.Addren(data.getPid()+"","10792",this);
                break;
            case R.id.bt2:
                startActivity(new Intent(this,ShowGoodsActivity.class));
                break;
        }
    }
}
