package com.qf.project.tempproject.activity.fcrActivity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.qf.project.tempproject.R;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class CollectVideoActivity extends AppCompatActivity{
    @ViewInject(R.id.fcr_play_id)
    private ImageView playImg;
    @ViewInject(R.id.fcr_video_im)
    private ImageView videoIv;
    @ViewInject(R.id.fcr_video_marquee_title)
    private TextView maqueeTitle;
    @ViewInject(R.id.fcr_video_tv)
    private TextView contentMsgTv;
    @ViewInject(R.id.fcr_video_vv)
    private VideoView mVideoView;

    String videoPlayUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.Ext.setDebug(true);
        setContentView(R.layout.fcr_activity_video);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        String title=getIntent().getStringExtra("title");
        maqueeTitle.setText(title);

        String content=getIntent().getStringExtra("content");
        contentMsgTv.setText(content);

        String pic_url=getIntent().getStringExtra("pic_url");
        Picasso.with(this).load(pic_url).resize(1000,600).into(videoIv);

        videoPlayUrl=getIntent().getStringExtra("video_url");

    }

    @Event(R.id.fcr_play_id)
    private void playVideo(View view){
        playImg.setVisibility(View.GONE);
        videoIv.setVisibility(View.GONE);

        Uri uri=Uri.parse(videoPlayUrl);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();

    }
}
