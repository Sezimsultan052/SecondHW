package com.example.secondhw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView tvVhod, tvRegister, tvLogin;
    private EditText editMail, editPassword;
    private LinearLayout linearForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvVhod = findViewById(R.id.tv_vhod);
        tvRegister = findViewById(R.id.tv_register);
        button = findViewById(R.id.btn_login);
        editMail = findViewById(R.id.edt_mail);
        editPassword = findViewById(R.id.edt_password);
        tvLogin = findViewById(R.id.tv_login);
        linearForgotPassword = findViewById(R.id.linear_forgot_password);

        editMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(editMail.getText().toString())) {
                    button.setBackgroundColor(Color.parseColor("#A4A4A4"));
                } else {
                    button.setBackgroundColor(Color.parseColor("#E86129"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(editPassword.getText().toString())) {
                    button.setBackgroundColor(Color.parseColor("#A4A4A4"));
                } else {
                    button.setBackgroundColor(Color.parseColor("#E86129"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        button.setOnClickListener(view -> {
            String email = editMail.getText().toString();
            String password = editPassword.getText().toString();
            if (email.equals("admin@gmail.com") && password.equals("admin")) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                tvLogin.animate().alpha(0f);
                tvRegister.animate().alpha(0f);
                tvVhod.animate().alpha(0f);
                editMail.animate().alpha(0f);
                editPassword.animate().alpha(0f);
                linearForgotPassword.animate().alpha(0f);
                button.animate().alpha(0f);
                hideKeyboard();
            } else {
                Toast.makeText(MainActivity.this, "Вы неправильно ввели логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hideKeyboard( ) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }
}