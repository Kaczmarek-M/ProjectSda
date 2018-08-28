package com.barterownia.controller;

import com.barterownia.model.*;
import com.barterownia.model.dto.NewAuctionDTO;
import com.barterownia.model.dto.NewLaptopDTO;
import com.barterownia.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
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

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/list/category/{category}")
    public String getAuctionListByCategory(Model model, @PathVariable(name = "category") String category) {
        List<Auction> byCategory = auctionService.findByCategory(category);

        model.addAttribute("auctionList", byCategory);


        return "/auctionList";
    }

    @GetMapping(path = "/list/title")
    public String getAuctionListByTitle(Model model, @RequestParam(name = "title") String title) {
        List<Auction> byTitle = auctionService.findByTitleContaining(title);

        model.addAttribute("auctionList", byTitle);

        return "/auctionList";
    }

    @GetMapping(path = "/get/{id}")
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
            Optional<MobilePhone> mobilePhone = mobilePhoneService.findById(itemId);
            model.addAttribute("item", mobilePhone.get());
            model.addAttribute("fieldMap", mobilePhone.get().getFieldMap());
        } else if ("laptop".equals(tableName)) {
            Optional<Laptop> laptop = laptopService.findById(itemId);
            model.addAttribute("item", laptop.get());
            model.addAttribute("fieldMap", laptop.get().getFieldMap());
        } else if ("music_album".equals(tableName)) {
            Optional<MusicAlbum> musicAlbum = musicAlbumService.findById(itemId);
            model.addAttribute("item", musicAlbum.get());
            model.addAttribute("fieldMap", musicAlbum.get().getFieldMap());
        } else if ("video_game".equals(tableName)) {
            Optional<VideoGame> videoGame = videoGameService.findById(itemId);
            model.addAttribute("item", videoGame.get());
            model.addAttribute("fieldMap", videoGame.get().getFieldMap());
        }

        return "/auction";
    }

    @GetMapping(path = "/add")
    public String getAddAuction(Model model) {
        model.addAttribute("auction", new NewAuctionDTO());
//        model.addAttribute("laptop", new NewLaptopDTO());
//        model.addAttribute("musicAlbum", new MusicAlbum());

        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "addAuction";
    }


    @PostMapping(path = "/add")
    public String addAuction(NewAuctionDTO newAuction, Principal principal) {
        newAuction.setUsername(principal.getName());

        Optional<Auction> auction = auctionService.addAuction(newAuction);

        return "redirect:/" + categoryService.findCategoryById(newAuction.getCategoryId()).getTableName() + "/add?id=" + auction.get().getItem().getId();
    }

    @GetMapping(path = "/accept/{id}")
    public String acceptAuction(@PathVariable(name = "id") long id) {
        auctionService.acceptAuction(id);

        return "redirect:/user/panel";
    }
}
