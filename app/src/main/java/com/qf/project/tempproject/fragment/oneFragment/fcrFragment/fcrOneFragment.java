package com.qf.project.tempproject.fragment.oneFragment.fcrFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.qf.project.tempproject.R;
import com.qf.project.tempproject.adapter.fcrAdapter.FcrOneFragmentAdapter;
import com.qf.project.tempproject.bean.fcrBean.OneEntity;
import com.qf.project.tempproject.utils.fcrUtils.HandlerJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class fcrOneFragment extends Fragment{

    RecyclerView mRecyclerView;
    List<OneEntity.ListBean> datas;

    List<OneEntity> tempDatas;

    List<OneEntity.KvBean> headDatas;
    FcrOneFragmentAdapter adapter;
    private static final String JSON_URL="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=0";
    String URL_STRING;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String jsonString= (String) msg.obj;
            Gson gson=new Gson();
            OneEntity entity=gson.fromJson(jsonString,OneEntity.class);
            if (entity.getList()!=null){
                datas.addAll(entity.getList());
            }

            if (entity.getKv()!=null){
                headDatas.addAll(entity.getKv());
            }
            adapter=new FcrOneFragmentAdapter(datas,getActivity(),headDatas);
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            //mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
            mRecyclerView.setAdapter(adapter);
        }
    };

    public fcrOneFragment getInstance(String name){
        fcrOneFragment fragment=new fcrOneFragment();
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fcr_fragment_one,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.fcr_one_rv);
        datas=new ArrayList<>();
        headDatas=new ArrayList<>();
        tempDatas=new ArrayList<>();
        initData();




    }

    private void initData() {
        if (getArguments().getString("name").equals("REMEN")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=0";
            Log.d("fcr","==name=="+getArguments().getString("name"));
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if (getArguments().getString("name").equals("JINGCAI")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=13";
            Log.d("fcr","==else if ="+getArguments().getString("name"));
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if(getArguments().getString("name").equals("ZOUJING")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=1";
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if(getArguments().getString("name").equals("SHENGTAI")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=2";
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if(getArguments().getString("name").equals("PINGPAI")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=3";
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if(getArguments().getString("name").equals("HUIHUANG")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=4";
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }else if(getArguments().getString("name").equals("BINGFENG")){
            URL_STRING="http://v.jmtopapp.cn/zmsjv3/api/videolist.php?page=1&programid=5";
            HandlerJson.getJsonString(URL_STRING,mHandler);
        }
    }
}
