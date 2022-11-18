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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPass);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPass);
        Button btn = findViewById(R.id.btnRegister);
        TextView textView = findViewById(R.id.tvLogin);

        etName.addTextChangedListener(getTextWatcher(etName, etEmail,
                etPassword, etConfirmPassword, btn));

        etEmail.addTextChangedListener(getTextWatcher(etName, etEmail,
                etPassword, etConfirmPassword, btn));

        etPassword.addTextChangedListener(getTextWatcher(etName, etEmail,
                etPassword, etConfirmPassword, btn));

        etConfirmPassword.addTextChangedListener(getTextWatcher(etName, etEmail,
                etPassword, etConfirmPassword, btn));

        textView.setOnClickListener(v -> startActivity(new Intent(Register.this,
                LogIn.class)));

        btn.setOnClickListener(v -> startActivity(new Intent(Register.this,
                Start.class)));
    }

    private TextWatcher getTextWatcher(EditText fullName, EditText email, EditText password,
                                       EditText confirmPassword, Button btn) {
        return new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setButtonBackground(fullName, email, password, confirmPassword, btn);
            }
        };
    }

    private void setButtonBackground(EditText fullName, EditText email, EditText password,
                                     EditText confirmPassword, Button btn) {

        if (!fullName.getText().toString().equals("") &&
                !email.getText().toString().equals("") &&
                !password.getText().toString().equals("") &&
                !confirmPassword.getText().toString().equals("")) {

            btn.setBackground(Register.this.getDrawable(R.drawable.button_back_aa));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn.setTextColor(Register.this.getColor(R.color.backgroundButton));
            }
        } else {

            btn.setBackground(Register.this.getDrawable(R.drawable.button_background));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn.setTextColor(Register.this.getColor(R.color.main));
            }
        }
    }
}