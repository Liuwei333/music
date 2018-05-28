package com.example.liuwei20180521;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.liuwei20180521.fragment.ConTentFragment;
import com.example.liuwei20180521.fragment.ConTentFragment2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //集合
        list = new ArrayList<>();

        list.add("视频");
        list.add("图片");

        //适配器 进行tab的关联

        viewPager.setAdapter(

                new tabAdapter(getSupportFragmentManager())

        );

        tab.setupWithViewPager(viewPager);

    }

    //适配器进行轮播显示
    class tabAdapter extends FragmentPagerAdapter {


        public tabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //显示横屏
        public CharSequence getPageTitle(int position) {

            return list.get(position);
        }

        //显示不同的页面
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {

                ConTentFragment2 conTentFragment = new ConTentFragment2();
                return conTentFragment;
            } else if (position == 1) {
                ConTentFragment conTentFragment = new ConTentFragment();
                return conTentFragment;
            }

         return null;
        }
    }

    }
