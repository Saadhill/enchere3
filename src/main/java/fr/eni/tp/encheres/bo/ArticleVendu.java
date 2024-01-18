package fr.eni.tp.encheres.bo;

import java.time.LocalDate;




import java.time.LocalDate;
import java.util.Date;

public class ArticleVendu {

    private boolean vendu = false;
    private Utilisateur utilisateur;

    private String nom_article,description;
    private Categorie categorie;

    private Integer no_article,prix_initial,prix_vente;

    private LocalDate date_debut_encheres,date_fin_encheres;


    public ArticleVendu(boolean vendu, Utilisateur utilisateur, String nom_article, String description, Categorie categorie, Integer no_article, Integer prix_initial, Integer prix_vente, LocalDate date_debut_encheres, LocalDate date_fin_encheres) {
        this.vendu = vendu;
        this.utilisateur = utilisateur;
        this.nom_article = nom_article;
        this.description = description;
        this.categorie = categorie;
        this.no_article = no_article;
        this.prix_initial = prix_initial;
        this.prix_vente = prix_vente;
        this.date_debut_encheres = date_debut_encheres;
        this.date_fin_encheres = date_fin_encheres;
    }


    @Override
    public String toString() {
        return "ArticleVendu{" +
                "vendu=" + vendu +
                ", utilisateur=" + utilisateur +
                ", nom_article='" + nom_article + '\'' +
                ", description='" + description + '\'' +
                ", categorie=" + categorie +
                ", no_article=" + no_article +
                ", prix_initial=" + prix_initial +
                ", prix_vente=" + prix_vente +
                ", date_debut_encheres=" + date_debut_encheres +
                ", date_fin_encheres=" + date_fin_encheres +
                '}';
    }

    //vendu
    @Override
    public boolean equals(Object article) {
        if (this == article) {
            return true;
        }
        if (article == null || getClass() != article.getClass()) {
            return false;
        }
        ArticleVendu monArticle = (ArticleVendu) article;
        return this.no_article.equals(monArticle.no_article) && this.nom_article.equals(monArticle.nom_article);
    }



    //getter setter
    public boolean isVendu() {
        return vendu;
    }

    public void setVendu(boolean vendu) {
        this.vendu = vendu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getNo_article() {
        return no_article;
    }

    public void setNo_article(Integer no_article) {
        this.no_article = no_article;
    }

    public Integer getPrix_initial() {
        return prix_initial;
    }

    public void setPrix_initial(Integer prix_initial) {
        this.prix_initial = prix_initial;
    }

    public Integer getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(Integer prix_vente) {
        this.prix_vente = prix_vente;
    }

    public LocalDate getDate_debut_encheres() {
        return date_debut_encheres;
    }

    public void setDate_debut_encheres(LocalDate date_debut_encheres) {
        this.date_debut_encheres = date_debut_encheres;
    }

    public LocalDate getDate_fin_encheres() {
        return date_fin_encheres;
    }

    public void setDate_fin_encheres(LocalDate date_fin_encheres) {
        this.date_fin_encheres = date_fin_encheres;
    }





}

