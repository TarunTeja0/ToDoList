package com.example.todolist;
//To store the files directory in the Application context, you can create a custom Application class and store the files directory as a variable within that class.

import android.app.Application;
import android.content.Context;

//Create a custom Application class by extending the Application class:
public class MyApp extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
