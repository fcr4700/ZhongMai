package com.qf.project.tempproject.adapter.fcrAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.bean.fcrBean.VideoEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class FcrFourAcitivityAdapter extends BaseAdapter{

    Context context;
    List<VideoEntity> list;

    public FcrFourAcitivityAdapter(Context context, List<VideoEntity> list) {
        this.context = context;
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
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.fcr_four_item_lv,parent,false);
            viewHolder.img= (ImageView) convertView.findViewById(R.id.fcr_four_item_iv);
            viewHolder.titleTv= (TextView) convertView.findViewById(R.id.fcr_four_item_tv);
            viewHolder.columnTv= (TextView) convertView.findViewById(R.id.fcr_four_item_tv_column);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.titleTv.setText(list.get(position).getTitle());
        viewHolder.columnTv.setText(list.get(position).getColumn());
        String imgUrl=list.get(position).getPicture();
        Picasso.with(context).load(imgUrl).resize(1000,600).into(viewHolder.img);
        Log.d("sqlite","==adapter.title=="+list.get(position).getTitle());
        Log.d("sqlite","==adapter.column=="+list.get(position).getColumn());
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView titleTv,columnTv;
    }
}
