package com.vlogellaa.espresso.ufl.ui.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.models.Dates;
import com.vlogellaa.espresso.ufl.models.Game;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecycleAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> content;
    private final int DATE = 0, GAME = 1;

    public RecycleAdapter(ArrayList<Object> content) {
        this.content = content;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case DATE:
                View v1 = inflater.inflate(R.layout.day_row, parent, false);
                viewHolder = new DatesViewHolder(v1);
                break;
            case GAME:
                View v2 = inflater.inflate(R.layout.game_row, parent, false);
                viewHolder = new GamesViewHolder(v2);
                break;
            default:
                View v = inflater.inflate(R.layout.day_row, parent, false);
                viewHolder = new DatesViewHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case DATE:
                DatesViewHolder datesViewHolder = (DatesViewHolder) holder;
                configureDatesViewHolder(datesViewHolder, position);
                break;
            case GAME:
                GamesViewHolder gamesViewHolder = (GamesViewHolder) holder;
                configureGamesViewHolder(gamesViewHolder, position);
                break;

        }
    }

    private void configureDatesViewHolder(DatesViewHolder datesViewHolder, int position) {
        Dates date = (Dates) content.get(position);
        if (date != null) {
            datesViewHolder.dayText.setText(date.getDate());
        }
    }

    private void configureGamesViewHolder(GamesViewHolder gamesViewHolder, int position) {
        Game game = (Game) content.get(position);
        if (game != null) {
            gamesViewHolder.teamOne.setText(game.getTeam_one());
            gamesViewHolder.teamTwo.setText(game.getTime());
            gamesViewHolder.timeText.setText(game.getTeam_two());
        }
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

    static class GamesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.team_one_text)
        TextView teamOne;
        @BindView(R.id.team_two_text)
        TextView teamTwo;
        @BindView(R.id.time_text)
        TextView timeText;

        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



}
