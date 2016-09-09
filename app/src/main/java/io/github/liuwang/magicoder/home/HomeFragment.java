package io.github.liuwang.magicoder.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.liuwang.magicoder.R;
import io.github.liuwang.magicoder.home.adapter.HomeRecyclerAdapter;
import io.github.liuwang.magicoder.home.models.Result;


/**
 * Created by LiuWang on 15/08/2016.
 * 主页Fragment
 */
public class HomeFragment extends Fragment implements HomeConstarct.IHomeView{
    public static final String TAG = "HomeFragment";
    private RecyclerView mRecyclerView;
    private HomeRecyclerAdapter adapter;
    private List<Result> data = new ArrayList<>();
    private Context mContext;
    private IHomePresenterImpl mHomePresenter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void init(){
        adapter = new HomeRecyclerAdapter(getActivity(), data);
        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter = new HomeRecyclerAdapter(getActivity(), data);
        mRecyclerView.setAdapter(adapter);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);
        mHomePresenter = new IHomePresenterImpl(this);
        mHomePresenter.loadHomeData();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        init();
        return view;
    }

    @Override
    public void fillData(List<Result> mData) {
        adapter.setmData(mData);
    }

    @Override
    public void onDestroy() {
        mHomePresenter.onDestroy();
        super.onDestroy();
    }
}
