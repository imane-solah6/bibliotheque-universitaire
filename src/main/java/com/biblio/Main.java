package com.biblio;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bibliotheque_universitaire?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // ou ton utilisateur MySQL
        String password = "Estuche2019$";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connexion MySQL réussie !");
        } catch (Exception e) {
            System.err.println("❌ Échec connexion: " + e.getMessage());
        }
    }
}