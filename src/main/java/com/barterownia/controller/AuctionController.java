package com.barterownia.controller;

import com.barterownia.model.Auction;
import com.barterownia.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private MobilePhoneService mobilePhoneService;

    @Autowired
    private MusicAlbumService musicAlbumService;

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping(path = "/list/{category}")
    public String getAuctionList(Model model, @PathVariable(name = "category") String category) {
        List<Auction> byCategory = auctionService.findByCategory(category);

        model.addAttribute("auctionList", byCategory);

        byCategory.forEach(System.out::print);

        return "/auctionList";
    }

    @GetMapping(path = "/{id}")
    public String getAuction(Model model, @PathVariable(name = "id") long id) {

        Optional<Auction> auctionOptional = auctionService.findById(id);

        if (!auctionOptional.isPresent()) {
            return "/home";
        }

        Auction auction = auctionOptional.get();

        model.addAttribute("auction", auction);

        String tableName = auction.getItem().getCategory().getTableName();
        Long itemId = auction.getItem().getItemId();

        if ("mobile_phone".equals(tableName)) {
            model.addAttribute("item", mobilePhoneService.findById(itemId));
        } else if ("laptop".equals(tableName)) {
            return "redirect:/laptop/" + itemId;
//            model.addAttribute("item",laptopService.findById(itemId));
        } else if ("music_album".equals(tableName)) {
            model.addAttribute("item", musicAlbumService.findById(itemId));
        } else if ("video_game".equals(tableName)) {
            model.addAttribute("item", videoGameService.findById(itemId));
        }

        return "/auction";
    }

}
