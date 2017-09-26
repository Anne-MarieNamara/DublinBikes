package com.example.annemarie.dublinbikes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anne-Marie on 26/09/2017.
 */

public class DataManager {

    // creating my database
    private SQLiteDatabase db;

    // putting in the table rows that can be accessed out this class
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_TITLE = "image_title";
    public static final String TABLE_ROW_URI = "image_uri";

    // private so it can be referred to just inside this class
    private static final String DB_NAME="mylocal_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_PHOTOS = "mylocal_table_photos";
    private static final String TABLE_TAGS = "mylocal_table_tags";
    private static final String TABLE_ROW_TAG1 = "tag1";
    private static final String TABLE_ROW_TAG2 = "tag2";
    private static final String TABLE_ROW_TAG3 = "tag3";
    public static final String TABLE_ROW_TAG ="tags"; // for the tags table

    public DataManager(Context context) {
        // create an instance of my SQLite openhelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

// create a writable database
        db = helper.getWritableDatabase();
    }

    // Add the add photo method
    public void addPhoto (Photo photo){
        String query = "INSERT INTO" + TABLE_PHOTOS + " (" +
                TABLE_ROW_TITLE + " " +
                TABLE_ROW_URI + ", " +
                TABLE_ROW_TAG1 + ", " +
                TABLE_ROW_TAG2 +", " +
                TABLE_ROW_TAG3 +", " +
                "VALUES (" +
                "'" + photo.getmTitle()+ "'" + "," +
                "'" + photo.getmStorageLocation() + "'" + ", "+
                "'" + photo.getmTag1()+ "'" + "," +
                "'" + photo.getmTag2()+ "'" + "," +
                "'" + photo.getmTag3()+ "'" + "," +
                ");";

        Log.i("addPhoto()",query);

        db.execSQL(query);
        // adding in new code to the tags table
        query = "INSERT INTO" + TABLE_TAGS + "("+
                TABLE_ROW_TAG+ ")"+
                "SELECT '"+ photo.getmTag1() +"'"+
                "WHERE NOT EXISTS (SELECT 1 FROM " +
                TABLE_TAGS +
                "WHERE" + TABLE_ROW_TAG + " = " +
                "'" + photo.getmTag1() + "');";

        db.execSQL(query);

        query = "INSERT INTO" + TABLE_TAGS + "("+
                TABLE_ROW_TAG+ ")"+
                "SELECT '"+ photo.getmTag2() +"'"+
                "WHERE NOT EXISTS (SELECT 1 FROM " +
                TABLE_TAGS +
                "WHERE" + TABLE_ROW_TAG + " = " +
                "'" + photo.getmTag2() + "');";

        db.execSQL(query);

        query = "INSERT INTO" + TABLE_TAGS + "("+
                TABLE_ROW_TAG+ ")"+
                "SELECT '"+ photo.getmTag3() +"'"+
                "WHERE NOT EXISTS (SELECT 1 FROM " +
                TABLE_TAGS +
                "WHERE" + TABLE_ROW_TAG + " = " +
                "'" + photo.getmTag3() + "');";

        db.execSQL(query);
    } // End of adding the photo


    public Cursor getTitles(){
        Cursor X = db.rawQuery("SELECT" + TABLE_ROW_ID + ",
                "+ TABLE_ROW_TITLE +  ")
    }

    public Cursor getTitlesWithTag(String tag) {
        Cursor x = db.rawQuery("SELECT " + TABLE_ROW_ID + ", " +
                        TABLE_ROW_TITLE + " from " +
                        TABLE_PHOTOS + " WHERE " +
                        TABLE_ROW_TAG1 + " = '" + tag + "' or " +
                        TABLE_ROW_TAG2 + " = '" + tag + "' or " +
                        TABLE_ROW_TAG3 + " = '" + tag + "';"
                , null);
        x.moveToFirst();

        return x;
    }

    public Cursor getPhoto(int id) {
        Cursor x = db.rawQuery("SELECT * from " +
                TABLE_PHOTOS +
                " WHERE " +
                TABLE_ROW_ID + " = " + id, null);

        x.moveToFirst();
        return x;
    }

    public Cursor getTags() {
        Cursor y = db.rawQuery("SELECT " + TABLE_ROW_ID + ", " + TABLE_ROW_TAG + " from " + TABLE_TAGS, null);
        y.moveToFirst();

        return y;
    }

    // When the DataManager is initialsed, this class is created
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // This method will only run the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Creating a table for the photos and all their tags info
            String newTableQueryString = "create table "
                    + TABLE_PHOTOS + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_TITLE
                    + " text not null,"
                    + TABLE_ROW_URI
                    + " text not null,"
                    + TABLE_ROW_TAG1
                    + " text not null,"
                    + TABLE_ROW_TAG2
                    + " text not null,"
                    + TABLE_ROW_TAG3
                    + " text not null" + ");";

            db.execSQL(newTableQueryString);

            // This creates another table for the tags
            newTableQueryString = "create table "
                    + TABLE_TAGS + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_TAG
                    + " text not null" + ");";

            db.execSQL(newTableQueryString);
        }

        // method that only runs if the DB_VERSION is incremented
        @Override
        public void onUpgrade(SQLiteDatabase db, int previousVersion, int nextVersion) {

        }

        }

    }






