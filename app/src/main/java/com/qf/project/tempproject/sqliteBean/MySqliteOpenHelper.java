package com.qf.project.tempproject.sqliteBean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MySqliteOpenHelper extends SQLiteOpenHelper{

    public MySqliteOpenHelper(Context context) {
        super(context, "video.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql2="create table video(_id integer primary key autoincrement,title varchar(200)," +
                "pic_url varchar(300),video_url varchar(300),contentmm varchar(1000),columnxx varchar(100))";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
