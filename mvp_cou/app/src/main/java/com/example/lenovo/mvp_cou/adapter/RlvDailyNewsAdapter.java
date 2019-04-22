package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.DailyNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvDailyNewsAdapter extends RecyclerView.Adapter {
    private Context mcontext;
    private ArrayList<DailyNewsBean.StoriesBean> mnewlist;
    private ArrayList<DailyNewsBean.TopStoriesBean> mbanners;
    private static final int TYPE_BANNER = 0;
    private static final int TYPE_TIME = 1;
    private static final int TYPE_NEWS = 2;
    private String mData = "今日新闻";

    public RlvDailyNewsAdapter(Context mcontext, ArrayList<DailyNewsBean.StoriesBean> mnewlist, ArrayList<DailyNewsBean.TopStoriesBean> mbanners, String mData) {
        this.mcontext = mcontext;
        this.mnewlist = mnewlist;
        this.mbanners = mbanners;
        this.mData = mData;
    }

    public void setmData(String mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (viewType == TYPE_BANNER) {
            return new BannerVH(inflater.inflate(R.layout.item_banner, parent,false));

        } else if (viewType == TYPE_TIME) {
            return new TimmerVH(inflater.inflate(R.layout.item_timer, parent,false));

        } else {
            return new NewsVH(inflater.inflate(R.layout.item_timer, parent,false));

        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_BANNER) {

            BannerVH banner = (BannerVH) holder;
            banner.item_banner.setImages(mbanners).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {

                    DailyNewsBean.TopStoriesBean image = (DailyNewsBean.TopStoriesBean) path;

                    Glide.with(mcontext).load(image.getImage()).into(imageView);
                }
            }).start();
        } else if (viewType == TYPE_TIME) {
            TimmerVH timer = (TimmerVH) holder;
            timer.timer_tv.setText(mData);
        } else {
            NewsVH newsVH = (NewsVH) holder;
            int newPosition = position - 1;
            if (mbanners.size() > 0) {
                newPosition -= 1;
            }
            DailyNewsBean.StoriesBean storiesBean = mnewlist.get(newPosition);
            newsVH.timer_tv2.setText(storiesBean.getTitle());

        }


    }

    @Override
    public int getItemViewType(int position) {
        if (mbanners.size() > 0) {
            if (position == 0) {
                return TYPE_BANNER;
            } else if (position == 1) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        } else {
            if (position == 0) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mbanners.size() > 0) {
            return mnewlist.size() + 1 + 1;
        } else {
            return mnewlist.size() + 1;
        }
    }

    public void setData(DailyNewsBean loginBean) {
        mData = loginBean.getDate();
        mbanners.clear();
        if (loginBean.getTop_stories() != null && loginBean.getTop_stories().size() > 0) {
            mbanners.addAll(loginBean.getTop_stories());
        }
        mnewlist.clear();
        if (loginBean.getStories() != null && loginBean.getStories().size() > 0) {
            mnewlist.addAll(loginBean.getStories());
        }
        notifyDataSetChanged();
    }

    class BannerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.item_banner)
        Banner item_banner;

        public BannerVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class TimmerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.timer_tv)
        TextView timer_tv;

        public TimmerVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class NewsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.timer_tv)
        TextView timer_tv2;

        public NewsVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
