-- 1. Table LIVRE
CREATE TABLE IF NOT EXISTS livre (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    annee_publication YEAR,
    genre VARCHAR(100),
    nb_exemplaires_total INT NOT NULL DEFAULT 0,
    nb_exemplaires_disponibles INT NOT NULL DEFAULT 0,
    CONSTRAINT chk_exemplaires CHECK (nb_exemplaires_disponibles <= nb_exemplaires_total)
    );

-- 2. Table MEMBRE
CREATE TABLE IF NOT EXISTS membre (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    matricule VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE,
    date_inscription DATE NOT NULL DEFAULT (CURRENT_DATE),
    statut ENUM('ACTIF', 'SUSPENDU') NOT NULL DEFAULT 'ACTIF',
    solde_amende DECIMAL(10, 2) NOT NULL DEFAULT 0.00
    );

-- 3. Table EMPRUNT
CREATE TABLE IF NOT EXISTS emprunt (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       livre_id INT NOT NULL,
                                       membre_id INT NOT NULL,
                                       date_emprunt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       date_retour_prevue DATE NOT NULL,
                                       date_retour_reelle DATE NULL,
                                       est_renouvelle BOOLEAN NOT NULL DEFAULT FALSE,
                                       FOREIGN KEY (livre_id) REFERENCES livre(id) ON DELETE RESTRICT,
    FOREIGN KEY (membre_id) REFERENCES membre(id) ON DELETE CASCADE,
    INDEX idx_membre_date (membre_id, date_emprunt)
    );

-- 4. Table RESERVATION
CREATE TABLE IF NOT EXISTS reservation (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           livre_id INT NOT NULL,
                                           membre_id INT NOT NULL,
                                           date_reservation DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                           date_expiration DATETIME NOT NULL,
                                           est_active BOOLEAN NOT NULL DEFAULT TRUE,
                                           FOREIGN KEY (livre_id) REFERENCES livre(id) ON DELETE CASCADE,
    FOREIGN KEY (membre_id) REFERENCES membre(id) ON DELETE CASCADE
    );

