package com.thirdapp;

import java.io.File;

public interface OnEvent {
    void onPreExecute();
    void onProgressUpdate(int count);
    void onPostExecute(File apk);
}
