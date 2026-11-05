package com.biblio.model;

import java.time.LocalDate;// Pour les dates sans heure (ex: date de retour)
import java.time.LocalDateTime;// Pour les dates avec heure (ex: moment exact de l'emprunt)
import java.time.temporal.ChronoUnit;// Outil pour calculer la différence entre deux dates

/**
 * Représente un emprunt (relation entre Livre et Membre).
 * Correspond à la table 'emprunt' en BDD.
 */
public class Emprunt {
    private int id;
    private int livreId;// FK vers Livre
    private int membreId;// FK vers Membre
    private LocalDateTime dateEmprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourReelle;
    private boolean estRenouvele;

    public Emprunt(int id,int livreId,int membreId,LocalDateTime dateEmprunt,
                   LocalDate dateRetourPrevue,LocalDate dateRetourReelle,boolean estRenouvele){
        this.id = id;
        this.livreId = livreId;
        this.membreId = membreId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourReelle = dateRetourReelle;
        this.estRenouvele = estRenouvele;
    }
    // Constructeur pour nouvel emprunt
    public Emprunt(int livreId,int membreId){
        this.livreId=livreId;
        this.membreId=membreId;
        this.dateEmprunt=LocalDateTime.now();// Heure actuelle automatique
        this.dateRetourPrevue=LocalDate.now().plusDays(14);// Date d'aujourd'hui + 14 jours
        this.dateRetourReelle=null;// Pas encore rendu !
        this.estRenouvele=false;// Premier emprunt
    }
    // Getters et Setters
    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getLivreId(){return livreId;}
    public void setLivreId(int livreId){this.livreId=livreId;}

    public int getMembreId() { return membreId; }
    public void setMembreId(int membreId) { this.membreId = membreId; }

    public LocalDateTime getDateEmprunt() { return dateEmprunt; }
    public void setDateEmprunt(LocalDateTime dateEmprunt) { this.dateEmprunt = dateEmprunt; }

    public LocalDate getDateRetourPrevue() { return dateRetourPrevue; }
    public void setDateRetourPrevue(LocalDate dateRetourPrevue) { this.dateRetourPrevue = dateRetourPrevue; }

    public LocalDate getDateRetourReelle() { return dateRetourReelle; }
    public void setDateRetourReelle(LocalDate dateRetourReelle) { this.dateRetourReelle = dateRetourReelle; }

    public boolean isEstRenouvele() { return estRenouvele; }
    public void setEstRenouvele(boolean estRenouvele) { this.estRenouvele = estRenouvele; }

    // Méthodes métier CRUCIALES
    public boolean estEnCours(){
        return dateRetourReelle==null;
    }
    public boolean estEmprunt(){
        return dateRetourReelle==null;
    }
    public int calculerJoursRetard(){
        if(dateRetourReelle==null || !dateRetourReelle.isAfter(dateRetourPrevue)){
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(dateRetourPrevue,dateRetourReelle);
    }
    public double calculerAmende(){
        int joursRetard=calculerJoursRetard();
        return joursRetard *2.0;  //2 DH par jour de retard
    }
    public boolean peutRenouveler(){
        return estEnCours()&& !estRenouvele;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", livreId=" + livreId +
                ", membreId=" + membreId +
                ", retourPrevu=" + dateRetourPrevue +
                ", enCours=" + estEnCours() +
                '}';
    }

}