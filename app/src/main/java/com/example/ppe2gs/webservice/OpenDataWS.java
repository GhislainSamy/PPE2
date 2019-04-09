package com.example.ppe2gs.webservice;

import android.util.Log;


import com.example.ppe2gs.modele.User;
import com.google.gson.Gson;


public class OpenDataWS {

    private static final String URL_Auth = "http://172.20.10.4/php_android/Authentification.php";



    public static User getAuthUserWS(String username, String password) throws Exception {


        String URL = URL_Auth+"?username="+username+"&password="+password;
        Log.i("URL", URL) ;
        Gson gson = new Gson();
        String reponse = UtilHttp.getHttp(URL );
        Log.i("reponse", reponse) ;
        User user = gson.fromJson(reponse, User.class);


        return user;
    }
}