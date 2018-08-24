package com.barterownia.service;

import com.barterownia.model.AppUser;
import com.barterownia.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service

public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<AppUser> foundUser = userRepository.findAppUserByUsername(username);

        if (foundUser.isPresent()) {
            AppUser appUser = foundUser.get();

            return new User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    getRolesForUser(appUser));
        }
        throw new UsernameNotFoundException("Username not found");
    }

    private Collection<? extends GrantedAuthority> getRolesForUser(AppUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user.getPrivilege() > 2) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if (user.getPrivilege() > 1) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_RZECZOZNAWCA"));
        }

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return grantedAuthorities;
    }
}
