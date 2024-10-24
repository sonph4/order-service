package com.polarbookshop.orderservice.order.service;

import com.polarbookshop.orderservice.config.ClientProperties;
import com.polarbookshop.orderservice.order.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Component
public class BookClient {
    public static final String BOOKS_ROOT_API = "/books/";
    private final WebClient webClient;
    private final ClientProperties clientProperties;
    public BookClient(WebClient webClient, ClientProperties clientProperties) {
        this.webClient = webClient;
        this.clientProperties = clientProperties;
    }

    public Mono<Book> getBookByIsbn(String isbn) {
        return webClient
                .get()
                .uri(BOOKS_ROOT_API + isbn)
                .retrieve()
                .bodyToMono(Book.class)
                .timeout(Duration.ofSeconds(clientProperties.catalogServiceTimeout()), Mono.empty())
                .onErrorResume(WebClientResponseException.NotFound.class, exception->Mono.empty())
                .retryWhen(Retry.backoff(clientProperties.maxRetryAttempt(), Duration.ofMillis(100)))
                .onErrorResume(Exception.class, exception -> Mono.empty());
    }
}
