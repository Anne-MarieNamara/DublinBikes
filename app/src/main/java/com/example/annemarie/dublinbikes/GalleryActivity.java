package com.example.annemarie.dublinbikes;

/**
 * Created by Anne-Marie on 25/09/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GalleryActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the gallery tab");
        setContentView(textview);
    }
}