package fr.eni.tp.encheres.dal;

import fr.eni.tp.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDAO {


    public Utilisateur read(Integer id);

    public List<Utilisateur> findAll();
    public Utilisateur readSpeudo(String pseudo);

    public void update(Utilisateur utilisateur );

    public void insert(Utilisateur utilisateur);





    //public void supprimerClientBar(long no_utilisateur);

    public void delete(Integer no_utilisateur);

}
