package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    String Cheese = " + extra cheese";

    @Override
    public String name() {
        return super.name() + Cheese;
    }
}
