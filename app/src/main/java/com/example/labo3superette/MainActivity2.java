package com.example.labo3superette;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Context ctx;
    private Button btncarte;
    private TextView ctg;
    private ListView lv1;
    private inventaireAdapter adapter;
    private ArrayList<Produit> lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        this.ctx=this;
        this.ctg=findViewById(R.id.ctg);
        this.lv1=findViewById(R.id.lv1);
        this.lp=new ArrayList<Produit>();

        this.btncarte=findViewById(R.id.btncarte);
        this.btncarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(ctx,MainActivity3.class);
                startActivity(i);
            }
        });
        Bundle b = getIntent().getExtras();
        int categotrie=b.getInt("Categorie");

        if(categotrie==1)
        {
            ctg.setText("Fruits");
        }
        if(categotrie==2)
        {
            ctg.setText("Légumes");
        }
        if (categotrie==3)
        {
            ctg.setText("Viandes");
        }

        for (Produit el:ProduitBD.ProduitInventaire)
        {
            if(el.getCat()==categotrie)
            {
                lp.add(el);

            }
        }
        this.adapter=new inventaireAdapter(this,R.layout.inventaire_layout,lp);
        this.lv1.setAdapter(adapter);
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