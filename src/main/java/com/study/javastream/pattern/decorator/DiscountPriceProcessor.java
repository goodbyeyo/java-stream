package com.study.javastream.pattern.decorator;

public class DiscountPriceProcessor implements PriceProcessor{
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied discount");
    }
}
