package com.barterownia.service;

import com.barterownia.model.AppUser;
import com.barterownia.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    public AppUser addUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public Optional<AppUser> deleteUser(long id) {
        Optional<AppUser> appUser = userRepository.findById(id);

        if (appUser.isPresent()) {
            userRepository.deleteById(appUser.get().getId());
            return appUser;
        }

        return appUser;
    }

    public Optional<AppUser> findByUsername(String username){
        return userRepository.findAppUserByUsername(username);
    }

    public Optional<AppUser> setUserPrivilege(long id, int privilege){
        Optional<AppUser> user = userRepository.findById(id);

        if (!user.isPresent()){
            return Optional.empty();
        }

        AppUser appUser = user.get();

        appUser.setPrivilege(privilege);

        return Optional.of(userRepository.save(appUser));

    }

}

//ewa.herliczek@eurocash.pl