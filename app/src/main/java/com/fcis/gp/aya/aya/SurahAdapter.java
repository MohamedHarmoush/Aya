package com.fcis.gp.aya.aya;
import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Harmoush on 3/7/2018.
 */


public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {


    private Context context;
    private ArrayList<Surah> surahs;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClickListener(int clikedItemIndex);
    }

    public SurahAdapter(ArrayList<Surah> surahList,ListItemClickListener listener){
        mOnClickListener = listener;
        this.surahs = surahList;
    }
    @Override
    public SurahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surah, parent, false);
        SurahViewHolder holder = new SurahViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final SurahViewHolder holder, final int position) {
        final Surah surah = surahs.get(position);
        holder.surahName.setText(surah.getmSurahName());
        holder.surahNumber.setText(Integer.toString(surah.getmSurahNumber()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onListItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(surahs.size() ==0 )
            return 0;
        else
            return surahs.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.surahName)
        TextView surahName;
        @BindView(R.id.surahNumber)
        TextView surahNumber;
        public SurahViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClickListener(clickedPosition);
        }
    }
}
