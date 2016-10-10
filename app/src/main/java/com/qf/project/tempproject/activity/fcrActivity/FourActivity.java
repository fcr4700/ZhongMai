package com.qf.project.tempproject.activity.fcrActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.adapter.fcrAdapter.FcrFourAcitivityAdapter;
import com.qf.project.tempproject.bean.fcrBean.VideoEntity;
import com.qf.project.tempproject.sqliteBean.MyDBManager;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class FourActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mListView;
    List<VideoEntity> datas;
    FcrFourAcitivityAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcr_activity_four);
        initView();
        initData();
        adapter=new FcrFourAcitivityAdapter(FourActivity.this,datas);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);

    }

    private void initData() {
        MyDBManager dbManager=new MyDBManager(FourActivity.this);
        datas=dbManager.qurey();
        Log.d("sqlitequ","==datas=="+datas.size());

    }

    private void initView() {
        mListView= (ListView) findViewById(R.id.fcr_four_lv);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点中了"+position,Toast.LENGTH_SHORT).show();
        MyDBManager dbManager=new MyDBManager(this);
        List<VideoEntity> entities=dbManager.qurey();
        String pic_url=entities.get(position).getPicture();
        String title=entities.get(position).getTitle();
        String video_url=entities.get(position).getVideo240();
        String content=entities.get(position).getContent();

        Intent intent=new Intent(this,CollectVideoActivity.class);
        intent.putExtra("pic_url",pic_url);
        intent.putExtra("title",title);
        intent.putExtra("video_url",video_url);
        intent.putExtra("content",content);
        startActivity(intent);
        Log.d("testsqlite","=="+pic_url);
        Log.d("testsqlite","=="+content);
    }
}
