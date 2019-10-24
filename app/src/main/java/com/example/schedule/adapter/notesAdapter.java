package com.example.schedule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schedule.R;

import java.util.ArrayList;
import com.example.schedule.teammodel.*;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.ViewHolder> {

    Context context;
    ArrayList<modelNotes> notes;

    public notesAdapter(Context context, ArrayList<modelNotes> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(context).inflate(R.layout.savelayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        modelNotes note = notes.get(position);

        holder.title.setText(note.getTitle());
        holder.description.setText(note.getDesc());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title =itemView.findViewById(R.id.editTitle);
            description =itemView.findViewById(R.id.editDescription);

        }

        @Override
        public void onClick(View v) {

        }
    }



}
