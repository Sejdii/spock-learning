package com.example.spock_learning

import com.example.spock_learning.basket.Basket
import com.example.spock_learning.shared.Money
import spock.lang.Specification

import static com.example.spock_learning.product.ProductTestFactory.createCleanCodeBook
import static com.example.spock_learning.product.ProductTestFactory.createMicroservicesBook

class BasketSpecification extends Specification {

    def basket = new Basket()

    def "Should add product to basket"() {
        given:
        def product = createCleanCodeBook()

        when:
        basket.addProduct(product)

        then:
        basket.getTotalPrice() == Money.ofPLN(BigDecimal.valueOf(148.28))
    }

    def "Should add multiple products to basket"() {
        given:
        def product = createMicroservicesBook()

        when:
        basket.addProduct(product, amount)

        then:
        basket.getTotalPrice() == Money.ofPLN(BigDecimal.valueOf(expectedPriceAmount))

        where:
        amount | expectedPriceAmount
        2      | 470.8
        5      | 1177.0
    }
}
