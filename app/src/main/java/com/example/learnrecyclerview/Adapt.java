package com.example.learnrecyclerview;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

public class Adapt extends RecyclerView.Adapter<Adapt.ViewHolder> {

    public static final String ext1 = "com.example.learnrecyclerview.extratext1";
    public static final String ext2 = "com.example.learnrecyclerview.extratext2";

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
        ListOfNotes listItem = listItems.get(position);

        holder.head.setText(listItem.getH());
        holder.desc.setText(listItem.getD());
        final String t1 = holder.head.getText().toString();
        final String t2 = holder.desc.getText().toString();

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openeditor(t1,t2);
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
        public LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            head = (TextView) itemView.findViewById(R.id.h);
            desc = (TextView) itemView.findViewById(R.id.d);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }

    public void openeditor(String t1, String t2){

        Intent intent = new Intent(context,EditorWindow.class);
        intent.putExtra(ext1,t1);
        intent.putExtra(ext2,t2);
        context.startActivity(intent);
    }
}
