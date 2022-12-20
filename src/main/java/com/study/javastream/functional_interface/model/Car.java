package com.study.javastream.functional_interface.model;

public abstract class Car {

    // 상속받은 클래스들도 사용할수 있도록 protected
    protected String name;
    protected String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public abstract void drive();
}
