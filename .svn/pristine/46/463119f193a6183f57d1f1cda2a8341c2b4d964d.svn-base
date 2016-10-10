package com.qf.project.tempproject.adapter.fcrAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.bean.fcrBean.VideoEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class FcrVideoAdapter extends BaseAdapter{

    Context mContext;
    List<VideoEntity> list;

    public FcrVideoAdapter(Context context, List<VideoEntity> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VideoViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new VideoViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.fcr_activity_video,null);

        }else{}
        return convertView;
    }

    class VideoViewHolder{
        ImageView videoImg;
        TextView videoMsg;
    }
}
