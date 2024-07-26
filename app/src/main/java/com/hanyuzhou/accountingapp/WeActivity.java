package com.hanyuzhou.accountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class WeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we);
        TextView scrollableTextView = findViewById(R.id.textViewAboutUs);
        scrollableTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}