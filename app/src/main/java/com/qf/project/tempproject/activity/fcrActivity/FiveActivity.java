package com.qf.project.tempproject.activity.fcrActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qf.project.tempproject.R;
import com.qf.project.tempproject.adapter.fcrAdapter.FcrFiveActivityAdapter;
import com.qf.project.tempproject.bean.fcrBean.FiveEntity;
import com.qf.project.tempproject.utils.fcrUtils.HandlerJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class FiveActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    List<FiveEntity.ListBean> datas;
    FcrFiveActivityAdapter adapter;

    ImageView backIv;
    Button btnH5,btnHBAT;

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String jsonString= (String) msg.obj;
            Gson gson=new Gson();
            FiveEntity entity=gson.fromJson(jsonString,FiveEntity.class);
            datas.addAll(entity.getList());
            adapter=new FcrFiveActivityAdapter(FiveActivity.this,datas);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcr_activity_five);
        String url=getIntent().getStringExtra("fiveUrl");
        initView();
        initData(url);
    }

    private void initData(String url) {
        datas=new ArrayList<>();
        Log.d("fcr","==five接受网址=="+url);
        HandlerJson.getJsonString(url,mHandler);
    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.fcr_five_rv);
        backIv= (ImageView) findViewById(R.id.fcr_five_iv_back);

        btnH5= (Button) findViewById(R.id.fcr_five_Btn_H5);
        btnHBAT= (Button) findViewById(R.id.fcr_five_Btn_HBZT);

        btnH5.setOnClickListener(this);
        btnHBAT.setOnClickListener(this);
        backIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fcr_five_iv_back:
                this.finish();
                break;
            case R.id.fcr_five_Btn_H5:

                break;
            case R.id.fcr_five_Btn_HBZT:
                String url="http://v.jmtopapp.cn/zmsjv3/api/postsubjectlist.php?page=1";
                Intent intent=new Intent(this,FiveHBActivity.class);
                intent.putExtra("fiveHBUrl",url);
                startActivity(intent);

                break;
        }

    }
}
