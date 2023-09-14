package com.example.tarefasav1.adapter;

import android.content.Context;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarefasav1.R;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {
    private ArrayList<String> tarefaArrayList;

    public RCAdapter(ArrayList<String> tarefaArrayList, Context context) {
        this.tarefaArrayList = tarefaArrayList;
    }
    @NonNull
    @Override
    public RCAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView listTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTV = itemView.findViewById(R.id.cardItemTextView);
        }
    }
}
