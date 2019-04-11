package com.example.ppe2gs.vue;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ppe2gs.R;
import com.example.ppe2gs.modele.User;
import com.example.ppe2gs.webservice.OpenDataWS;

public class MainActivity extends AppCompatActivity {


    EditText inputLogin ;
    EditText inputMdp ;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        inputLogin = (EditText)findViewById(R.id.inputlogin) ;
        inputMdp = (EditText)findViewById(R.id.inputMdp) ;
        button = findViewById(R.id.connexion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void connexion(View view){
        String name = inputLogin.getText().toString();
        String pasw = inputMdp.getText().toString();
        // Initialize  AsyncLogin() class with email and password
        new MonAstask().execute(name,pasw);
        // Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        //  startActivity(intent);


    }

    public class MonAstask extends AsyncTask<String,String, User> {
        User resultat;
        String text;

        @Override
        protected User doInBackground(String... params) {
            try {
                Log.i("re", params[0]);
                resultat = OpenDataWS.getAuthUserWS(params[0], params[1]);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultat;
        }


        @Override
        protected void onPostExecute(User o) {
            super.onPostExecute(o);
            User info = o;

            Log.i("user1", "ok");
            if(info != null) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.

                */
                Log.i("user", info.getUsername());
                Intent intent = new Intent(MainActivity.this, EvenementActivity.class);
                intent.putExtra("key1",info);
                startActivity(intent);
             //   MainActivity.this.finish();
            }else {
                Log.i("else", "ok1");
                alertDialog();

            }

        }

    }
    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Please Select any option");
        dialog.setTitle("Dialog Box");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
