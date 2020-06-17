package com.example.healthnote.adapter;

import android.content.Context;
import android.view.View;

import com.example.healthnote.R;

public class AchievementAdapter extends MyRecyclerAdapter<TxtAndChooseBean>{
    public AchievementAdapter(Context context, List<TxtAndChooseBean> mList, int mLayoutId) {
        super(context, mList, mLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, TxtAndChooseBean data, int position) {
        holder.setText(R.id.rv_achievement_txt, data.getTitle());
        if (data.getStatus() == 2) {
            holder.getView(R.id.rv_achievement_img).setVisibility(View.GONE);
        } else {
            holder.getView(R.id.rv_achievement_img).setVisibility(View.VISIBLE);
            holder.setImageResource(R.id.rv_achievement_img, data.getStatus() == 0 ? R.drawable.cuohao : R.drawable.duihao);
        }
    }
}

}
