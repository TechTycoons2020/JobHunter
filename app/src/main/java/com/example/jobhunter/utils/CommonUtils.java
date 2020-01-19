package com.example.jobhunter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class CommonUtils {

    public static String Ijobname = "jobname";
    public static String Icompany = "company";
    public static String Ilocation = "location";
    public static String Isalary = "salary";
    public static String Iexper = "experience";
    public static String Iapplyby = "applyby";
    public static String Ijobdesc = "jobdesc";
    public static String Icomdesc = "comdesc";
    public static String Icontact = "contact";
    public static String Ifield = "field";
    public static String Ilatitude = "latitude";
    public static String Ilongitude = "longitude";
    public static String Itype = "type";


    //Hides Keyboard
    public static void hideKeyboard(Activity activity){
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //Checks for Internet Connectivity
    public static boolean alerter(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            Boolean flag = !(activeNetworkInfo != null && activeNetworkInfo.isConnected());
            if(flag)
                Toast.makeText(context, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
            return flag;
        }
        return false;
    }
    //Verify Necessary Permissions
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


}