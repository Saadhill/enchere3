package fr.eni.tp.encheres.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {



    private static final long serialVersionUID = 1L;
    private Integer no_utilisateur;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String pseudo;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
    @Pattern(regexp = "^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$")
    private String telephone;
    @NotBlank
    private String rue;
    @Pattern(regexp = "^[0-9-]{5}")
    @NotBlank
    private String codePostal;
    @NotBlank
    private String ville;
    @NotBlank
    private String motDePasse;


    private int credit;

    private boolean administrateur = false;

    private List<ArticleVendu> ListeArticlesAchetes;

    private List<ArticleVendu> ListeArticlesVendus;

    private List<Enchere> listeEncheres;


    public Utilisateur(Integer no_utilisateur, String nom, String prenom, String pseudo, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur, List<ArticleVendu> listeArticlesAchetes, List<ArticleVendu> listeArticlesVendus, List<Enchere> listeEncheres) {
        this.no_utilisateur = no_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.credit = credit;
        this.administrateur = administrateur;
        ListeArticlesAchetes = listeArticlesAchetes;
        ListeArticlesVendus = listeArticlesVendus;
        this.listeEncheres = listeEncheres;
    }

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(Integer no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

    public Utilisateur(String pseudo) {
        this.pseudo = pseudo;
    }

    public Utilisateur() {
    }



    @Override
    public String toString() {
        return "Utilisateur{" +
                "no_utilisateur=" + no_utilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", credit=" + credit +
                ", administrateur=" + administrateur +
                ", ListeArticlesAchetes=" + ListeArticlesAchetes +
                ", ListeArticlesVendus=" + ListeArticlesVendus +
                ", listeEncheres=" + listeEncheres +
                '}';
    }

    public Integer getNo_utilisateur() {
        return no_utilisateur;
    }

    public void setNo_utilisateur(Integer no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public List<ArticleVendu> getListeArticlesAchetes() {
        return ListeArticlesAchetes;
    }

    public void setListeArticlesAchetes(List<ArticleVendu> listeArticlesAchetes) {
        ListeArticlesAchetes = listeArticlesAchetes;
    }

    public List<ArticleVendu> getListeArticlesVendus() {
        return ListeArticlesVendus;
    }

    public void setListeArticlesVendus(List<ArticleVendu> listeArticlesVendus) {
        ListeArticlesVendus = listeArticlesVendus;
    }

    public List<Enchere> getListeEncheres() {
        return listeEncheres;
    }

    public void setListeEncheres(List<Enchere> listeEncheres) {
        this.listeEncheres = listeEncheres;
    }
}

