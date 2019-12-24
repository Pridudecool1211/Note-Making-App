package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class EditorWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_window);

        Intent intent = getIntent();
        String t1 = intent.getStringExtra(Adapt.ext1);
        String t2 = intent.getStringExtra(Adapt.ext2);

        EditText ed1 = (EditText) findViewById(R.id.eh);
        EditText ed2 = (EditText) findViewById(R.id.ed);

        ed1.setText(t1);
        ed2.setText(t2);
    }
}
