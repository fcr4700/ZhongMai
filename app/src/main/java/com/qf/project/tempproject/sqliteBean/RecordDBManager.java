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
 * Created by Administrator on 2016/10/10 0010.
 */
public class RecordDBManager {
    Context context;
    RecordOpenHelper mOpenHelper;
    SQLiteDatabase mDatabase;

    public RecordDBManager(Context context) {
        this.context = context;
        mOpenHelper=new RecordOpenHelper(context);
        mDatabase=mOpenHelper.getWritableDatabase();
    }
    public void addRecordData(VideoEntity entity){
        try {
            ContentValues values=new ContentValues();
            values.put("title",entity.getTitle());
            values.put("pic_url",entity.getPicture());
            values.put("video_url",entity.getVideo240());
            values.put("contentxx",entity.getContent());
            values.put("columnxx",entity.getColumn());
            mDatabase.insert("record",null,values);

            Log.d("record","title=="+entity.getTitle()+entity.getPicture());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<VideoEntity> queryRecord(){
        List<VideoEntity> list=new ArrayList<>();
        Cursor cursor=mDatabase.rawQuery("select * from record",null);
        while (cursor.moveToNext()){
            VideoEntity entity=new VideoEntity();
            entity.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            entity.setPicture(cursor.getString(cursor.getColumnIndex("pic_url")));
            entity.setContent(cursor.getString(cursor.getColumnIndex("contentxx")));
            entity.setColumn(cursor.getString(cursor.getColumnIndex("columnxx")));
            entity.setVideo240(cursor.getString(cursor.getColumnIndex("video_url")));
            Log.d("record","=="+cursor.getString(cursor.getColumnIndex("title")));
            list.add(entity);
        }
        return list;
    }
}
