package com.barterownia.controller;

import com.barterownia.model.MusicAlbum;
import com.barterownia.model.dto.NewMusicAlbumDTO;
import com.barterownia.service.ItemService;
import com.barterownia.service.MusicAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = "/music_album/")
public class MusicAlbumController {

    @Autowired
    private MusicAlbumService musicAlbumService;

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/add")
    public String getAddAuction(@RequestParam(name = "id") Long itemId, Model model) {

        model.addAttribute("music_album", new NewMusicAlbumDTO());
        model.addAttribute("item_id", itemId);

        return "addMusicAlbum";
    }


    @PostMapping(path = "/add")
    public String addAuction(NewMusicAlbumDTO musicAlbumDTO, @RequestParam(name = "itemId") Long itemId) {

        MusicAlbum musicAlbum = musicAlbumService.addAlbum(musicAlbumDTO);
        itemService.updateItemId(itemId, musicAlbum.getId());

        return "redirect:/user/panel";
    }
}
