package com.example.myapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    /**
     * 作为SQLiteOpenHelper子类必须有的构造方法
     * @param context 上下文参数
     * @param name 数据库名字
     * @param factory 游标工厂 ，通常是null
     * @param version 数据库的版本
     */
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 数据库第一次被创建时调用该方法
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 初始化数据库的表结构，执行一条建表的SQL语句
        db.execSQL("create table user(u_id varchar(50) not null primary key,psd varchar(50) not null,gender int not null,avatar int)");
        db.execSQL("create table relation(r_id int not null primary key,u_id_1 varchar(50) not null,u_id_2 varchar(50) not null)");
    }

    /**
     * 当数据库的版本号增加调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

