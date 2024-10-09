package com.example.spock_learning.basket


import spock.lang.Specification

import static com.example.spock_learning.product.ProductTestFactory.createCleanCodeBook

class BasketServiceTest extends Specification {

    def basketRepository = Mock(BasketRepository)
    def basketService = new BasketService(basketRepository)

    def "should create new basket with given product"() {
        given:
        def product = createCleanCodeBook()

        basketRepository.find() >> Optional.empty()

        when:
        basketService.addProduct(product)

        then:
        1 * basketRepository.save(*_)
    }

    def "should create new basket with given product (but with real checking)"() {
        given:
        def product = createCleanCodeBook()

        basketRepository.find() >> Optional.empty()

        when:
        basketService.addProduct(product)

        then:
        1 * basketRepository.save({
            verifyAll(it, Basket) {
                orderLines.size() == 1
                def orderLine = orderLines.getFirst()
                orderLine.getProduct() == product
            }
        })
    }

    // TODO: write test for Order
}
