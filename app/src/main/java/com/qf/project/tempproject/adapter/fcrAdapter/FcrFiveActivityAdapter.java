package com.qf.project.tempproject.adapter.fcrAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.bean.fcrBean.FiveEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class FcrFiveActivityAdapter extends RecyclerView.Adapter<FcrFiveActivityAdapter.FiveViewHolder>{

    Context mContext;
    List<FiveEntity.ListBean> list;

    public FcrFiveActivityAdapter(Context context, List<FiveEntity.ListBean> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public FiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.fcr_five_item_rv,parent,false);
        return new FiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FiveViewHolder holder, int position) {
        holder.titleTv.setText(list.get(position).getTitle());
        String imgUrl=list.get(position).getPicture();
        Picasso.with(mContext).load(imgUrl).resize(1000,600).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FiveViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView titleTv;
        public FiveViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.fcr_five_item_im);
            titleTv= (TextView) itemView.findViewById(R.id.fcr_five_item_tv);
        }
    }
}
