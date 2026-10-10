package com.devbus.auction.services;

import com.devbus.auction.dto.AuctionItemDTO;
import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.entity.AuctionItem;
import com.devbus.auction.entity.User;
import com.devbus.auction.mapper.AuctionItemMapper;
import com.devbus.auction.repository.AuctionItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuctionItemService {

    private final AuctionItemRepository auctionItemRepository;
    private final UserService userService;

    public AuctionItemService(AuctionItemRepository auctionItemRepository, UserService userService) {
        this.auctionItemRepository = auctionItemRepository;
        this.userService = userService;
    }

    public List<AuctionItemDTO> findAllByUserId(UUID userId) {
        Optional<UserDTO> userDto = this.userService.getUserById(userId);
        if(userDto.isPresent()){
            return this.auctionItemRepository
                    .findByUser_Id(userId)
                    .stream()
                    .map(AuctionItemMapper::mapToDTO)
                    .toList();
        }
        return null;
    }

    public AuctionItemDTO createAuctionItem(AuctionItemDTO auctionItemDTO, UUID userId) {
        User user = userService.findEntityById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"
                ));
        AuctionItem item = AuctionItemMapper.mapToEntity(auctionItemDTO, user);
        AuctionItem savedItem = auctionItemRepository.save(item);

        return AuctionItemMapper.mapToDTO(savedItem);
    }
}
