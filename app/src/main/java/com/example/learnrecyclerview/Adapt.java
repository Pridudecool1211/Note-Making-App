package com.example.learnrecyclerview;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

public class Adapt extends RecyclerView.Adapter<Adapt.ViewHolder> {

    private static final String TAG = "Adapt";

    public static final String ext1 = "com.example.learnrecyclerview.extratext1";
    public static final String ext2 = "com.example.learnrecyclerview.extratext2";
    public static final String ext3 = "com.example.learnrecyclerview.extratext3";


    private List<ListOfNotes> listItems;
    private Context context;


    public Adapt(List<ListOfNotes> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.notes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "OnBindViewHolder called");
        final ListOfNotes listItem = listItems.get(position);

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        holder.head.setText(listItem.getH());
        holder.desc.setText(listItem.getD());
        final String t1 = holder.head.getText().toString();
        final String t2 = holder.desc.getText().toString();

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick clicked on");
                ((Activity)context).finish();
                openeditor(listItem.getId(),t1,t2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView head;
        public TextView desc;
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            head = (TextView) itemView.findViewById(R.id.h);
            desc = (TextView) itemView.findViewById(R.id.d);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }

    public void openeditor(int updateID, String t1, String t2){

        Intent intent = new Intent(context,EditorWindow.class);
        intent.putExtra(ext1,t1);
        intent.putExtra(ext2,t2);
        intent.putExtra(ext3,updateID);
        context.startActivity(intent);
    }
}
