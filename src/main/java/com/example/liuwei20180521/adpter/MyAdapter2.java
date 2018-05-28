package com.example.liuwei20180521.adpter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.liuwei20180521.R;
import com.example.liuwei20180521.bean.VideoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyAdapter2 extends RecyclerView.Adapter {
    Context context;
    List<VideoBean.DataBean> data;
    public MyAdapter2(Context context, List<VideoBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //导入
        View inflate = View.inflate(context, R.layout.content02, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;

        //名字
        myHolder.text.setText(data.get(position).getName());
        //数据
        String videoview = data.get(position).getVideouri();

        Uri uri = Uri.parse( videoview );

        //添加
        myHolder.viewById.setVideoURI(uri);

        //开始
        myHolder.viewById.start();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {


        public  VideoView viewById;
        public  TextView text;

        public MyHolder(View view) {
            super(view);

            text = view.findViewById(R.id.text);
            viewById = view.findViewById(R.id.video);
        }
    }
}
