package com.example.labo3superette;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private ListView lv2;
    private panierAdapter adapter;
    private TextView pt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        this.lv2=findViewById(R.id.lv2);
        this.pt=findViewById(R.id.pt);


        this.adapter=new panierAdapter(this,R.layout.panier_layout,ProduitBD.PoduitPanier);
        this.lv2.setAdapter(adapter);

        if(ProduitBD.PoduitPanier.size() != 0)
        {
            calcule();
        }
        else
        {
            pt.setText("TOTAL : 0 $ ");
        }



    }
    public void calcule()
    {
        double PT=0.0;
        for (Produit ele:ProduitBD.PoduitPanier)
        {
            PT=PT+( ele.getPrix() * ele.getQnt());
        }
        pt.setText(String.format("Prix totale : %.2f $",PT));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem m1 = menu.add(Menu.NONE, Menu.FIRST, 0, "Fruits");
        MenuItem m2 = menu.add(Menu.NONE, Menu.FIRST + 1, 1, "Légumes");
        MenuItem m3 = menu.add(Menu.NONE, Menu.FIRST + 2, 2, "Viandes");


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case Menu.FIRST:
                Intent i1=new Intent(this,MainActivity2.class);
                i1.putExtra("Categorie",1); // Ajout de données supplémentaires (un entier avec la clé "Cat") à l'Intent.
                startActivity(i1);
                return true;
            case Menu.FIRST + 1:
                Intent i2=new Intent(this,MainActivity2.class);
                i2.putExtra("Categorie",2);
                startActivity(i2);
                return true;
            case Menu.FIRST + 2 :
                Intent i3 =new Intent(this,MainActivity2.class);
                i3.putExtra("Categorie",3);
                startActivity(i3);
                return true;
        }
        return true;
    }

}