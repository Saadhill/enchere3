package fr.eni.tp.encheres.bll;

import fr.eni.tp.encheres.bo.ArticleVendu;
import fr.eni.tp.encheres.bo.Retrait;

public interface RetraitService {

    void createRetrait(Retrait retrait, ArticleVendu article);

    public Retrait findRetraitByArticle(ArticleVendu articleVendu);


}
