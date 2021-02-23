package com.vins.climbingFriends.security;


import com.vins.climbingFriends.model.Grimpeur;
import com.vins.climbingFriends.repository.IGrimpeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurSecurityService implements UserDetailsService {

    private final IGrimpeurRepository grimpeurRepository;

    @Autowired
    public UtilisateurSecurityService(IGrimpeurRepository grimpeurRepository) {
        this.grimpeurRepository = grimpeurRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Grimpeur grimpeur = grimpeurRepository.findByPseudo(pseudo.toLowerCase());
        if (grimpeur == null) {
            throw new UsernameNotFoundException("No user present with username : " + grimpeur);
        }
        else {
            return grimpeur;
        }
    }
}
