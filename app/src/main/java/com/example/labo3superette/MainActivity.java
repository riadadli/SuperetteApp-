package com.example.labo3superette;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //creation ( parce que si ecris on create )

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ProduitBD();
    }

    private void ProduitBD()
    {
        Produit p1=new Produit(1,"Raisin","Raisin du vin",4.99,R.drawable.fruits4,1);
        Produit p2=new Produit(1,"Banane","Banane du méxique ",0.99,R.drawable.fruits3,1);
        Produit p3=new Produit(1,"Raspberries","petits fruits ronds rouge",2.99,R.drawable.fruits2,1);
        Produit p4=new Produit(1,"bleuberries","petits fruits ronds bleu",2.99,R.drawable.fruits1,1);

        Produit p5=new Produit(2,"tomate","tomamte organique",2.00,R.drawable.l2,1);
        Produit p6=new Produit(2,"Pomme de terre","Pomme de terre du sable",1.99,R.drawable.l1,1);
        Produit p7=new Produit(2,"Carotte","Carotte courte",3.00,R.drawable.l4,1);
        Produit p8=new Produit(2,"Panais","Panais original",1.99,R.drawable.l33,1);

        Produit p9=new Produit(3,"chiche kebab","viande syriane",6.99,R.drawable.v2,1);
        Produit p10=new Produit(3,"viande hachée","viande rapée",5.99,R.drawable.v3,1);
        Produit p11=new Produit(3,"boeuf","boeuf d'agneau",9.99,R.drawable.v1,1);
        Produit p12=new Produit(3,"Merguez","Merguez spéciel",7.99,R.drawable.v4,1);

        ProduitBD.ProduitInventaire.add(p1);
        ProduitBD.ProduitInventaire.add(p2);
        ProduitBD.ProduitInventaire.add(p3);
        ProduitBD.ProduitInventaire.add(p4);
        ProduitBD.ProduitInventaire.add(p5);
        ProduitBD.ProduitInventaire.add(p6);
        ProduitBD.ProduitInventaire.add(p7);
        ProduitBD.ProduitInventaire.add(p8);
        ProduitBD.ProduitInventaire.add(p9);
        ProduitBD.ProduitInventaire.add(p10);
        ProduitBD.ProduitInventaire.add(p11);
        ProduitBD.ProduitInventaire.add(p12);


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
