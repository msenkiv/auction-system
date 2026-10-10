package com.devbus.auction.dto;

public record ApiResponse<T>(int status, T data) {
}
