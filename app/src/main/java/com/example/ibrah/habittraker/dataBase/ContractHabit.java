package com.example.ibrah.habittraker.dataBase;

import android.provider.BaseColumns;

/**
 * Created by ibrah on 21/07/2017.
 */

public final class ContractHabit {
    private ContractHabit() {
    }

    public static final class entryHabit implements BaseColumns {

        //-----------------TABLE NAME-----------------
        /**
         * Name of database table for habits
         */
        public final static String TABLE_NAME = "rutine";
        //----------ID-----------------------

        /**
         * Unique ID number for the pet (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;
        //---------NAME-----------------------
        /**
         * Name of the user.
         * <p>
         * Type: TEXT
         */
        public final static String NAME = "name";
        //---------------GYM------------------------
        /**
         * Gym.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_GYM = "Gym";
        /**
         * Time spended in Gym
         * <p>
         * Type: INTEGER
         */
        public final static String TIME_GYM = "time";
        /**
         * Possible answers of the user.
         */
        public final static int GYM_YES = 1;
        public final static int GYM_NO = 0;


//       ---------------- RUNNING------------------------
        /**
         * Running info.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_RUNNING = "running";
        /**
         * Running info.
         * <p>
         * Type: INTEGER
         */
        public final static String DISTANCE = "distance";

        /**
         * Possible answers of the user.
         */
        public final static int RUNNING_YES = 1;
        public final static int RUNNING_NO = 0;


    }

}
