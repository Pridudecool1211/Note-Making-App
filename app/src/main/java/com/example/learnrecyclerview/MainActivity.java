 package com.example.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListOfNotes> listItems;
    public static final String TAG = "MainActivity";
    public static final int numcol = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               newnote();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i=0; i<10; ++i){
            ListOfNotes listItem = new ListOfNotes(
                    "Heading" + (i+1),
                    "This is Note no. " + (i+1)
            );

            listItems.add(listItem);
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
