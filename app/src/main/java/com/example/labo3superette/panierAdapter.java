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

public class panierAdapter extends ArrayAdapter<Produit>
{
    private Context ctx;
    private int resource;
    private ArrayList<Produit> lp;

    public panierAdapter(Context ctx, int resource, ArrayList<Produit> objects) {
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
        TextView Prix = (TextView) convertView.findViewById(R.id.prix);
        TextView quantite=(TextView)convertView.findViewById(R.id.Qnt);
        Button btnmoin=(Button) convertView.findViewById(R.id.btnmoin) ;
        Button btnplus=(Button) convertView.findViewById(R.id.btnplus) ;

        Button btneffacer = (Button) convertView.findViewById(R.id.btneffacer);

        quantite.setText(String.valueOf(produit.getQnt()));
        img.setImageResource(produit.getImage());
        Prix.setText(produit.getPrix() + " Prix ");

        btneffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduitBD.PoduitPanier.remove(produit);
                notifyDataSetChanged();// Rafraîchit l'affichage de la vue après une modification des données dans l'adapter
                ((MainActivity3)ctx).calcule();
            }
        });

        btnmoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(produit.getQnt()>1)
                {
                     produit.setQnt(produit.getQnt() - 1);
                     quantite.setText(String.valueOf(produit.getQnt()));
                     Prix.setText(String.format("%.2f $",(produit.getQnt() * produit.getPrix()) ));
                    ((MainActivity3)ctx).calcule();
                }

            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                    produit.setQnt(produit.getQnt() + 1);
                    quantite.setText(String.valueOf(produit.getQnt()));
                    Prix.setText(String.format("%.2f $",(produit.getQnt() * produit.getPrix()) ));
                    ((MainActivity3) ctx).calcule();

            }
        });


        return   convertView;
    }
}
