package com.devbus.auction.mapper;

import com.devbus.auction.dto.AuctionItemDTO;
import com.devbus.auction.entity.AuctionItem;
import com.devbus.auction.entity.User;

public class AuctionItemMapper {
    public static AuctionItemDTO mapToDTO(AuctionItem auctionItem){
        return new AuctionItemDTO(auctionItem.getName(), auctionItem.getDescription());
    }

    public static AuctionItem mapToEntity(AuctionItemDTO auctionItemDTO, User user){
        return new AuctionItem(auctionItemDTO.name(), auctionItemDTO.description(), user);
    }
}
