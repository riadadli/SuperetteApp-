package com.example.labo3superette;

import android.content.Context;

public class Produit
{

  private int cat;
  private String nom;
  private String description;
  private double prix;
  private int image;
  private int qnt;

  public Produit(int cat,String nom ,String description,double prix,int image,int qnt)
  {

      this.cat=cat;
      this.nom=nom;
      this.description=description;
      this.image=image;
      this.qnt=qnt;
      this.prix=prix;

  }

    public int getCat() {return cat; }
    public void setCat(int cat) {this.cat = cat; }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public int getImage() {return image;}
    public void setImage(int image) {this.image = image;}

    public int getQnt() {return qnt;}
    public void setQnt(int qnt) {this.qnt = qnt;}

    public double getPrix() {return prix;}
    public void setPrix(double prix) {this.prix = prix;}
}
