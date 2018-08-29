package com.barterownia.service;

import com.barterownia.model.AppUser;
import com.barterownia.model.Auction;
import com.barterownia.model.dto.NewUserDTO;
import com.barterownia.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean addUser(NewUserDTO appUser) {

        Optional<AppUser> userByUsername = userRepository.findAppUserByUsername(appUser.getUsername());

        if (userByUsername.isPresent()) {
            return false;
        }

        AppUser newUser = new AppUser(appUser.getUsername(), bCryptPasswordEncoder.encode(appUser.getPassword()), 0);

        userRepository.save(newUser);

        return true;
    }

    public Optional<AppUser> deleteUser(long id) {
        Optional<AppUser> appUser = userRepository.findById(id);

        if (appUser.isPresent()) {
            userRepository.deleteById(appUser.get().getId());
            return appUser;
        }

        return appUser;
    }

    public Optional<AppUser> findOptionalByUsername(String username) {
        return userRepository.findAppUserByUsername(username);
    }

    public AppUser findByUsername(String username) {
        Optional<AppUser> userOptional = userRepository.findAppUserByUsername(username);
        AppUser user = userOptional.get();
        return user;
    }

    public Optional<AppUser> setUserPrivilege(long id, int privilege) {
        Optional<AppUser> user = userRepository.findById(id);

        if (!user.isPresent()) {
            return Optional.empty();
        }

        AppUser appUser = user.get();

        appUser.setPrivilege(privilege);

        return Optional.of(userRepository.save(appUser));

    }

    public void addAuction(AppUser user, Auction auction) {
        user.getAuctions().add(auction);
        userRepository.save(user);
    }

    public List<AppUser> findAllByUsernameContaining(String username) {
        return userRepository.findAllByUsernameContaining(username);
    }

    public boolean makeExpert(long id) {
        Optional<AppUser> optionalOfUser = userRepository.findById(id);

        if (optionalOfUser.isPresent()) {
            AppUser appUser = optionalOfUser.get();
            appUser.setPrivilege(2);
            userRepository.save(appUser);
            return true;
        }
        return false;
    }


    public boolean makeAdmin(long id) {
        Optional<AppUser> optionalOfUser = userRepository.findById(id);

        if (optionalOfUser.isPresent()) {
            AppUser appUser = optionalOfUser.get();
            appUser.setPrivilege(3);
            userRepository.save(appUser);
            return true;
        }
        return false;
    }

    public boolean makeUser(long id) {
        Optional<AppUser> optionalOfUser = userRepository.findById(id);

        if (optionalOfUser.isPresent()) {
            AppUser appUser = optionalOfUser.get();
            appUser.setPrivilege(1);
            userRepository.save(appUser);
            return true;
        }
        return false;
    }
}
