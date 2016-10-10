package com.qf.project.tempproject.adapter.fcrAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.activity.fcrActivity.VideoActivity;
import com.qf.project.tempproject.bean.fcrBean.OneEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class FcrOneFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<OneEntity.ListBean> list;
    Context context;
    List<OneEntity> tempDatas;
    List<OneEntity.KvBean> headList;

    public FcrOneFragmentAdapter(List<OneEntity.ListBean> list,Context context,List<OneEntity.KvBean> headList) {
        this.list = list;
        this.context=context;
        this.headList=headList;
        this.tempDatas=tempDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType==0){
            view=LayoutInflater.from(context).inflate(R.layout.fcr_fragment_one_head,parent,false);
            return new HeaderViewHolder(view);
        }else if(viewType==1){
            view=LayoutInflater.from(context).inflate(R.layout.fcr_item_rv,parent,false);
            return new MyViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder){
            HeaderViewHolder headerViewHolder= (HeaderViewHolder) holder;
            headerViewHolder.headMsg.setText(headList.get(position).getTitle());
            Log.d("fcr","==title=="+headList.get(position).getTitle());
            String headImg=headList.get(position).getPicture();
            Picasso.with(context).load(headImg).resize(800,450).into(headerViewHolder.headImg);

        }else if(holder instanceof MyViewHolder){
            MyViewHolder myViewHolder= (MyViewHolder) holder;
            myViewHolder.msg.setText(list.get(position).getTitle());
            String imgUrl=list.get(position).getPicture();
            Picasso.with(context).load(imgUrl).resize(500,260).into(myViewHolder.picImg);
            String id=list.get(position).getId();
            final String videoUrl="http://v.jmtopapp.cn/zmsjv3/api/video.php?id="+id;
            myViewHolder.picImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, VideoActivity.class);
                    intent.putExtra("videoUrl",videoUrl);
                    context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position==0? 0:1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView picImg;
        TextView msg;
        public MyViewHolder(View itemView) {
            super(itemView);
            picImg= (ImageView) itemView.findViewById(R.id.fcr_onefragment_item_im);
            msg= (TextView) itemView.findViewById(R.id.fcr_onefragment_item_tv);
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder{
        ImageView headImg;
        TextView headMsg;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            headImg= (ImageView) itemView.findViewById(R.id.fcr_head_im);
            headMsg= (TextView) itemView.findViewById(R.id.fcr_head_tv);
        }
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams params=holder.itemView.getLayoutParams();
        if (params!=null&&params instanceof StaggeredGridLayoutManager.LayoutParams&&holder.getLayoutPosition()==0){
            StaggeredGridLayoutManager.LayoutParams p= (StaggeredGridLayoutManager.LayoutParams) params;
            p.setFullSpan(true);
        }
    }
}
