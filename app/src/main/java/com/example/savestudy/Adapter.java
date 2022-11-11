package com.example.savestudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList subject_id, toDoTask_id, stuTime_id;

    public Adapter(Context context, ArrayList subject_id, ArrayList toDoTask_id, ArrayList stuTime_id) {
        this.context = context;
        this.subject_id = subject_id;
        this.toDoTask_id = toDoTask_id;
        this.stuTime_id = stuTime_id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userdata,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subject_id.setText(String.valueOf(subject_id.get(position)));
        holder.toDoTask_id.setText(String.valueOf(toDoTask_id.get(position)));
        holder.stuTime_id.setText(String.valueOf(stuTime_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return subject_id.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject_id,toDoTask_id, stuTime_id;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            subject_id = itemView.findViewById(R.id.subject_text);
            toDoTask_id = itemView.findViewById(R.id.toDoTask_text);
            stuTime_id = itemView.findViewById(R.id.stuTime_text);
        }
    }
}
