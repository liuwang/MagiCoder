package io.github.liuwang.magicoder.home.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

import io.github.liuwang.magicoder.R;
import io.github.liuwang.magicoder.home.ShowPhotoActivity;
import io.github.liuwang.magicoder.home.models.Result;
import io.github.liuwang.magicoder.utils.TimeUtil;


/**
 * Created by LiuWang on 11/08/2016.
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder>{
    public static final String TAG = "HomeRecyclerAdapter";
    private List<Result> mData;
    private Activity activity;

    public HomeRecyclerAdapter(Activity activity, List<Result> data) {
        this.mData = data;
        this.activity = activity;
    }

    public void setmData(List<Result> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recycle, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        Result data = mData.get(position);
        holder.mIntrodcution.setText(data.getTitle());
        holder.mDate.setText(TimeUtil.splitPublishedAt(data.getPublishedAt()));
        Document document = Jsoup.parseBodyFragment(data.getContent());
        Element element = document.select("img").first();
        final String imgUrl = element.attr("src");
        Glide.with(activity).load(imgUrl).into(holder.mPhoto);

        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPhotoActivity.startTargetActivity(activity,imgUrl,holder.mPhoto);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }
}
