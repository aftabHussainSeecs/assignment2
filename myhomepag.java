package com.example.aftabhussain.integratetwitter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Aftab Hussain on 11/27/2017.
 */

public class MyHomePage extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhomepage);
        String username=getIntent().getStringExtra("username");
        TextView uname=findViewById(R.id.TV_username);
        uname.setText(username);
    }
}
