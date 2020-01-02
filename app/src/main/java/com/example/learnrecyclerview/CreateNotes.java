package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNotes extends AppCompatActivity {

    DatabaseHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);

        MyDB = new DatabaseHelper(this);

        Intent intent = getIntent();

        final EditText ed1 = (EditText) findViewById(R.id.ehcn);
        final EditText ed2 = (EditText) findViewById(R.id.edcn);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t01 = ed1.getText().toString();
                String t02 = ed2.getText().toString();

                MyDB.insertdata(t01,t02);

                Intent intent1 = new Intent(CreateNotes.this,MainActivity.class);
                finish();
                CreateNotes.this.startActivity(intent1);
            }
        });

    }
}
