package fr.eni.tp.encheres.bo;

public class Categorie {

    private long no_Categorie;
    private String libelle;

    public Categorie(long no_Categorie, String libelle) {
        this.no_Categorie = no_Categorie;
        this.libelle = libelle;
    }

    public long getNo_Categorie() {
        return no_Categorie;
    }

    public void setNo_Categorie(long no_Categorie) {
        this.no_Categorie = no_Categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "noCategorie=" + no_Categorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
