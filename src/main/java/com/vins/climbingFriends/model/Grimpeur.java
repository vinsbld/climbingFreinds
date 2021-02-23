package com.vins.climbingFriends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Data
@ToString
public class Grimpeur implements UserDetails {

    @Id
    @GeneratedValue
    Long id;

    @Size(min = 2, max = 8)
    @Column(unique = true)
    String pseudo;

    @Column(unique = true)
    @Email
    String email;

    @Size(min = 4)
    String password;

    @JsonBackReference
    @OneToMany(mappedBy = "grimpeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<SiteEscalade> siteEscalades;

    @JsonBackReference
    @OneToMany(mappedBy = "grimpeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Topo>topos;

    @JsonBackReference
    @OneToMany(mappedBy = "grimpeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Commentaire>commentaires;

    @ElementCollection(targetClass = RolesEnum.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<RolesEnum> roles;

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = org.springframework.util.StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return pseudo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
