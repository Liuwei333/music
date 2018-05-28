package com.example.liuwei20180521.adpter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuwei20180521.R;
import com.example.liuwei20180521.bean.WenBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<WenBean.DataBean> data;
    public MyAdapter(Context context, List<WenBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //导入
        View inflate = View.inflate(context, R.layout.content01, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //数据
        MyHolder holder1 = (MyHolder) holder;
        holder1.text.setText(data.get(position).getName());
        String cdn_img = data.get(position).getCdn_img();
        Toast.makeText(context,cdn_img,Toast.LENGTH_SHORT).show();

        //因为gif的图片与普通图片不一样
        //我们需要添加一下代码
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(cdn_img)
                .setOldController(holder1.sim.getController())
                .setAutoPlayAnimations(true)
                .build();
        holder1.sim.setController(controller);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView text;
        private final SimpleDraweeView sim;

        public MyHolder(View view) {
            super(view);
            text = view.findViewById(R.id.text);
            sim = view.findViewById(R.id.sim);

        }
    }
}
