package com.example.ppe2gs.vue;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.ppe2gs.R;
import com.example.ppe2gs.modele.Evenement;
import com.example.ppe2gs.modele.EvenementAdapter;
import com.example.ppe2gs.modele.InitList;

import java.util.ArrayList;


public class EvenementActivity extends AppCompatActivity {

    private ArrayList<Evenement> evenements;

    private EvenementAdapter adapterEvenement;
    ListView listeEvnt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
evenements = InitList.getListEvenement();
        listeEvnt =  (ListView)findViewById(R.id.listeEvent) ;
adapterEvenement= new EvenementAdapter(this,evenements);
adapterEvenement.addAll(evenements);
listeEvnt.setAdapter(adapterEvenement);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
