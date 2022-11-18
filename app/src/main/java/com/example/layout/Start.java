package com.example.layout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btn = findViewById(R.id.btnStart);
        btn.setOnClickListener(v -> startActivity(new Intent(Start.this,
                MainActivity.class)));
    }
}