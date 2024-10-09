package com.example.spock_learning.basket


import spock.lang.Specification

import static com.example.spock_learning.product.ProductTestFactory.createCleanCodeBook

class BasketServiceWithoutMocksTest extends Specification {

    def basketRepository = new InMemoryBasketRepository()
    def basketService = new BasketService(basketRepository)

    def "should add product to existing basket"() {
        given:
        basketRepository.save(new Basket())
        def product = createCleanCodeBook()

        when:
        def basket = basketService.addProduct(product)

        then:
        basket.getOrderLines().size() == 1
        basket.getOrderLines().getFirst().getProduct() == product
    }

    // TODO: write test for Order
}
