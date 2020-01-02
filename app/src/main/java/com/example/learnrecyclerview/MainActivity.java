 package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    DatabaseHelper MyDB;

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListOfNotes> listItems;
    public static final String TAG = "MainActivity";
    public static final int numcol = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyDB = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
               newnote();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();


        Cursor cursor = MyDB.getnotes();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                ListOfNotes listItem1 = new ListOfNotes(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2)
                );

                listItems.add(listItem1);
            }
        }

        adapter = new Adapt(listItems,this);
        recyclerView.setAdapter(adapter);

        initrv();
    }

    public void initrv(){
        Log.d(TAG,"Initialising Staggered Recycler View");

        RecyclerView recyclerView = findViewById(R.id.rec);
        Adapt adapt = new Adapt(listItems,this);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(numcol, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapt);
    }

    public void newnote(){

        Intent intent = new Intent(this,CreateNotes.class);
        this.startActivity(intent);
    }
}
