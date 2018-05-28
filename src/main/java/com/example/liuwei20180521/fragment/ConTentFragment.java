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
import com.example.liuwei20180521.adpter.MyAdapter;
import com.example.liuwei20180521.bean.WenBean;
import com.example.liuwei20180521.presenter.MyPresenter;
import com.example.liuwei20180521.presenter.MyPresenterView;
import com.example.liuwei20180521.view.LogView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ConTentFragment extends Fragment implements LogView {

    String uri = "https://www.apiopen.top/";
    int type = 3;
    int page = 1;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    Unbinder unbinder;
    private MyPresenterView myPresenterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment01, null);
        unbinder = ButterKnife.bind(this, view);

        myPresenterView = new MyPresenter(this);
        myPresenterView.netSet(uri, type, page);

        //分割线
        rcy.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        rcy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void toBackView(List<WenBean.DataBean> data) {

        //判断
        if (data != null) {
            MyAdapter myAdapter = new MyAdapter(getActivity(),data);
            rcy.setAdapter(myAdapter);
        } else {
            Toast.makeText(getActivity(), "空的", Toast.LENGTH_SHORT).show();
        }
    }
    //解除绑定

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myPresenterView != null) {
            myPresenterView.onDestroy();
            myPresenterView = null;
            System.gc();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
