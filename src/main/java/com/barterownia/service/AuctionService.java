package com.barterownia.service;

import com.barterownia.model.Auction;
import com.barterownia.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public Auction addAuction(Auction auction) {
        return auctionRepository.save(auction);
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

}
