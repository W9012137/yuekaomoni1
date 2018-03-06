package com.bwie.yuekaomoni1.MyAdaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.yuekaomoni1.Bean.LunBoBean;
import com.bwie.yuekaomoni1.R;

import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */

public class LunBoAdaper extends RecyclerView.Adapter<LunBoAdaper.MyViewHolder> {

    Context con;
    List<LunBoBean.MiaoshaBean.ListBeanX> list;
    private Ondianji ondianji;

    public LunBoAdaper(Context con, List<LunBoBean.MiaoshaBean.ListBeanX> list) {
        this.con = con;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //条目布局
        View view = LayoutInflater.from(con).inflate(R.layout.aa, null);
        //实例化ViewHolder ,将布局传入
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String images = list.get(position).getImages();
        String s = images.split(".jpg")[0] + ".jpg";
        Glide.with(con).load(s).into(holder.iv);
        holder.getTv().setText("¥: "+list.get(position).getBargainPrice());

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
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.iv=itemView.findViewById(R.id.iv);
            this.tv=itemView.findViewById(R.id.l_tv);
        }

        public ImageView getIv() {
            return iv;
        }

        public void setIv(ImageView iv) {
            this.iv = iv;
        }

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }
    }

    //定义接口，实现条目点击事件
    public interface Ondianji{
        void diji(View view,int position);
    }
    //定义方法,供外部访问
    public void diao(Ondianji ondianji){
        this.ondianji=ondianji;
    }
}
