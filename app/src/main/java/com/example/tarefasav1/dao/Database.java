package com.example.tarefasav1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarefasav1.helper.helperDB;
import com.example.tarefasav1.model.Tarefa;

public class Database {
    private helperDB helper;

    public Database(Context context) {
        helper = new helperDB(context);
    }

    public long addTarefa(String descricao) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("descricao", descricao);

        return db.insert("tarefas", null, values);
    }

    public Cursor getTarefas() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {"id", "descricao"};
        return db.query("tarefas", projection, null, null, null, null, null);
    }


    public long delTarefa(Tarefa tarefa) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        return db.delete("tarefas","id = " + tarefa.getId() , null);

    }

    public long deleteAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        return db.delete("tarefas",null, null);

    }
}