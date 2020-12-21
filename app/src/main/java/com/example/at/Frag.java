package com.example.at;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Frag extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDescription;

    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        tvDescription = findViewById(R.id.tvDescription);

        // creating array list for item description.

        descriptions = getResources().getStringArray(R.array.descriptions);

    }

    @Override
    public Void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);
        return null;
    }
}