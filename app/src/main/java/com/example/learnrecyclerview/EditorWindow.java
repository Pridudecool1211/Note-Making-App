package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorWindow extends AppCompatActivity {
    DatabaseHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyDB = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_window);

        Intent intent = getIntent();
        String t1 = intent.getStringExtra(Adapt.ext1);
        String t2 = intent.getStringExtra(Adapt.ext2);
        final int updateID = intent.getIntExtra(Adapt.ext3,0);

        final EditText ed1 = (EditText) findViewById(R.id.eh);
        final EditText ed2 = (EditText) findViewById(R.id.ed);

        ed1.setText(t1);
        ed2.setText(t2);

        Button button = (Button) findViewById(R.id.update);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String t01 = ed1.getText().toString();
                String t02 = ed2.getText().toString();

                MyDB.updatenote(updateID,t01,t02);
                Intent intent1 = new Intent(EditorWindow.this,MainActivity.class);
                finish();
                EditorWindow.this.startActivity(intent1);
            }
        });

        Button button1 = (Button) findViewById(R.id.delete);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDB.deletenote(updateID);
                Intent intent1 = new Intent(EditorWindow.this,MainActivity.class);
                finish();
                EditorWindow.this.startActivity(intent1);
            }
        });

    }
}
