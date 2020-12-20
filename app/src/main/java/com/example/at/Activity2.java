package com.example.at;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    TextView tvResultAct2;
    EditText etAct2B;
    Button btnSubmitAct2B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvResultAct2 = findViewById(R.id.tvResultAct2);
        btnSubmitAct2B = findViewById(R.id.btnSubmitAct2B);
        etAct2B = findViewById(R.id.etAct2B);

        tvResultAct2.setVisibility(View.GONE);

        String text = getIntent().getStringExtra("text");

        tvResultAct2.setText("we get the intent: " + text);
        tvResultAct2.setVisibility(View.VISIBLE);




        // sending data back
        btnSubmitAct2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAct2B.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity2.this, "please enter all required field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String data = etAct2B.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("data", data);
                    setResult(RESULT_OK, intent);
                    Activity2.this.finish();
                }
            }
        });
    }
}