package com.qf.project.tempproject.utils.fcrUtils;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class HandlerJson {
    public static  ExecutorService excutor= Executors.newFixedThreadPool(20);
    public static void getJsonString(final String url, final Handler handler){
        excutor.execute(new Runnable() {
            @Override
            public void run() {
                String jsonString=JsonUtils.getJsonString(url);
                Message msg=Message.obtain();
                msg.obj=jsonString;
                handler.sendMessage(msg);
            }
        });
    }
}
