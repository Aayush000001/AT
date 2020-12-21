package com.example.at;

import androidx.annotation.Nullable;
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
    Button btnSubmit, btnSubmitAct2, btnAct2B, btnActFrag;
    TextView tvResult, tvResultAct2B;

    final int ACTIVITY2 = 79;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY2)
        {
            if (resultCode == RESULT_OK)
            {
                String message = data.getStringExtra("data");
                tvResultAct2B.setText(message);
                tvResultAct2B.setVisibility(View.VISIBLE);
            }
            if (resultCode == RESULT_CANCELED)
            {
                tvResultAct2B.setText("no data received from act2, ERROR 404");
                tvResultAct2B.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        btnSubmitAct2 = findViewById(R.id.btnSubmitAct2);
        etAct2 = findViewById(R.id.etAct2);
        tvResultAct2B = findViewById(R.id.tvResultAct2B);
        btnAct2B = findViewById(R.id.btnAct2B);
        btnActFrag = findViewById(R.id.btnActFrag);

        // TvResult view gone
        tvResult.setVisibility(View.GONE);
        tvResultAct2B.setVisibility(View.GONE);

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
                    startActivityForResult(intent, ACTIVITY2); // added twice.
                    startActivity(intent);

                }
            }
        });

        btnAct2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.example.at.Activity2.class);
                startActivityForResult(intent, ACTIVITY2);

            }
        });

        /**
         * this button starts the listFrag and details frag @btnActFrag.
         */

        btnActFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.at.Frag.class);
                startActivity(intent);
            }
        });

    }
}