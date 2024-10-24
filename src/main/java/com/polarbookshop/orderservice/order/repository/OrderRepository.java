package com.polarbookshop.orderservice.order.repository;

import com.polarbookshop.orderservice.order.domain.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
