package com.example.at;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Frag extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDescription;

    ArrayList<String> descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        tvDescription = findViewById(R.id.tvDescription);

        // creating array list for item description.

        descriptions = new ArrayList<>();
        descriptions.add("This is description for item 1");
        descriptions.add("This is description for item 2");
        descriptions.add("This is description for item 3");
        descriptions.add("This is description for item 4");
        descriptions.add("This is description for item 5");
        descriptions.add("This is description for item 6");
        descriptions.add("This is description for item 7");
        descriptions.add("This is description for item 8");
        descriptions.add("This is description for item 9");
        descriptions.add("This is description for item 10");
        descriptions.add("This is description for item 11");

    }

    @Override
    public Void onItemSelected(int index) {
        tvDescription.setText(descriptions.get(index));
        return null;
    }
}