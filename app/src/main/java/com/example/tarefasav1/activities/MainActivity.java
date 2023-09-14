package com.example.tarefasav1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarefasav1.R;
import com.example.tarefasav1.adapter.RCAdapter;
import com.example.tarefasav1.dao.Database;
import com.example.tarefasav1.model.Tarefa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tarefaRV;
    private EditText tarefaEditText;
    private Button tarefaAddBtn;
    private RCAdapter adapter;
    private ArrayList<Tarefa> tarefaList;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefaRV = findViewById(R.id.tarefasRecyclerView);
        tarefaEditText = findViewById(R.id.tarefaEditText);
        tarefaAddBtn = findViewById(R.id.tarefaAddBtn);

        db = new Database(this);

        tarefaList = new ArrayList<Tarefa>();
        Cursor cursor = db.getTarefas();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Tarefa t = new Tarefa(cursor.getLong(0), cursor.getString(1));
            tarefaList.add(t);
        }

        //carrega o adapter com dados
        adapter = new RCAdapter(tarefaList, this);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        tarefaRV.setLayoutManager(layoutManager);

        tarefaRV.setAdapter(adapter);

        tarefaAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(tarefaEditText.getText().toString());
            }
        });

    }

    //adciona novo item na lista e notifica adapter
    private void addItem(String item) {
        if (!item.isEmpty()) {
            long id = db.addTarefa(item);
            if(id != -1) {
                tarefaList.add(new Tarefa(id, item));
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void onItemLongPress(int position) {
        long id = db.delTarefa(tarefaList.get(position));
        if(id != -1) {
            tarefaList.remove(position);
            adapter.notifyDataSetChanged();
        }
    }
}