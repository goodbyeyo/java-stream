package com.study.javastream.pattern.decorator;

public interface PriceProcessor {
    Price process(Price price);

    /**
     * price 받아와서 process 를 진행하고 next 로 들어온 프로세스를 진행하는 메서드
     */
    default PriceProcessor andThen(PriceProcessor next) {
        return price -> next.process(process(price));
    }
}
