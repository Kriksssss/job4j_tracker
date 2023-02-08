package ru.job4j.polymorph;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar();
        ((Vehicle) sportCar).changeGear();
        ((Vehicle) sportCar).accelerate();
        ((Vehicle) sportCar).steer();
        ((Vehicle) sportCar).brake();
        ((Fuel) sportCar).refill();
    }

}
