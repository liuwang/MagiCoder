package io.github.liuwang.magicoder.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.liuwang.magicoder.R;


/**
 * Created by LiuWang on 11/08/2016.
 */
public class HomeViewHolder extends RecyclerView.ViewHolder{
    public TextView mTitle;
    public TextView mIntrodcution;
    public TextView mDate;
    public ImageView mPhoto;
    public HomeViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.tv_title);
        mDate = (TextView) itemView.findViewById(R.id.tv_date);
        mIntrodcution = (TextView) itemView.findViewById(R.id.tv_introduction);
        mPhoto = (ImageView) itemView.findViewById(R.id.iv_girl);
    }
}
