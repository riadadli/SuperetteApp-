package com.example.labo3superette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class inventaireAdapter extends ArrayAdapter<Produit>
{
    private Context ctx;
    private int resource;
    private ArrayList<Produit> lp;

    public inventaireAdapter(Context ctx, int resource, ArrayList<Produit> objects) {
        super(ctx, resource, objects);
        this.ctx = ctx;
        this.resource = resource;
        this.lp = new ArrayList<Produit>();
        this.lp = (ArrayList<Produit>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Produit produit = lp.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.ctx);
        convertView = layoutInflater.inflate(this.resource, parent, false);


        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView Prix = (TextView) convertView.findViewById(R.id.Prix);
        TextView description = (TextView) convertView.findViewById(R.id.Desc);
        Button btnajouter = (Button) convertView.findViewById(R.id.btnajouter);

        img.setImageResource(produit.getImage());
        Prix.setText(produit.getPrix() + " Prix ");
        description.setText(produit.getDescription());

        btnajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean etat = true;
                for(Produit e:ProduitBD.PoduitPanier)
                {
                    if(produit.getNom().equals(e.getNom()))
                    {
                        produit.setQnt(produit.getQnt() + 1);
                        etat = false;
                        break;
                    }
                }

                if(etat == true)
                {
                    ProduitBD.PoduitPanier.add(produit);
                }

                Toast.makeText(ctx,"Ajouter a la carte",Toast.LENGTH_SHORT).show();
            }
        });
        return   convertView;
    }
}