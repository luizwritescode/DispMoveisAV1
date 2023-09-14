package com.example.tarefasav1.helper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class helperDB extends SQLiteOpenHelper {


        private static final String db = "todo.db";
        private static final int ver = 1;

        public helperDB(Context context) {
            super(context, db, null, ver);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Handle database upgrades here if needed.
        }


}
