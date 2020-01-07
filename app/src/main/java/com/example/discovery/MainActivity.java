package com.example.discovery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.app_name);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Customize colors

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(Color.parseColor("#0000ff"));


        Sneaker.with(this) // Activity, Fragment or ViewGroup
                .setTitle("Success!!")
                .setMessage("This is the success message")
                .sneakSuccess();


        // https://github.com/yuyakaido/CardStackView
        // https://github.com/flschweiger/SwipeStack
        // https://github.com/UFreedom/FloatingView
        // https://github.com/XunMengWinter/CircularAnim
        // https://github.com/JoaquimLey/faboptions
        // https://github.com/codemybrainsout/ahoy-onboarding
        // https://github.com/skyfe79/AndroidGradientImageView
        // https://github.com/Kraahkan?after=Y3Vyc29yOnYyOpK5MjAxNi0xMC0xN1QxNjoxOToyNS0wNzowMM4EMmfr&tab=stars
        // https://github.com/LiveTyping/CannyViewAnimator
        // https://github.com/iammert/ScalingLayout
        // https://github.com/PHELAT/Fun
        // https://github.com/igalata/Bubble-Picker
        // https://github.com/jinatonic/confetti
        // https://github.com/aurelhubert/ahbottomnavigation
        // https://github.com/ncapdevi/FragNav
        // https://github.com/Shashank02051997/FancyToast-Android
        // https://github.com/saket/InboxRecyclerView


    }

}
