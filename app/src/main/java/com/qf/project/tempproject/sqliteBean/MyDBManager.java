package com.qf.project.tempproject.sqliteBean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.qf.project.tempproject.bean.fcrBean.VideoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyDBManager {
    Context context;
    MySqliteOpenHelper openHelper;
    SQLiteDatabase database;

    public MyDBManager(Context context) {
        this.context = context;
        openHelper=new MySqliteOpenHelper(context);
        database=openHelper.getWritableDatabase();
    }
    //增加
    public void addSqliteData(VideoEntity entity){
        try {
            ContentValues values=new ContentValues();
            values.put("title",entity.getTitle());
            values.put("pic_url",entity.getPicture());
            values.put("video_url",entity.getVideo240());
            values.put("contentmm",entity.getContent());
            values.put("columnxx",entity.getColumn());
            database.insert("video",null,values);

            Log.d("sqlite","==title=="+entity.getTitle());
            Log.d("sqlite","==pic=="+entity.getPicture());
            Log.d("sqlite","==video=="+entity.getVideo240());
            Log.d("sqlite","==content=="+entity.getContent());
        }catch (Exception e){

        }

    }
    public void deleteSql(VideoEntity entity){
        String sql="";
        database.execSQL(sql);
    }
    //查询
    public List<VideoEntity> qurey(){
        List<VideoEntity> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from video",null);
        while (cursor.moveToNext()){
            VideoEntity entity=new VideoEntity();
            entity.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            entity.setPicture(cursor.getString(cursor.getColumnIndex("pic_url")));
            entity.setVideo240(cursor.getString(cursor.getColumnIndex("video_url")));
            entity.setContent(cursor.getString(cursor.getColumnIndex("contentmm")));
            entity.setColumn(cursor.getString(cursor.getColumnIndex("columnxx")));
            Log.d("sqlitequrey","title="+cursor.getString(cursor.getColumnIndex("title")));
            list.add(entity);
        }
        return list;
    }
    public String qureyUrl(){
        String urlString="";
        Cursor cursor=database.rawQuery("select * from video",null);
        while (cursor.moveToNext()){
            urlString=cursor.getString(cursor.getColumnIndex("url"));
        }
        Log.d("sqlite","urlString="+cursor.getString(cursor.getColumnIndex("url")));
        return urlString;
    }

}
