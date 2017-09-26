package com.example.annemarie.dublinbikes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the Login button
        final Button loginButton = (Button) findViewById(R.id.gotologin_button);
        // Get a reference to the Register button
        final Button registerButton = (Button) findViewById(R.id.register_button);



         class ButtonActivity extends Activity {

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Get a reference to the Press Me Button
                final Button loginButton = (Button) findViewById(R.id.gotologin_button);

                // Set an OnClickListener on this Button
                // Called each time the user clicks the Button
                loginButton.setOnClickListener(new OnClickListener() {
                  // need to put in some code here to say what the onclick listener is doing
                });

                // make a new intent to move from main to threeTabActivity
                Intent myIntent = new Intent (this, ThreeTabActivity.class);

                // Switch to ThreeTAbActivity
                startActivity(myIntent);
            }

             private void startActivity(Intent myIntent) {

             }
         }



    }
}
