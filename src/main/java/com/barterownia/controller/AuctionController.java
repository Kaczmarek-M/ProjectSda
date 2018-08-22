package com.barterownia.controller;

import com.barterownia.model.Auction;
import com.barterownia.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping(path = "/list/{category}")
    public String getAuctionList(Model model, @PathVariable(name = "category")String category){
        List<Auction> byCategory = auctionService.findByCategory(category);

        model.addAttribute("auctionList", byCategory);

        byCategory.forEach(System.out::print);

        return "/auctionList";
    }

}
