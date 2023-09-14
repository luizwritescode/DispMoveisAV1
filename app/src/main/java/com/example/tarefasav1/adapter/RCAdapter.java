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
import com.example.tarefasav1.activities.MainActivity;
import com.example.tarefasav1.dao.Database;
import com.example.tarefasav1.model.Tarefa;

import java.util.ArrayList;

//codigo adaptado do geeks for geeks
//https://www.geeksforgeeks.org/how-to-update-recyclerview-adapter-data-in-android/
public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {
    public interface OnItemLongClickListener {
        public boolean onItemLongClicked(int position);
    }

    private MainActivity mActivity;
     private ArrayList<Tarefa> tarefaArrayList;

    public RCAdapter(ArrayList<Tarefa> tarefaArrayList, MainActivity mActivity) {
        this.tarefaArrayList = tarefaArrayList;
        this.mActivity = mActivity;
    }
    @NonNull
    @Override
    public RCAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCAdapter.ViewHolder holder, int position) {
        Tarefa item = tarefaArrayList.get(position);
        holder.listTV.setText(item.getDesc());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mActivity.onItemLongPress(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return tarefaArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView listTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTV = itemView.findViewById(R.id.cardItemTextView);
        }

    }
}
