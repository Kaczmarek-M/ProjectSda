package com.barterownia.controller;

import com.barterownia.model.MusicAlbum;
import com.barterownia.service.MusicAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class IndexController {

    @Autowired
    private MusicAlbumService musicAlbumService;


    @GetMapping(path = "/addMusic")
    public void saveTest() {
        musicAlbumService.addAlbum(new MusicAlbum(1L, "asd", "asd", LocalDate.now(), "CD"));
    }
}
