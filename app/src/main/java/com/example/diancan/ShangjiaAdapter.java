package com.example.diancan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ShangjiaAdapter extends RecyclerView.Adapter<ShangjiaAdapter.ViewHolder>{

    private Context mContext;
    private List<Shangjia> mShangjiaList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView Shangjiaimage;
        TextView ShangjiaName;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            Shangjiaimage=(ImageView)view.findViewById(R.id.shangjia_image);
            ShangjiaName=(TextView)view.findViewById(R.id.shangjia_name);
        }
    }
    public ShangjiaAdapter(List<Shangjia> qulist){
        mShangjiaList=qulist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.dian_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Shangjia qu=mShangjiaList.get(position);
                Intent intent=new Intent(mContext,Shangjia_item_Activity.class);
                intent.putExtra(Shangjia_item_Activity.SHANGJIA_NAME,qu.getName());
                intent.putExtra(Shangjia_item_Activity.SHANGJIA_IMAGE_ID,qu.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shangjia shangjia=mShangjiaList.get(position);
        holder.ShangjiaName.setText(shangjia.getName());
        Glide.with(mContext).load(shangjia.getImageId()).into(holder.Shangjiaimage);

    }
    public int getItemCount(){
        return  mShangjiaList.size();
    }
}

