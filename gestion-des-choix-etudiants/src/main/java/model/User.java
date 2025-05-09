package model;

public class User {
    private int id;
    private String nom;
    private String email;
    private String password;
    private String role;

    public User() {}

    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.role = "etudiant";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
