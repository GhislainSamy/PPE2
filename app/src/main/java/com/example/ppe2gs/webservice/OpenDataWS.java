package com.example.ppe2gs.webservice;

import android.util.Log;


import com.example.ppe2gs.modele.Evenement;
import com.example.ppe2gs.modele.ListEvement;
import com.example.ppe2gs.modele.ResultEvent;
import com.example.ppe2gs.modele.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class OpenDataWS {

    private static final String URL_Auth = "http://192.168.43.165/php_android/Authentification.php";
    private static final String URL_Evenement = "http://192.168.43.165/php_android/hpdSelectEvenement.php";
    private static final String URL_INSERT = "http://192.168.43.165/php_android/insertParticiper.php";

    public static List<Evenement> getUserWS() throws Exception {


        String reponse = UtilHttp.getHttp(URL_Evenement );
        Log.i("URL_Evenement", URL_Evenement);
        Log.i("reponseS", reponse);
        Gson gson = new Gson();
        ListEvement resultat = gson.fromJson(reponse, ListEvement.class);
        Log.i("resultatS",  resultat.getResultEvent().get(0).getEvenement().getAdresse());
        List<Evenement> fields = new ArrayList<>();
        if ( resultat == null)  {   throw  new Exception("Variable resultat à null");}


        if( resultat.getResultEvent() != null){

            for(ResultEvent record :  resultat.getResultEvent())

            {
                Log.i("record", record.getEvenement().getAdresse());
                fields.add(record.getEvenement());


            }

        }

        return fields;
    }


    public static User getAuthUserWS(String username, String password) throws Exception {


        String URL = URL_Auth+"?username="+username+"&password="+password;
        Log.i("URL", URL) ;
        Gson gson = new Gson();
        String reponse = UtilHttp.getHttp(URL );
        Log.i("reponse", reponse) ;
        User user = gson.fromJson(reponse, User.class);


        return user;
    }
   // public static String getInsertUserWS(String idE, String idU) {
   //     String URL = URL_INSERT+"?idE="++"&idU="+idU;
   //     Log.i("URL", URL) ;
//
//        String reponse = UtilHttp.getHttp(URL );
//        Log.i("reponse", reponse) ;
//        return reponse ;
//    }


}
