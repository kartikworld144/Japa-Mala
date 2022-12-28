package com.kartik.japamala;


import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {

    private static final String MY_PREFERENCE_NAME = "com.kartik.japamala";
    private static final String MY_PREFERENCE_KEY = "my_preference_total_key";

    public static void TotalSaveSharePreference(Context context,int total){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MY_PREFERENCE_KEY,total);
        editor.apply();
    }
    public static int TotalLoadSharePreference(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(MY_PREFERENCE_KEY, 0);
    }
    public static void TotalRemoveSharePreference(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MY_PREFERENCE_KEY);
        //*editor.clear();
        //editor.remove("unique key");
        editor.apply();
    }
}
