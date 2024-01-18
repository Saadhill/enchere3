package fr.eni.tp.encheres.dal.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.tp.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.tp.encheres.bo.Utilisateur;

@Repository
@Profile("sql")
public class UtilisateurSQL implements UtilisateurDAO {


    public final static String SELECT_ALL_UTILISATEURS = "SELECT * FROM UTILISATEURS";
    public final static String SELECT_UTILISATEUR_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = :no_utilisateur";
    final static String SELECT_USER_BY_USERNAME = "select * from UTILISATEURS where pseudo=:pseudo";
    final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, rue, code_postal, ville,mot_de_passe, credit, telephone, administrateur) VALUES (:pseudo, :nom, :prenom, :email, :rue, :code_postal, :ville,:mot_de_passe, :credit,:telephone, :administrateur)";
    final static String UPDATE_UTILISATEUR = "update UTILISATEURS set pseudo=:pseudo, nom=:nom, prenom=:prenom, email=:email, rue=:rue, code_postal=:code_postal, ville=:ville, credit=:credit,telephone=:telephone, administrateur=:administrateur where no_utilisateur=:no_utilisateur";
    final static String UPDATE_CREDIT_UTILISATEUR = "UPDATE UTILISATEURS set credit=:credit where no_utilisateur = :no_utilisateur";
    final static String DELETE_USER = "delete UTILISATEURS where no_utilisateur = :no_utilisateur";


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UtilisateurSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> utilisateurs;
        utilisateurs = namedParameterJdbcTemplate.query(SELECT_ALL_UTILISATEURS, new BeanPropertyRowMapper<>(Utilisateur.class));
        return utilisateurs;

    }
    @Override
    public Utilisateur read(Integer no_utilisateur) {
        Utilisateur src = new Utilisateur(no_utilisateur);
        Utilisateur utilisateur = namedParameterJdbcTemplate.queryForObject(SELECT_UTILISATEUR_BY_ID, new BeanPropertySqlParameterSource(src), new BeanPropertyRowMapper<>(Utilisateur.class));
        return utilisateur;


    }

    public Utilisateur readSpeudo(String pseudo){
        Utilisateur src = new Utilisateur(pseudo);
        Utilisateur utilisateur = namedParameterJdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new BeanPropertySqlParameterSource(src), new BeanPropertyRowMapper<>(Utilisateur.class));
        return utilisateur;

    }



    @Override
    public void update(Utilisateur utilisateur) {
        String sql = "UPDATE UTILISATEURS SET nom = :nom WHERE no_utilisateur = :no_utilisateur";

        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(utilisateur);

        namedParameterJdbcTemplate.update(sql, namedParameters);

    }

    @Override
    public void insert(Utilisateur utilisateur) {
        System.out.println("----------------------------------------------------------------");

        Map<String, Object> map = new HashMap<>();
        if(utilisateur.getNo_utilisateur() != null) {
            map.put("no_utilisateur", utilisateur.getNo_utilisateur());
        }
        map.put("pseudo", utilisateur.getPseudo());
        map.put("nom", utilisateur.getNom());
        map.put("prenom", utilisateur.getPrenom());
        map.put("email", utilisateur.getEmail());
        map.put("telephone", utilisateur.getTelephone());
        map.put("rue", utilisateur.getRue());
        map.put("code_postal", utilisateur.getCodePostal());
        map.put("ville", utilisateur.getVille());
        if (utilisateur.getNo_utilisateur() == null) {
            map.put("mot_de_passe", utilisateur.getMotDePasse());
        }
        map.put("credit", 600);
        map.put("administrateur", 1);

        if (utilisateur.getNo_utilisateur() == null) {
            namedParameterJdbcTemplate.update(INSERT_UTILISATEUR, map);
            System.out.println("Mauvais passage");
        } else {
            namedParameterJdbcTemplate.update(UPDATE_UTILISATEUR, map);
            System.out.println("Bon passage");
        }

    }



    //TODO a voir si on utilise ce genre de method pour lier des articles a un utilisateur

   /* @Override
    public void insertClientBar(long idBar, long idClient) {
        String sql = "insert into bar_client (id_bar, id_client) values "
                + "(:id_bar, :id_client)";
        //String sql= "insert into bar_client (id_bar, id_client) values (" + idBar + ',' + idClient + ")";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id_bar", idBar);
        namedParameters.addValue("id_client", idClient);

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }*/

   /* @Override
    public void supprimerClientBar(long idBar) {
        String sql = "delete from bar_client where id_bar = :id_bar";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id_bar", idBar);

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }*/

    @Override
    public void delete(Integer no_utilisateur) {
        Utilisateur src = new Utilisateur(no_utilisateur);
        namedParameterJdbcTemplate.update(DELETE_USER, new BeanPropertySqlParameterSource(src));


    }
}
