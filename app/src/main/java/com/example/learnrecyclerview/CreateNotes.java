package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class CreateNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);

        Intent intent = getIntent();

        EditText ed1 = (EditText) findViewById(R.id.ehcn);
        EditText ed2 = (EditText) findViewById(R.id.edcn);

        String t01 = ed1.getText().toString();
        String t02 = ed2.getText().toString();
    }
}
