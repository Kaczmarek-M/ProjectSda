package com.barterownia.controller;

import com.barterownia.model.VideoGame;
import com.barterownia.model.dto.NewVideoGameDTO;
import com.barterownia.repository.VideoGameRepository;
import com.barterownia.service.ItemService;
import com.barterownia.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/video_game/")
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/add")
    public String getAddAuction(@RequestParam(name = "id") Long itemId, Model model) {

        model.addAttribute("video_game", new NewVideoGameDTO());
        model.addAttribute("item_id", itemId);

        return "addVideoGame";
    }


    @PostMapping(path = "/add")
    public String addAuction(NewVideoGameDTO newVideoGameDTO, @RequestParam(name = "itemId") Long itemId) {

        VideoGame videoGame = videoGameService.addVideoGame(newVideoGameDTO);
        itemService.updateItemId(itemId, videoGame.getId());

        return "redirect:/user/panel";
    }
}
