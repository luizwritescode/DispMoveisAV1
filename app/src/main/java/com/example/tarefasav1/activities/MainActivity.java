package com.example.tarefasav1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarefasav1.R;
import com.example.tarefasav1.adapter.RCAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tarefaRV;
    private EditText tarefaEditText;
    private Button tarefaAddBtn;
    private RCAdapter adapter;
    private ArrayList<String> tarefaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefaRV = findViewById(R.id.tarefasRecyclerView);
        tarefaEditText = findViewById(R.id.tarefaEditText);
        tarefaAddBtn = findViewById(R.id.tarefaAddBtn);
        tarefaList = new ArrayList<>();


        //carrega o adapter com dados
        adapter = new RCAdapter(tarefaList);

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
            tarefaList.add(item);
            adapter.notifyDataSetChanged();
        }
    }
}