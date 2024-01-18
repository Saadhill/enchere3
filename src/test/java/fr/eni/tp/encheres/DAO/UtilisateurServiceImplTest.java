package fr.eni.tp.encheres.bll.impl;

import fr.eni.tp.encheres.dal.UtilisateurDAO;
import fr.eni.tp.encheres.bo.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UtilisateurServiceImplTest {

    @Mock
    private UtilisateurDAO utilisateurDAO;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUtilisateur() {
        // Créer un utilisateur de test
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("testUser");
        utilisateur.setMotDePasse("password");

        // Simuler l'encodage du mot de passe
        String encodedPassword = "encodedPassword";
        when(passwordEncoder.encode(utilisateur.getMotDePasse())).thenReturn(encodedPassword);

        // Appeler la méthode createUtilisateur
        utilisateurService.createUtilisateur(utilisateur);

        // Vérifier si le mot de passe a été encodé
        assertEquals(encodedPassword, utilisateur.getMotDePasse());

        // Vérifier si la méthode insert de utilisateurDAO a été appelée
        verify(utilisateurDAO).insert(any(Utilisateur.class));
    }
}
