package com.example.spock_learning.shared;

import java.math.BigDecimal;

public record Money(BigDecimal amount, Currency currency) {

    public static Money ofPLN(BigDecimal amount) {
        return new Money(amount, Currency.PLN);
    }

    public static Money zero() {
        return ofPLN(BigDecimal.ZERO);
    }

    public Money add(Money other) {
        return ofPLN(this.amount.add(other.amount));
    }

    public Money multiply(int number) {
        return ofPLN(this.amount.multiply(BigDecimal.valueOf(number)));
    }

    public Money changeCurrency(Currency toCurrency, BigDecimal exchangeRate) {
        return new Money(amount.multiply(exchangeRate), toCurrency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money money)) {
            return false;
        }

        return money.amount.equals(this.amount);
    }
}
