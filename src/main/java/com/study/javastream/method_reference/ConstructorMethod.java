package com.study.javastream.method_reference;

import com.study.javastream.functional_interface.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * ClassName::new
 */
public class ConstructorMethod {

    public static void main(String[] args) {

        Map<String, BiFunction<String, String, Car>> carTypeMap = new HashMap<>();
        carTypeMap.put("sedan", Sedan::new);
        carTypeMap.put("van", Van::new);
        carTypeMap.put("suv", Suv::new);

        String[][] inputs = new String[][] {
                {"sedan", "S530", "Benz"},
                {"van", "GV70", "Genesis"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "MarKan", "Porsche"}
        };

        List<Car> cars = new ArrayList<>();
        for (String[] input : inputs) {
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            // constructor 꺼내서, apply -> constructor 호출 : new
            cars.add(carTypeMap.get(carType).apply(name, brand));
        }
        for (Car car : cars) {
            car.drive();
        }
    }
}
