package com.qf.project.tempproject.utils.fcrUtils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class JsonUtils {
    public static ExecutorService executor
            = Executors.newFixedThreadPool(10);

    public static String getJsonString(String url){

        String jsonStr="";
        OkHttpClient ok=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        try {
            Response response=ok.newCall(request).execute();
            jsonStr=response.body().string();
            Log.d("fcr","===json=="+jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
    public static void getJson(final String url, final Handler handler){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                String jsonString=getJsonString(url);
                Message message=Message.obtain();
                message.obj=jsonString;
                handler.sendMessage(message);
            }
        });
    }
}
