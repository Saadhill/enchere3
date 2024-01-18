package fr.eni.tp.encheres.bo;

import java.time.LocalDate;

public class Enchere {


    private Utilisateur utilisateur;

    private ArticleVendu articleVendu;
    private LocalDate date_enchere;
    private long montant_enchere;

    public Enchere(Utilisateur utilisateur, ArticleVendu articleVendu, LocalDate date_enchere, long montant_enchere) {
        this.utilisateur = utilisateur;
        this.articleVendu = articleVendu;
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;
    }

    @Override
    public String toString() {
        return "Enchere{" +
                "utilisateur=" + utilisateur +
                ", articleVendu=" + articleVendu +
                ", date_enchere=" + date_enchere +
                ", montant_enchere=" + montant_enchere +
                '}';
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public void setArticleVendu(ArticleVendu articleVendu) {
        this.articleVendu = articleVendu;
    }

    public LocalDate getDate_enchere() {
        return date_enchere;
    }

    public void setDate_enchere(LocalDate date_enchere) {
        this.date_enchere = date_enchere;
    }

    public long getMontant_enchere() {
        return montant_enchere;
    }

    public void setMontant_enchere(long montant_enchere) {
        this.montant_enchere = montant_enchere;
    }
}
