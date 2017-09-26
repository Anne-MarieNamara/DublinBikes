package com.example.annemarie.dublinbikes;

/**
 * Created by Anne-Marie on 25/09/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*public class PhotoActivity extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the Photo tab");
        setContentView(textview);
    }*/

    public class PhotoActivity extends Fragment{

        private static final int CAMERA_REQUEST = 123;
        private ImageView mImageView;

        // This is where the image will be stored
        private  Uri mImageUri = Uri.EMPTY;

        // Saving the image here
        String mMyPhotopath;

        // A reference to mylocal database
        private DataManager mDataManager;

        @Override
        public void onCreate (Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
        }

        @Override
        public void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            mDataManager =
                    new DataManager(getActivity())
                    .getApplicationContext());
        }

    }

