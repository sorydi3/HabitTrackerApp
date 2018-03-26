package com.example.ibrah.habittraker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ibrah.habittraker.dataBase.ContractHabit;
import com.example.ibrah.habittraker.dataBase.habitDbHelper;

public class MainActivity extends AppCompatActivity {
    public static Context context;
    habitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new habitDbHelper(MainActivity.this);
        for (int i = 0; i < 5; i++) {
            insertData();
        }
       displayContentDb(QuerryAllHabits());
    }

    public Cursor QuerryAllHabits() {
        SQLiteDatabase DB = mDbHelper.getReadableDatabase();
        String[] projection = {ContractHabit.entryHabit._ID,
                ContractHabit.entryHabit.NAME,
                ContractHabit.entryHabit.COLUMN_RUNNING,
                ContractHabit.entryHabit.DISTANCE,
                ContractHabit.entryHabit.COLUMN_GYM,
                ContractHabit.entryHabit.TIME_GYM};

        Cursor cursor = DB.query(ContractHabit.entryHabit.TABLE_NAME, projection, null, null, null, null, null);
        //in the bellow code we building the index of each colum

        return cursor;
    }
      public void displayContentDb(Cursor cursor){

          int indext_ID = cursor.getColumnIndex(ContractHabit.entryHabit._ID);
          int indext_NAME = cursor.getColumnIndex(ContractHabit.entryHabit.NAME);
          int indext_RUNNING = cursor.getColumnIndex(ContractHabit.entryHabit.COLUMN_RUNNING);
          int indext_DISTANCE = cursor.getColumnIndex(ContractHabit.entryHabit.DISTANCE);
          int indext_GYM = cursor.getColumnIndex(ContractHabit.entryHabit.COLUMN_GYM);
          int indext_TIME = cursor.getColumnIndex(ContractHabit.entryHabit.TIME_GYM);

          TextView textView = (TextView) findViewById(R.id.textView);
          try {
              while (cursor.moveToNext()) {
                  int id = cursor.getInt(indext_ID);
                  String name = cursor.getString(indext_NAME);
                  int running = cursor.getInt(indext_RUNNING);
                  int distance = cursor.getInt(indext_DISTANCE);
                  int gym = cursor.getInt(indext_GYM);
                  int time = cursor.getInt(indext_TIME);
                  textView.append(("\n" + id + " - " +
                          name + " - " +
                          running + " - " +
                          distance + " - " +
                          gym + " - " + time));

              }

          } finally {
              cursor.close();
          }
      }
    private void insertData() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(ContractHabit.entryHabit.NAME, "DIALLO IBRAHIMA SORY");
        values.put(ContractHabit.entryHabit.COLUMN_RUNNING, 1);
        values.put(ContractHabit.entryHabit.DISTANCE, 50);
        values.put(ContractHabit.entryHabit.COLUMN_GYM, 1);
        values.put(ContractHabit.entryHabit.TIME_GYM, 1);

        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        db.insert(ContractHabit.entryHabit.TABLE_NAME, null, values);
    }

}
