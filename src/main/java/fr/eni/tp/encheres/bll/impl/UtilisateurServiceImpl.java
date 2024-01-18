package fr.eni.tp.encheres.bll.impl;

import fr.eni.tp.encheres.dal.UtilisateurDAO;
import fr.eni.tp.encheres.bll.UtilisateurService;
import fr.eni.tp.encheres.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

private UtilisateurDAO utilisateurDAO;
    PasswordEncoder passwordEncoder;

    public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO, PasswordEncoder passwordEncoder) {
        super();
        this.utilisateurDAO = utilisateurDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUtilisateur(Utilisateur utilisateur) {

        if(utilisateur.getMotDePasse() != null) {
            utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        }
        this.utilisateurDAO.insert(utilisateur);



    }

    @Override
    public Boolean isPseudoUnique(String pseudo) {
        //TODO
        return null;
    }

    @Override
    public Boolean isMailUnique(String email) {
        //TODO
        return null;
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {

        return this.utilisateurDAO.findAll();


    }

    @Override
    public Utilisateur findUtilisateurById(Integer id) {

        Utilisateur utilisateur = this.utilisateurDAO.read(id);

        return utilisateur;
    }

    @Override
    public Utilisateur findUserByPseudo(String pseudo) {

        Utilisateur utilisateur = this.utilisateurDAO.readSpeudo(pseudo);

        return utilisateur;
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {

        this.utilisateurDAO.update(utilisateur);


    }

    @Override
    public void updateCredit(int valeur, Utilisateur utilisateur) {
        //TODO

    }

    @Override
    public void deleteUtilisateur(Integer no_utilisateur) {

        this.utilisateurDAO.delete(no_utilisateur);


    }
}
