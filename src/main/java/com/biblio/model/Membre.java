package com.biblio.model;

import java.time.LocalDate;

/**
 * Représente l'entité 'Membre' (étudiant/professeur).
 * Correspond à la table 'membre' en BDD.
 */
public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String matricule;
    private String email;
    private LocalDate dateInscription;
    private String statut; // "ACTIF" ou "SUSPENDU"
    private double soldeAmende;

    // Constructeur complet (chargement depuis BDD)
    public Membre(int id, String nom, String prenom, String matricule,
                  String email, LocalDate dateInscription,
                  String statut, double soldeAmende) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.email = email;
        this.dateInscription = dateInscription;
        this.statut = statut;
        this.soldeAmende = soldeAmende;
    }

    // Constructeur partiel (création d'un nouveau membre)
    public Membre(String nom, String prenom, String matricule, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.email = email;
        this.dateInscription = LocalDate.now();
        this.statut = "ACTIF";
        this.soldeAmende = 0.0;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public double getSoldeAmende() { return soldeAmende; }
    public void setSoldeAmende(double soldeAmende) { this.soldeAmende = soldeAmende; }

    // Méthodes métier
    public boolean estActif() {
        return "ACTIF".equals(statut);
    }

    public boolean peutEmprunter(int nbEmpruntsEnCours) {
        return estActif() && nbEmpruntsEnCours < 3 && soldeAmende == 0.0;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}