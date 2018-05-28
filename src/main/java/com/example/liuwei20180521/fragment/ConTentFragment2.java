package com.example.liuwei20180521.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.liuwei20180521.R;
import com.example.liuwei20180521.adpter.MyAdapter2;
import com.example.liuwei20180521.bean.VideoBean;
import com.example.liuwei20180521.pre.Presenter;
import com.example.liuwei20180521.pre.PresenterView;
import com.example.liuwei20180521.view.LogView2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ConTentFragment2 extends Fragment implements LogView2 {

    String uri = "https://www.apiopen.top/";
    int type = 4;
    int page = 1;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    Unbinder unbinder;
    private PresenterView presenterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //导入
        View view = View.inflate(getActivity(), R.layout.fragment02, null);
        unbinder = ButterKnife.bind(this, view);

        presenterView = new Presenter(this);
        presenterView.netSet(uri,type,page);
        //分割线
        rcy.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rcy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void toBackView(List<VideoBean.DataBean> data) {

        //判断
        if(data!=null){
            MyAdapter2 myAdapter2 = new MyAdapter2(getActivity(),data);
            rcy.setAdapter(myAdapter2);
        }else{
            Toast.makeText(getActivity(),"空的",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenterView!=null){
            presenterView.onDestory();
            presenterView=null;
            System.gc();
        }
    }
}
