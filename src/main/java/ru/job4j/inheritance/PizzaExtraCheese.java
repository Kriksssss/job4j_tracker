package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    String cheese = " + extra cheese";

    @Override
    public String name() {
        return super.name() + cheese;
    }
}
