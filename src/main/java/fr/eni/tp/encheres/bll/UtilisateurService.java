package fr.eni.tp.encheres.bll;

import java.util.List;

import fr.eni.tp.encheres.bo.*;

public interface UtilisateurService {

                        //CREATE
    void createUtilisateur(Utilisateur utilisateur);     //TODO

    public Boolean isPseudoUnique(String pseudo);        //TODO

    public Boolean isMailUnique(String email);           //TODO

                        //READ

    List<Utilisateur> findAllUtilisateurs();             //TODO

    Utilisateur findUtilisateurById(Integer id);         //TODO

    public Utilisateur findUserByPseudo(String pseudo);      //TODO

                        //UPDATE

    void updateUtilisateur(Utilisateur utilisateur);        //TODO CHECK
    void updateCredit(int valeur, Utilisateur utilisateur);  //TODO




    //DELETE
    void deleteUtilisateur(Integer id);      //TODO




}
