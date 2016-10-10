package com.qf.project.tempproject.activity.fcrActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.adapter.fcrAdapter.FcrTwoActivityAdapter;
import com.qf.project.tempproject.bean.fcrBean.VideoEntity;
import com.qf.project.tempproject.sqliteBean.RecordDBManager;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class TwoActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ListView mListView;
    ImageView imgBack;
    List<VideoEntity> datas;
    FcrTwoActivityAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcr_activity_two);
        initView();
        initData();
        adapter=new FcrTwoActivityAdapter(this,datas);
        mListView.setAdapter(adapter);
    }

    private void initData() {
        RecordDBManager dbManager=new RecordDBManager(this);
        datas=dbManager.queryRecord();
    }

    private void initView() {
        mListView= (ListView) findViewById(R.id.fcr_two_lv);
        imgBack= (ImageView) findViewById(R.id.fcr_two_iv_back);

        imgBack.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecordDBManager dbManager=new RecordDBManager(this);
        List<VideoEntity> list=dbManager.queryRecord();

        String title=list.get(position).getTitle();
        String content=list.get(position).getContent();
        String videoPlayUrl=list.get(position).getVideo240();
        String pic_url=list.get(position).getPicture();
        String columnName=list.get(position).getColumn();

        Intent intent=new Intent(this,CollectVideoActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("pic_url",pic_url);
        intent.putExtra("video_url",videoPlayUrl);
        intent.putExtra("columnName",columnName);
        startActivity(intent);
    }
}
