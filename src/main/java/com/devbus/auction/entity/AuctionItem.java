package com.devbus.auction.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "auction_item")
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id_auction_item")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_description")
    private String description;

    public User getUser() {
        return user;
    }

    public AuctionItem() {}
    public AuctionItem(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
