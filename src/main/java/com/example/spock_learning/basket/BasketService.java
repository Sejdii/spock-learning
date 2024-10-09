package com.example.spock_learning.basket;

import com.example.spock_learning.order.Order;
import com.example.spock_learning.product.Product;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public Basket addProduct(Product product) {
        Optional<Basket> foundBasket = basketRepository.find();

        Basket basket = foundBasket.orElseGet(Basket::new);
        basket.addProduct(product);
        basketRepository.save(basket);
        return basket;
    }

    public Order getOrder() {
        return basketRepository.find().map(Basket::toOrder)
            .orElseThrow();
    }
}
