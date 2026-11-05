package com.biblio.model;

import java.time.LocalDate;

public class Livre{
    private int id;
    private String titre;
    private String auteur;
    private String isbn;
    private int anneePublication;
    private String genre;
    private int nbExemplairesTotal;
    private int nbExemplairesDisponibles;

    public Livre(int id,String titre ,String auteur,String isbn, int anneePublication,String genre,int nbExemplairesTotal,int nbExemplairesDisponibles){
        this.id=id;
        this.titre=titre;
        this.auteur=auteur;
        this.isbn=isbn;
        this.anneePublication=anneePublication;
        this.genre=genre;
        this.nbExemplairesTotal=nbExemplairesTotal;
        this.nbExemplairesDisponibles=nbExemplairesDisponibles;

    }
    //getters and setters
    public int getId() {return id;}
    public void setId(int id){this.id=id;}

    public String getTitre(){return titre;}
    public void setTitre(String titre){this.titre=titre;}

    public String getAuteur(){return auteur;}
    public void setAuteur(String auteur){ this.auteur=auteur;}

    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn=isbn;}

    public int getAnneePublication() {return anneePublication;}
    public void setAnneePublication(int anneePublication){this.anneePublication=anneePublication;}

    public String getGenre(){return genre;}
    public void setGenre(String genre){this.genre=genre;}

    public int getNbExemplairesTotal() { return nbExemplairesTotal; }
    public void setNbExemplairesTotal(int nbExemplairesTotal) { this.nbExemplairesTotal = nbExemplairesTotal; }

    public int getNbExemplairesDisponibles() { return nbExemplairesDisponibles; }
    public void setNbExemplairesDisponibles(int nbExemplairesDisponibles) { this.nbExemplairesDisponibles = nbExemplairesDisponibles; }

    public boolean isDisponible(){
        return nbExemplairesDisponibles >0;
    }
    @Override
    public String toString(){
        return "Livre{"+
                "id="+id+
                ",titre='"+titre+'\''+
                ",auteur='"+auteur+'\''+
                ",isbn='"+isbn+'\''+
                ",disponible="+isDisponible()+
                '}';

    }
}