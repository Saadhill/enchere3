package fr.eni.tp.encheres.dal;

import fr.eni.tp.encheres.bo.ArticleVendu;
import fr.eni.tp.encheres.bo.Retrait;

public interface RetraitDAO {

    void createRetrait(Retrait retrait, ArticleVendu article);

    public Retrait getRetraitByArticle(ArticleVendu articleVendu);
}
