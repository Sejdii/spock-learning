package com.example.spock_learning.basket;

import java.util.Optional;

public class InMemoryBasketRepository implements BasketRepository {

    private Basket basket = null;

    @Override
    public Optional<Basket> find() {
        return Optional.ofNullable(basket);
    }

    @Override
    public void save(Basket basket) {
        this.basket = basket;
    }
}
