package com.example.at;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAct2;
    Button btnSubmit, btnSubmitAct2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        btnSubmitAct2 = findViewById(R.id.btnSubmitAct2);
        etAct2 = findViewById(R.id.etAct2);

        // TvResult view gone
        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "please enter your name",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    tvResult.setText("Welcome `" + name);

                    tvResult.setVisibility(View.VISIBLE);
                    // TvResult view restored
                }

            }
        });

        btnSubmitAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAct2.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter all required fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String text = etAct2.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this, com.example.at.Activity2.class);
                    intent.putExtra("text", text);
                    startActivity(intent);
                }
            }
        });
    }
}