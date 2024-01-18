package fr.eni.tp.encheres.bll.impl;

import fr.eni.tp.encheres.bll.RetraitService;
import fr.eni.tp.encheres.bo.ArticleVendu;
import fr.eni.tp.encheres.bo.Retrait;
import fr.eni.tp.encheres.dal.ArticleVenduDAO;
import fr.eni.tp.encheres.dal.RetraitDAO;
import org.springframework.stereotype.Service;

@Service
public class RetraitServiceImpl implements RetraitService{


    private RetraitDAO retraitDAO;
    private ArticleVenduDAO articleVenduDAO;

    public RetraitServiceImpl(RetraitDAO retraitDAO, ArticleVenduDAO articleVenduDAO) {
        super();
        this.retraitDAO = retraitDAO;
        this.articleVenduDAO = articleVenduDAO;
    }


    @Override
    public void createRetrait(Retrait retrait, ArticleVendu article) {
        this.retraitDAO.createRetrait(retrait,article);

    }

    @Override
    public Retrait findRetraitByArticle(ArticleVendu articleVendu) {
        Retrait retrait = this.retraitDAO.getRetraitByArticle(articleVendu);
      return retrait;
    }
}
