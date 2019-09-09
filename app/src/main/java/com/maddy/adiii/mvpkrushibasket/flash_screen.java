package com.maddy.adiii.mvpkrushibasket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.maddy.adiii.mvpkrushibasket.Customer.Activities.CustomerHomePage;

import static android.view.Window.FEATURE_NO_TITLE;

public class flash_screen extends AppCompatActivity {
    private static final String TAG = "splashscreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_flash_screen);

        Log.d(TAG, "onCreate: Get started");

     new CountDownTimer(3000,1000) {

         @Override
         public void onTick(long millisUntilFinished) {

         }

         @Override
         public void onFinish() {
             Intent intent = new Intent( flash_screen.this, CustomerHomePage.class);
             startActivity(intent);
         }
     }.start();
     }
}
