package com.vlogellaa.espresso.ufl.ui.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlogellaa.espresso.ufl.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecycleAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class DatesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_text)
        TextView dayText;

        public DatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
