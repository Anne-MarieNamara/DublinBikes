package com.example.annemarie.dublinbikes;

import android.net.Uri;
import android.location.Location;


/**
 * Created by Anne-Marie on 26/09/2017.
 */

public class Photo {

    private String mTitle;
    private Uri mStorageLocation;
    private String mTag1;
    private String mTag2;
    private String mTag3;

    public String getmTitle(){
        return mTitle;
    }

    public void setmTitle(String title){
        this.mTitle = title;
    }

    public Uri getmStorageLocation(){
        return mStorageLocation;
    }

    public void setmStorageLocation (Uri storageLocation){
        this.mStorageLocation = storageLocation;
    }

    public String getmTag1(){
        return mTag1;
    }

    public void setmTag1 (String tag1){
        this.mTag1 = tag1;
    }

    public String getmTag2(){
        return mTag2;
    }

    public void setmTag2(String tag2){
        this.mTag2 = tag2;
    }

    public String getmTag3(){
        return mTag3;
    }

    public void setmTag3(String tag3){
        this.mTag3 = tag3;
    }
}
