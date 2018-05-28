package com.example.liuwei20180521.MyModel;

import com.example.liuwei20180521.bean.VideoBean;
import com.example.liuwei20180521.bean.WenBean;
import com.example.liuwei20180521.model.MyModel;
import com.example.liuwei20180521.pre.PresenterView;
import com.example.liuwei20180521.utils.OkHttpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/21.
 */

public class Model implements ModelView {
    @Override
    public void toModelView(String uri, int type, int page, final PresenterView presenterView) {
        //解析
            Observable<VideoBean> videoBeanObservable = OkHttpUtils.getInstance(uri).getApi().doPost(type, page);

             videoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoBean>() {
                    @Override
                    public void accept(VideoBean wenBean) throws Exception {
                        List<VideoBean.DataBean> data = wenBean.getData();
                        presenterView.toPresenter(data);
                    }
                });
    }
}
