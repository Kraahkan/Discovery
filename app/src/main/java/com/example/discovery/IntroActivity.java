package com.example.discovery;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Title", "Description", R.drawable.curved_shape);
        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard1.setTitleColor(R.color.white);
        ahoyOnboarderCard1.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard1.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard1.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard1.setIconLayoutParams(64, 64, 64, 64, 64, 64);


        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard1);


        setOnboardPages(pages);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.colorPrimary);
        colorList.add(R.color.colorPrimary);
        colorList.add(R.color.colorPrimary);
        setColorBackground(colorList);

        //or

        setColorBackground(R.color.colorPrimary);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);



    }

    @Override
    public void onFinishButtonPressed() {
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("key", 2); //Optional parameters
        this.startActivity(myIntent);
    }
}
