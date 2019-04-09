package com.example.ppe2gs.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ppe2gs.R;
import com.example.ppe2gs.modele.Evenement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class EvenementAdapter extends ArrayAdapter<Evenement> {




    public EvenementAdapter(Context context, List<Evenement> fiels) {
        super(context, 0, fiels);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        View result = convertView;
        if (convertView == null)
        {
            result =
                    LayoutInflater.from(getContext()).inflate(R.layout.modele, parent, false);
        }
        Evenement event = getItem(position);
        TextView titre = (TextView)result.findViewById(R.id.titre);
        titre.setText(event.getTitre());
      //  TextView date = (TextView)result.findViewById(R.id.date);

        //date.setText(event.getDate_debut().toString());
       // ImageView imageview = (ImageView)result.findViewById(R.id.eventImg);
//imageview.setImageResource( event.getImg());
        return result;
    }
    public void updateData(){
        this.notifyDataSetChanged();
    }
}