package com.devbus.auction.repository;

import com.devbus.auction.entity.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, UUID> {

    List<AuctionItem> findByUser_Id(UUID userId);
}
