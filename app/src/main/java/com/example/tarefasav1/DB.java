package com.example.tarefasav1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB {
    private helperDB helper;

    public DB(Context context) {
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


    public long delTarefa(String descricao) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("descricao", descricao);

        return db.insert("tarefas", null, values);
    }
}