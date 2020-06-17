package com.example.healthnote.bean;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDataBase.NAME,version = AppDataBase.VERSION)
public class AppDataBase {
    public static final String NAME = "daixie";

    public static final int VERSION = 2;
}
