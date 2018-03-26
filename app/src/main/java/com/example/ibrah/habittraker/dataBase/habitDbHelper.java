package com.example.ibrah.habittraker.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ibrah on 21/07/2017.
 */

public class habitDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = habitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habit.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link habitDbHelper}.
     *
     * @param context of the app
     */
    public habitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_RUTINE_TABLE = "CREATE TABLE " + ContractHabit.entryHabit.TABLE_NAME + " ("
                + ContractHabit.entryHabit._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ContractHabit.entryHabit.NAME + " TEXT NOT NULL, "
                + ContractHabit.entryHabit.COLUMN_RUNNING + " INTEGER, "
                + ContractHabit.entryHabit.DISTANCE + " INTEGER NOT NULL DEFAULT 0, "
                + ContractHabit.entryHabit.COLUMN_GYM + " INTEGER NOT NULL, "
                + ContractHabit.entryHabit.TIME_GYM + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_RUTINE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
