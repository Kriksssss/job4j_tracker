package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            return new Car(this);
        }
    }

    public Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.created = builder.created;
        this.volume = builder.volume;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car{"
                +
                "brand='"
                + brand + '\'' + ", model='"
                + model + '\'' + ", created="
                + created + ", volume="
                + volume + ", color='" + color + '\'' + '}';
    }

    public static void main(String[] args) {
        Car car1 = new Car.Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2022, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car1);

        Car car2 = new Car.Builder()
                .buildBrand("BMW")
                .buildModel("X5")
                .build();
        System.out.println(car2);
    }
}