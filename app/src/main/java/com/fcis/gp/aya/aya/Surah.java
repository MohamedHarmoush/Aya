package com.fcis.gp.aya.aya;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by harmoush on 3/5/18.
 */

public class Surah implements Parcelable {
    private int mSurahNumber;
    private String mSurahName;
    private ArrayList<Integer> mSurahPages;

    public Surah(){}
    public Surah(int mSurahNumber, String mSurahName, ArrayList<Integer> mSurahPages) {
        this.mSurahNumber = mSurahNumber;
        this.mSurahName = mSurahName;
        this.mSurahPages = mSurahPages;
    }

    public int getmSurahNumber() {
        return mSurahNumber;
    }

    public void setmSurahNumber(int mSurahNumber) {
        this.mSurahNumber = mSurahNumber;
    }

    public String getmSurahName() {
        return mSurahName;
    }

    public void setmSurahName(String mSurahName) {
        this.mSurahName = mSurahName;
    }

    public ArrayList<Integer> getmSurahPages() {
        return mSurahPages;
    }

    public void setmSurahPages(ArrayList<Integer> mSurahPages) {
        this.mSurahPages = mSurahPages;
    }

    protected Surah(Parcel in) {
        mSurahNumber = in.readInt();
        mSurahName = in.readString();
        if (in.readByte() == 0x01) {
            mSurahPages = new ArrayList<Integer>();
            in.readList(mSurahPages, Integer.class.getClassLoader());
        } else {
            mSurahPages = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSurahNumber);
        dest.writeString(mSurahName);
        if (mSurahPages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mSurahPages);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Surah> CREATOR = new Parcelable.Creator<Surah>() {
        @Override
        public Surah createFromParcel(Parcel in) {
            return new Surah(in);
        }

        @Override
        public Surah[] newArray(int size) {
            return new Surah[size];
        }
    };
}