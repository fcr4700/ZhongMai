package com.qf.project.tempproject.activity.fcrActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.qf.project.tempproject.R;
import com.qf.project.tempproject.bean.fcrBean.VideoEntity;
import com.qf.project.tempproject.sqliteBean.MyDBManager;
import com.qf.project.tempproject.sqliteBean.RecordDBManager;
import com.qf.project.tempproject.utils.fcrUtils.HandlerJson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class VideoActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    VideoView mVideoView;
    ImageView mImageView,backImg,playImg;
    TextView mTextView,title;

    CheckBox chbCollect;

    List<VideoEntity> datas;
    VideoEntity entity;

    String url;

    String videoPlayUrl;
    MediaController mController;

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String jsonString= (String) msg.obj;
            Gson gson=new Gson();
            entity=gson.fromJson(jsonString,VideoEntity.class);

            String videoUrl=entity.getPicture();

            Picasso.with(getApplicationContext()).load(videoUrl).into(mImageView);

            mTextView.setText("        "+entity.getContent());
            title.setText(entity.getTitle());

            String videoUri=entity.getVideo240();
            videoPlayUrl=videoUri;
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcr_activity_video);
        initView();
        initData();

        playImg.setOnClickListener(this);
    }

    private void initData() {
        datas=new ArrayList<>();
        url=getIntent().getStringExtra("videoUrl");
        Log.d("fcr","==传过来的网址："+url);
        HandlerJson.getJsonString(url,mHandler);
    }

    private void initView() {
        mVideoView= (VideoView) findViewById(R.id.fcr_video_vv);
        mImageView= (ImageView) findViewById(R.id.fcr_video_im);
        mTextView= (TextView) findViewById(R.id.fcr_video_tv);
        title= (TextView) findViewById(R.id.fcr_video_marquee_title);
        backImg= (ImageView) findViewById(R.id.fcr_video_back_im);
        playImg= (ImageView) findViewById(R.id.fcr_play_id);

        chbCollect= (CheckBox) findViewById(R.id.fcr_video_chb_collect);
        chbCollect.setOnCheckedChangeListener(this);
    }
    public void backOnClick(View view){
        this.finish();
    }

    @Override
    public void onClick(View v) {
        mImageView.setVisibility(View.GONE);
        playImg.setVisibility(View.GONE);
        RecordDBManager dbManager=new RecordDBManager(this);
        dbManager.addRecordData(entity);
        Toast.makeText(this,"播放记录数据库",Toast.LENGTH_SHORT).show();

        Uri uri=Uri.parse(videoPlayUrl);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(uri);

        //mVideoView.setVideoURI(Uri.parse(videoPlayUrl));
       // mVideoView.setMediaController(mController);
        //mController.setMediaPlayer(mVideoView);
        Log.d("fcr","==videoPlayUrl=="+Uri.parse(videoPlayUrl));
        mVideoView.requestFocus();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        MyDBManager dbManager=new MyDBManager(VideoActivity.this);

        dbManager.addSqliteData(entity);

        Toast.makeText(this,"收藏成功",Toast.LENGTH_SHORT).show();
    }
}
