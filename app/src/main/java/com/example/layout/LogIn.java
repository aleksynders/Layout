package com.example.layout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btn = findViewById(R.id.btnLogin);
        TextView textView = findViewById(R.id.podval);
        etEmail.addTextChangedListener(getTextWatcher(etEmail, etPassword, btn));
        etPassword.addTextChangedListener(getTextWatcher(etEmail, etPassword, btn));

        textView.setOnClickListener(v -> startActivity(new Intent(LogIn.this,
                Register.class)));
    }

    private TextWatcher getTextWatcher(EditText etEmail, EditText etPassword, Button btn) {
        return new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setButtonBackground(etEmail, etPassword, btn);
            }
        };
    }
    private void setButtonBackground(EditText etEmail, EditText etPassword, Button btn) {

        if (!etEmail.getText().toString().equals("") &&
                !etPassword.getText().toString().equals("")) {

            btn.setBackground(LogIn.this.getDrawable(R.drawable.button_back_aa));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn.setTextColor(LogIn.this.getColor(R.color.backgroundButton));
            }
        } else {

            btn.setBackground(LogIn.this.getDrawable(R.drawable.button_background));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn.setTextColor(LogIn.this.getColor(R.color.main));
            }
        }
    }
}