package com.bwie.yuekaomoni1.MyAdaper;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.yuekaomoni1.Bean.GoodBean;
import com.bwie.yuekaomoni1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */

public class GoodAdaper extends RecyclerView.Adapter<GoodAdaper.MyViewHolder> {

    Context con;
    List<GoodBean.DataBean> list;
    private Ondianji ondianji;
    public GoodAdaper(Context con,List<GoodBean.DataBean> list) {
        this.con = con;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //条目布局
        View view = LayoutInflater.from(con).inflate(R.layout.cc, null);
        //实例化ViewHolder ,将布局传入
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String images = list.get(position).getImages();
        String s = images.split(".jpg")[0] + ".jpg";
        Uri uri = Uri.parse(s);
        holder.getSim().setImageURI(uri);
        holder.getTv1().setText(list.get(position).getTitle());
        holder.getTv2().setText("原价:  ¥ "+list.get(position).getPrice());
        holder.getTv2().getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.getTv3().setText("优惠价:  ¥ "+list.get(position).getBargainPrice());
        if(ondianji!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //调用接口里面的方法
                    //传入的条目位置索引应该使用getLayoutPosition()（getPosition()被抛弃）方法来获取，
                    //这样就不会出现条目紊乱。
                    //获取真正的下标
                    int i=holder.getLayoutPosition();
                    int pid = list.get(i).getPid();
                    ondianji.diji(holder.itemView,pid);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //ViewHolder  用于优化
    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView sim;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.sim=itemView.findViewById(R.id.sim);
            this.tv1=itemView.findViewById(R.id.g_tv1);
            this.tv2=itemView.findViewById(R.id.g_tv2);
            this.tv3=itemView.findViewById(R.id.g_tv3);
        }

        public SimpleDraweeView getSim() {
            return sim;
        }

        public void setSim(SimpleDraweeView sim) {
            this.sim = sim;
        }

        public TextView getTv1() {
            return tv1;
        }

        public void setTv1(TextView tv1) {
            this.tv1 = tv1;
        }

        public TextView getTv2() {
            return tv2;
        }

        public void setTv2(TextView tv2) {
            this.tv2 = tv2;
        }

        public TextView getTv3() {
            return tv3;
        }

        public void setTv3(TextView tv3) {
            this.tv3 = tv3;
        }
    }

    //定义接口，实现条目点击事件
    public interface Ondianji{
        void diji(View view, int position);
    }
    //定义方法,供外部访问
    public void diao(Ondianji ondianji){
        this.ondianji=ondianji;
    }
}
