package com.example.at;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tvResultAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvResultAct2 = findViewById(R.id.tvResultAct2);
        tvResultAct2.setVisibility(View.GONE);

        String text = getIntent().getStringExtra("text");

        tvResultAct2.setText("we get the intent: " + text);
        tvResultAct2.setVisibility(View.VISIBLE);
    }
}