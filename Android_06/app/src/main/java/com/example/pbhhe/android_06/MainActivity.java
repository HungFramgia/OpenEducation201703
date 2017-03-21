package com.example.pbhhe.android_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    //Bat su kien trong java
    //1 Khai bao bien
    private Button mButtonTouchMe;
    //c1. implement onCLick
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2. Anh xa no voi file layout

        mButtonTouchMe= (Button) findViewById(R.id.button_touch_me);

        //3. Bat su kien cho button
        mButtonTouchMe.setOnClickListener(this);

        //long click
        mButtonTouchMe.setOnLongClickListener(this);

        //c2 Tao ra 1 bien cho onClickListenner
        mButtonTouchMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //c3 tao 1 ham onTouchMeCllick va sua .xml
    public void onTouchMeClick(View v){
        Toast.makeText(this, "Touch Me Click", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        switch (v.getId()){
            case R.id.button_touch_me:
                ((Button) v).setText("12345");
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "Long clicked", Toast.LENGTH_SHORT).show();
        return false;
    }
}

