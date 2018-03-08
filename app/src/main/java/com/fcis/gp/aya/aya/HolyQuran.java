package com.fcis.gp.aya.aya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohse on 2/14/2018.
 */

public class HolyQuran extends Fragment implements SurahAdapter.ListItemClickListener {

    private SurahAdapter mSurahAdapter;
    private ArrayList<Surah> mSurahs;
    private Context context;
    @BindView(R.id.rv_surahs)
    RecyclerView mSurhsRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.holy_quran_fragment,container,false);
        ButterKnife.bind(this,rootView);
        context = getActivity();
        mSurahs = getSurahs();
        mSurahAdapter = new SurahAdapter(mSurahs,this);
        mLinearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        mSurhsRecyclerView.setAdapter(mSurahAdapter);
        mSurhsRecyclerView.setLayoutManager(mLinearLayoutManager);
        return rootView;
    }

    private ArrayList<Surah> getSurahs() {
        ArrayList<Surah> mSurahs = new ArrayList<>();
        final int mSurahsSize = 114;
        ArrayList<String> mSurahsNames = new ArrayList<>(Arrays.asList("سورة الفاتحة", "سورة البقرة", "سورة آل عمران", "سورة النساء", "سورة المائدة", "سورة الأنعام", "سورة الأعراف", "سورة الأنفال", "سورة التوبة", "سورة يونس", "سورة هود", "سورة يوسف", "سورة الرعد", "سورة إبراهيم", "سورة الحجر", "سورة النحل", "سورة الإسراء", "سورة الكهف", "سورة مريم", "سورة طه", "سورة الأنبياء", "سورة الحج", "سورة المؤمنون", "سورة النور", "سورة الفرقان", "سورة الشعراء", "سورة النمل", "سورة القصص", "سورة العنكبوت", "سورة الروم", "سورة لقمان", "سورة السجدة", "سورة الأحزاب", "سورة سبأ", "سورة فاطر", "سورة يس", "سورة الصافات", "سورة ص", "سورة الزمر", "سورة غافر", "سورة فصلت", "سورة الشورى", "سورة الزخرف", "سورة الدخان", "سورة الجاثية", "سورة الأحقاف", "سورة محمد", "سورة الفتح", "سورة الحجرات", "سورة ق", "سورة الذاريات", "سورة الطور", "سورة النجم", "سورة القمر", "سورة الرحمن", "سورة الواقعة", "سورة الحديد", "سورة المجادلة", "سورة الحشر", "سورة الممتحنة", "سورة الصف", "سورة الجمعة", "سورة المنافقون", "سورة التغابن", "سورة الطلاق", "سورة التحريم", "سورة الملك", "سورة القلم", "سورة الحاقة", "سورة المعارج", "سورة نوح", "سورة الجن", "سورة المزمل", "سورة المدثر", "سورة القيامة", "سورة الإنسان", "سورة المرسلات", "سورة النبأ", "سورة النازعات", "سورة عبس", "سورة التكوير", "سورة الإنفطار", "سورة المطففين", "سورة الانشقاق", "سورة البروج", "سورة الطارق", "سورة الأعلى", "سورة الغاشية", "سورة الفجر", "سورة البلد", "سورة الشمس", "سورة الليل", "سورة الضحى", "سورة الشرح", "سورة التين", "سورة العلق", "سورة القدر", "سورة البينة", "سورة الزلزلة", "سورة العاديات", "سورة القارعة", "سورة التكاثر", "سورة العصر", "سورة الهمزة", "سورة الفيل", "سورة قريش", "سورة الماعون", "سورة الكوثر", "سورة الكافرون", "سورة النصر", "سورة المسد", "سورة الإخلاص", "سورة الفلق", "سورة الناس"));


        for (int i = 1; i <= mSurahsSize; i++) {
            Surah surah = new Surah();
            ArrayList<Integer> mSurahPages = new ArrayList<>();
            surah.setmSurahNumber(i);
            surah.setmSurahName(mSurahsNames.get(i-1));

            if(i == 1 || i == 2){
                mSurahPages.add(i);
                surah.setmSurahPages(mSurahPages);
            }else if (i == 112 || i == 113 || i == 114){
                mSurahPages.add(604);
                surah.setmSurahPages(mSurahPages);
            }else{
                mSurahPages.add(0);
                surah.setmSurahPages(mSurahPages);
            }

            mSurahs.add(surah);
        }
        return mSurahs;
    }

    @Override
    public void onListItemClickListener(int clikedItemIndex) {
        Toast.makeText(context,mSurahs.get(clikedItemIndex).getmSurahName(),Toast.LENGTH_LONG).show();
        Surah surah = mSurahs.get(clikedItemIndex);
        Intent intent = new Intent(context,SurahPageActivity.class);
        intent.putExtra("surah",surah);
        startActivity(intent);
    }
}
