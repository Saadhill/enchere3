package fr.eni.tp.encheres.dal.impl;

import fr.eni.tp.encheres.bo.ArticleVendu;
import fr.eni.tp.encheres.bo.Retrait;
import fr.eni.tp.encheres.dal.RetraitDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class RetraitSQL implements RetraitDAO {

    private JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RetraitSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createRetrait(Retrait retrait, ArticleVendu article) {

        String sql = "INSERT INTO retrait (rue, code_postal, ville, no_article) " +
                "VALUES (:rue, :code_postal, :ville, :no_article)";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("rue", retrait.getRue());
        namedParameters.addValue("code_postal", retrait.getCode_postal());
        namedParameters.addValue("ville", retrait.getVille());
        namedParameters.addValue("no_article", article.getNo_article());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    @Override
    public Retrait getRetraitByArticle(ArticleVendu articleVendu) {
        String sql = "SELECT * FROM retrait WHERE articleVendu = :articleVendu";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("no_article", articleVendu.getNo_article());
        Retrait retrait = (Retrait) namedParameterJdbcTemplate.query(sql, namedParameters,
        new BeanPropertyRowMapper<>(Retrait.class));
        return retrait;


    }
}
