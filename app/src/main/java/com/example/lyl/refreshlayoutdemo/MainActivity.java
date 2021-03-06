package com.example.lyl.refreshlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lyl.pullmore.PullLoadRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private PullLoadRecyclerView pullrv;
    private List<Integer> datas;
    private int anInt = 20;
    private int addInt = 20;
    private Handler mHandler = new Handler(Looper.getMainLooper()){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        pullrv = (PullLoadRecyclerView) findViewById(R.id.pullrv);

        //设置下拉颜色
        pullrv.setSwipeRefreshColor(android.R.color.holo_blue_bright,android.R.color.holo_blue_dark,android.R.color.holo_blue_bright);


        final Adapter adapter = new Adapter();
        datas = new ArrayList<>();
        for (int i = 0; i < anInt; i++) {
            datas.add(i);
        }
        adapter.setDatas(datas);
        //设置列数和滚动方向
        pullrv.setLayoutManager(1, LinearLayoutManager.VERTICAL);
        pullrv.setAdapter(adapter);
        //设置监听
        pullrv.setOnPullLoadMoreListener(new PullLoadRecyclerView.OnPullLoadMoreListener() {
            @Override
            public void reRresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.clear();
                        for (int i = 0; i < anInt; i++) {
                            datas.add(i);
                        }
                        adapter.setDatas(datas);
                        pullrv.setRefreshCompleted();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addInt += 20;
                        for (int i = addInt-20; i < addInt; i++) {
                            datas.add(i);
                        }
                        adapter.setDatas(datas);
                        pullrv.setLoadMoreCompleted();
                        RecyclerView recyclerView = pullrv.getmRecyclerView();
                        recyclerView.smoothScrollToPosition(datas.size()-20);
                    }
                },2000);
            }
        });

    }


}
