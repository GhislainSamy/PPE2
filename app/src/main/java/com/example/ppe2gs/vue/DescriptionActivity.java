package com.example.ppe2gs.vue;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ppe2gs.R;
import com.example.ppe2gs.modele.Evenement;
import com.example.ppe2gs.modele.User;
import com.example.ppe2gs.webservice.OpenDataWS;

public class DescriptionActivity extends AppCompatActivity {

    TextView titre ;
    TextView adresse ;
    TextView datedebut ;
    TextView datefin ;
    TextView description ;
    Evenement evenement ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);



        titre = (TextView)findViewById(R.id.titre) ;
        adresse = (TextView)findViewById(R.id.adresse) ;
        datedebut = (TextView)findViewById(R.id.datedebut) ;
        datefin = (TextView)findViewById(R.id.datefin) ;
        description = (TextView)findViewById(R.id.description) ;


        evenement = (Evenement) getIntent().getSerializableExtra("key");
        Log.i("evnt",evenement.getAdresse());

        titre.setText(evenement.getTitre());

        description.setText(evenement.getDescription());
        //datedebut.setText(evenement.getDateDebut());
      //  datefin.setText(evenement.getDateFin());



    }




    public void participer(View view) {
        new MainActivity.MonAstask().execute(name,pasw);

    }


    public class MonAstask extends AsyncTask<String,String, String> {
        String resultat;
        String text;

        @Override
        protected String  doInBackground(String... params) {
            try {
                Log.i("re", params[0]);
                resultat = OpenDataWS.getInsertUserWS(params[0], params[1]);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultat;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);


        }

        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            String info = o;


            if(!info.equals("true")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.

                */
                Log.i("user", info);

            }

        }

    }
}
