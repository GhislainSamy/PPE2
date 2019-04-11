package com.example.ppe2gs.vue;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ppe2gs.R;
import com.example.ppe2gs.modele.Evenement;
import com.example.ppe2gs.modele.User;
import com.example.ppe2gs.webservice.OpenDataWS;

import java.util.ArrayList;
import java.util.List;

public class ParticiperActivity extends AppCompatActivity {

    private List<Evenement> evenements;
    User user ;
    private EvenementAdapter adapterEvenement;
    ListView listeEvnt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        evenements = new ArrayList<>();
        listeEvnt =  (ListView)findViewById(R.id.listeParticiper) ;
        adapterEvenement= new EvenementAdapter(this,evenements);
        adapterEvenement.addAll(evenements);
        listeEvnt.setAdapter(adapterEvenement);
        listeEvnt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                final Evenement item = (Evenement) parent.getItemAtPosition(position);
              /*  Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + item.getAdresse(), Toast.LENGTH_LONG)
                        .show();*/
                Log.i("item",item.toString());
                /*Intent intent = new Intent(EvenementActivity.this,DescriptionActivity.class);
                user = (User) getIntent().getSerializableExtra("key1");
                intent.putExtra("key2",user);
                intent.putExtra("key",item);
                startActivity(intent);*/
            }
        });

        ParticiperActivity.MonAstask t = new ParticiperActivity.MonAstask();
        t.execute();

    }



    public class MonAstask extends AsyncTask {
        List<Evenement> resultat = null ;
        String text;
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                resultat = OpenDataWS.getUserWS();
                // text = OpenDataWS.getInsertUserWS();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            evenements.clear();
            evenements.addAll(resultat);
            adapterEvenement.updateData();



        }
    }
}


