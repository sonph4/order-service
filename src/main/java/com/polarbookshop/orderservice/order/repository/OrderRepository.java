package com.polarbookshop.orderservice.order.repository;

import com.polarbookshop.orderservice.order.domain.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findAllByCreatedBy(String userId);
}
