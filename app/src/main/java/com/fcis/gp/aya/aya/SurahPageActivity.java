package com.fcis.gp.aya.aya;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurahPageActivity extends AppCompatActivity {

    @BindView(R.id.iv_quran_page)
    ImageView mSurahPage;
    private Surah mSurah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_page);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mSurah = intent.getParcelableExtra("surah");
        char[] pageNum = Integer.toString( mSurah.getmSurahPages().get(0)).toCharArray();
        String name ="";
        if (pageNum.length == 1){
            name ="00";
            name += pageNum[0];
        }
        else if(pageNum.length == 2){
            name ="0";
            name += pageNum[0];
            name += pageNum[1];
        }

        else{
            name += pageNum[0] ;
            name += pageNum[1];
            name +=pageNum[2];
        }


        int checkExistence = this.getResources().getIdentifier("page"+name, "drawable", getPackageName());

        if ( checkExistence != 0 ) {  // the resouce exists...
            //result = true;
            mSurahPage.setImageResource(checkExistence);
        }
        else {  // checkExistence == 0  // the resouce does NOT exist!!
            //result = false;
            mSurahPage.setImageResource(R.drawable.page001);
        }
        //mSurahPage.setImageBitmap(loadImageBitmap(getApplicationContext(), "page"+name+".png"));
    }
    public Bitmap loadImageBitmap(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream    = context.openFileInput(imageName);
            bitmap      = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 3, Something went wrong!");
            e.printStackTrace();
        }
        return bitmap;
    }
}
