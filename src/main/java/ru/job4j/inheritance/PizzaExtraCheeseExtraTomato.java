package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private final String tomato = " + extra tomato";

    @Override
    public String name() {
        return super.name() + tomato;
    }
}
