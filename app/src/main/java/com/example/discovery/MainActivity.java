package com.example.discovery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jinatonic.confetti.CommonConfetti;
import com.irozon.sneaker.Sneaker;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.app_name);
                    FancyToast.makeText(getApplicationContext(),"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true);
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
        ViewGroup mainViewGroup = findViewById(R.id.container);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Customize colors

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        Window window = this.getWindow();

        // Don't need for this app
        navView.setVisibility(View.INVISIBLE);

        if(Build.VERSION.SDK_INT >= 21.0){

            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //this code will be executed on devices running on DONUT (NOT ICS) or later
            window.setStatusBarColor(Styles.getPrimary());
        }

        /* Sneaker.with(this) // Activity, Fragment or ViewGroup
                .setTitle("Success!!")
                .setMessage("This is the success message")
                .sneakSuccess();*/


        // Make success feel great
        FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
        CommonConfetti.rainingConfetti((ViewGroup)mTextMessage.getParent(), new int[] { Color.BLUE })
                .infinite();
        CommonConfetti.explosion(mainViewGroup,500,500,new int[] { Color.BLACK });

        if (1 == 0)
            new FancyGifDialog.Builder(this)
                    .setTitle("Granny eating chocolate dialog box")
                    .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.")
                    .setPositiveBtnText("Ok")
                    .setPositiveBtnBackground("#FF4081")
                    .setGifResource(R.drawable.gif1)   //Pass your Gif here
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();


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
        //
        // https://github.com/saket/InboxRecyclerView


    }

}
