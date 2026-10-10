package com.devbus.auction.controller;

import com.devbus.auction.dto.ApiResponse;
import com.devbus.auction.dto.AuctionItemDTO;
import com.devbus.auction.services.AuctionItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/auction-item")
public class AuctionItemController {

    private final AuctionItemService auctionItemService;

    public AuctionItemController(AuctionItemService auctionItemService) {
        this.auctionItemService = auctionItemService;
    }


    @PostMapping()
    public ResponseEntity<ApiResponse<AuctionItemDTO>> createAuctionItem(@RequestBody AuctionItemDTO auctionItemDTO,
                                                               @RequestHeader("x-api-key")UUID userId) {
        AuctionItemDTO createdItem = this.auctionItemService.createAuctionItem(auctionItemDTO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(HttpStatus.CREATED.value(),createdItem));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<AuctionItemDTO>>> getAllAuctionItem(@RequestHeader("x-api-key")UUID userId){
        List<AuctionItemDTO> auctionItemDTOList = this.auctionItemService.findAllByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK.value(),auctionItemDTOList));
    }
}
