package com.thirdapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class CalendarModule  extends ReactContextBaseJavaModule {

    CalendarModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public void createCalendarEvent(String name, String location) {
        Log.d("CalendarModule", "Create event called with name: " + name
                + " and location: " + location);
        Toast.makeText(getReactApplicationContext(), name, Toast.LENGTH_SHORT).show();


        new AppUpdateManager(getReactApplicationContext(), new OnEvent() {
            @Override
            public void onPreExecute() {
                Toast.makeText(getReactApplicationContext(), "onPreExecute", Toast.LENGTH_SHORT).show();
                //progressBar.setMax(100) ;
                //progressBar.setProgress(0) ;
            }

            @Override
            public void onProgressUpdate(int count) {
               // progressBar.setProgress(count) ;
            }

            @Override
            public void onPostExecute(File apk) {
                Toast.makeText(getReactApplicationContext(), "onPostExecute", Toast.LENGTH_SHORT).show();

                try{
                    showApkInstaller(getReactApplicationContext(), apk);
                }catch(Exception e){
                    Log.d("APP_UPDATE", "APP_UPDATE>>" + e.toString());
                }

                Log.d("APP_UPDATE", "end?");


            }
        }).execute("");








    }

    public void showApkInstaller(Context context, File f) throws FileNotFoundException {

        Log.d("APP_UPDATE", "apk2 : " + f);

//        File f = new File(apkPath);
        if(!f.exists()){
            throw new FileNotFoundException("Can not find apk file.");
        }


        Intent i = new Intent(Intent.ACTION_VIEW);

        String packageName = context.getPackageName();
        Uri contentUri = FileProvider.getUriForFile(context, packageName + ".provider", f);

        Log.d("APP_UPDATE", "apk3 : " + contentUri);


        i.setDataAndType(contentUri,
                "application/vnd.android.package-archive");
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // 추가

        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 추가
        context.startActivity(i);



    }
}
