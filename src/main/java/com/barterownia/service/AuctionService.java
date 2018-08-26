package com.barterownia.service;

import com.barterownia.model.AppUser;
import com.barterownia.model.Auction;
import com.barterownia.model.Category;
import com.barterownia.model.Item;
import com.barterownia.model.dto.NewAuctionDTO;
import com.barterownia.repository.AuctionRepository;
import com.barterownia.repository.CategoryRepository;
import com.barterownia.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AppUserService appUserService;

    public void addAuction(NewAuctionDTO newAuctionDTO, Principal principal) {
        Auction auction = new Auction();
        Item item = new Item();

        AppUser user = appUserService.findByUsername(principal.getName());
        System.out.println(user);

        item.setCategory(categoryService.findCategoryById(newAuctionDTO.getCategoryId()));
        item.setEstimatedPrice(newAuctionDTO.getEstimatedPrice());
        itemService.addItem(item);

        auction.setDescription(newAuctionDTO.getDescription());
        auction.setTitle(newAuctionDTO.getTitle());
        auction.setExpirationDate(LocalDateTime.now().plusDays(newAuctionDTO.getDuration()));
        auction.setItem(item);
        auction.setUser(user);

        saveAuction(auction);
    }

    public void saveAuction(Auction auction){
        auctionRepository.save(auction);
    }

    public Optional<Auction> findById(long id) {
        return auctionRepository.findById(id);
    }

    public List<Auction> findByUserId(long id) {
        return auctionRepository.findAllByUser_Id(id);
    }

    public List<Auction> findByCategory(String category) {
        return auctionRepository.findAllByItem_Category_Name(category);
    }

    public void deleteAuction(long id) {
        auctionRepository.deleteById(id);
    }


    public Auction findByProductAndCategory(Long laptopId) {
        return null;
    }

    public List<Auction> findByTitleContaining(String title) {
        return auctionRepository.findAllByTitleContaining(title);
    }




}