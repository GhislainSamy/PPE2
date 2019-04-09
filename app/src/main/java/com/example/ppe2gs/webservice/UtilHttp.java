package com.example.ppe2gs.webservice;

import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class UtilHttp {

    public static String getHttp(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(url)
                .build();


        Response response = client.newCall(request).execute();
        if (response.code() != HttpURLConnection.HTTP_OK)
        {

            throw new Exception(" Reponce du serveur incorrecte"+response.code() );

        }else
            return response.body().string();

    }

    public static String getHttpUtilisateur(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(url)
                .build();


        Response response = client.newCall(request).execute();
        if (response.code() != HttpURLConnection.HTTP_OK)
        {

            throw new Exception(" Reponce du serveur incorrecte"+response.code() );

        }else
            return response.body().string();

    }

}
