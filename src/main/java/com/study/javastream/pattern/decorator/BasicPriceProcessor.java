package com.study.javastream.pattern.decorator;

public class BasicPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return price;
    }
}
