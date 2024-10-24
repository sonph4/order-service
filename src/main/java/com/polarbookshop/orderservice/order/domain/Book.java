package com.polarbookshop.orderservice.order.domain;

public record Book(
        String isbn,
        String title,
        String author,
        Double price
) {
}
