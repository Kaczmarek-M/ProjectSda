package com.barterownia.repository;

import com.barterownia.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAllByItem_Category_Name(String categoryName);

    List<Auction> findAllByUser_Id(long userId);

}