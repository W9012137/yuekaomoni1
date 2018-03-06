package com.bwie.yuekaomoni1.View.MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bwie.yuekaomoni1.R;
import com.bwie.yuekaomoni1.ZiDingYi.GramophoneView;

/**
 * Created by dell on 2018/3/3.
 */

public class F3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f3, container, false);
        final GramophoneView gramophoneView =view.findViewById(R.id.gramophone_view);
        final Button button = view.findViewById(R.id.btn_play_pause);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gramophoneView.getPlaying()){
                    button.setText("点击播放");
                }else{
                    button.setText("点击暂停");
                }
                gramophoneView.setPlaying(!gramophoneView.getPlaying());
            }
        });
        return view;
    }
}
