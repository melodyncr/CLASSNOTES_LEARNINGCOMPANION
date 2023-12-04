// NoteActivity.java
package com.example.classnotes_learningcompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classnotes_learningcompanion.databinding.ActivityNoteBinding;

import java.util.zip.Inflater;

public class NoteActivity extends AppCompatActivity {

    private static final String BUTTON_STATE = "ButtonState";

    ActivityNoteBinding binding;

    Button noteButton;
    boolean isNoteTaken = false;

    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, NoteActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noteButton = binding.noteButton;

        if (savedInstanceState != null) {
            isNoteTaken = savedInstanceState.getBoolean(BUTTON_STATE, false);
        }

        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNoteTaken = !isNoteTaken;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUTTON_STATE, isNoteTaken);
    }
}
