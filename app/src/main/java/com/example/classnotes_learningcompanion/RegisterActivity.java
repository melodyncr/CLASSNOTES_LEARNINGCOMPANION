
package com.example.classnotes_learningcompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    private static final String BUTTON_STATE = "ButtonState";

    ActivityRegisterBinding binding;

    Button registerButton;
    boolean isRegistered = false;

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerButton = binding.registerButton;

        if (savedInstanceState != null) {
            isRegistered = savedInstanceState.getBoolean(BUTTON_STATE, false);
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRegistered = !isRegistered;
                navigateToNextPage();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUTTON_STATE, isRegistered);
    }

    private void navigateToNextPage() {
        if (isRegistered) {
            Intent intent = NoteActivity.intentFactory(getApplicationContext());
            startActivity(intent);
        }
    }
}
