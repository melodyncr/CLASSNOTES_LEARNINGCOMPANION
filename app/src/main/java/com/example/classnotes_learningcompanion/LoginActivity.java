// LoginActivity.java
package com.example.classnotes_learningcompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String BUTTON_STATE = "ButtonState";

    ActivityLoginBinding binding;

    Button loginButton;
    boolean isLoggedIn = false;

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginButton = binding.loginButton;

        if (savedInstanceState != null) {
            isLoggedIn = savedInstanceState.getBoolean(BUTTON_STATE, false);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logic to handle login
                // For simplicity, just toggle the login state
                isLoggedIn = !isLoggedIn;
                navigateToNextPage();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUTTON_STATE, isLoggedIn);
    }

    private void navigateToNextPage() {
        if (isLoggedIn) {
            // User is logged in, navigate to NoteActivity
            Intent intent = NoteActivity.intentFactory(getApplicationContext());
            startActivity(intent);
        } else {
            // User is not logged in, navigate to RegisterActivity
            Intent intent = RegisterActivity.intentFactory(getApplicationContext());
            startActivity(intent);
        }
    }
}
