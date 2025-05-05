# Projet Java EE - Gestion des Choix des Étudiants

## Nom : Cherif Harrak Yasser
## Filière : Informatique Logicielle et Décisionnelle
## Année : 3ème année - 2024/2025

---

## Description :

Cette application web permet aux étudiants de sélectionner un domaine de gestion parmi plusieurs proposés.
Un administrateur peut consulter, valider ou rejeter les choix effectués par les étudiants.

---

## Technologies utilisées :

- Java EE (Servlets, JSP)
- JDBC (Accès base de données)
- HTML / JSP
- MySQL
- Apache Tomcat

---

## Accès :

- URL de base : `http://localhost:8080/GestionChoixEtudiants/`

### Comptes de test :

- **Admin**
  - Email : `admin@bmhs.com`
  - Mot de passe : `admin123`

- **Étudiant**
  - Inscription depuis `register.jsp`

---

## Structure du projet :

- `/src/` → Code Java : modèles, DAO, servlets
- `/webapp/` → Fichiers JSP (login, register, dashboard, admin)
- `/WEB-INF/web.xml` → Configuration des servlets
- `/WEB-INF/lib/` → Fichier JDBC driver MySQL
- `/sql/` (optionnel) → Script SQL pour créer la base de données

---

## Remarques :

- Mot de passe non chiffré (pour simplification du projet)
- Le code peut être amélioré (validation, style, sécurité)
- L'étudiant se connecte puis choisit un domaine
- L’admin valide ou rejette chaque choix

---

## Bon courage pour la correction et merci !
