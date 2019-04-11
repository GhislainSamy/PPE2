package com.example.ppe2gs.vue;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
     User user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);



        titre = (TextView)findViewById(R.id.titre) ;
        adresse = (TextView)findViewById(R.id.adresse) ;
        datedebut = (TextView)findViewById(R.id.datedebut) ;
        datefin = (TextView)findViewById(R.id.datefin) ;
        description = (TextView)findViewById(R.id.description) ;

       user = (User) getIntent().getSerializableExtra("key2");
        evenement = (Evenement) getIntent().getSerializableExtra("key");
        Log.i("evnt",evenement.getAdresse());
        adresse.setText(evenement.getAdresse());

        titre.setText(evenement.getTitre());

        description.setText(evenement.getDescription());

        //datedebut.setText(evenement.getDateDebut());
        //  datefin.setText(evenement.getDateFin());

      Log.i("evnt1",evenement.getId());
        Log.i("user1",user.getId());


    }




    public void participer(View view) {
    //    new MainActivity.MonAstask().execute(name,pasw);
        new  MonAstask().execute(evenement.getId(),user.getId());
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


            if(info.contains("true")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                */
                alertDialog();

            }

        }

    }



    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Votre evenement a etait ajouter a votre liste participation");
        dialog.setTitle("Participation a l'evenement");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
         //               Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
        //        Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}