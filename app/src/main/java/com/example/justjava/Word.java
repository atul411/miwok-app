package com.example.justjava;

public class Word{

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioId;

    public Word(String DefaultTranslation, String MiwokTranslation, int Imageid, int Audioid){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = Imageid;
        mAudioId = Audioid;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return  mImageResourceId;
    }

    public int AudioResourceId(){
        return  mAudioId;
    }
}