package com.devbus.auction.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_address")
    private UUID id;

    String city;
    String street;
    String state;
    String zip;
    String addressNumber;
    String addressComplement;

    public Address(String city, String street, String state, String zip, String addressNumber, String addressComplement) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.addressNumber = addressNumber;
        this.addressComplement = addressComplement;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }
}
