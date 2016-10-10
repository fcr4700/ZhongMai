package com.qf.project.tempproject.sqliteBean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class RecordOpenHelper extends SQLiteOpenHelper{

    public RecordOpenHelper(Context context) {
        super(context, "record.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table record(_id integer primary key autoincrement,title varchar(100),pic_url varchar(100)," +
                "video_url varchar(100),contentxx varchar(500),columnxx varchar(100))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
