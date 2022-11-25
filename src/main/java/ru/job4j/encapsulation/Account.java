package ru.job4j.encapsulation;

public class Account {
    private int balance;

    public int addMoney(int money) {
        if (money > 0) {
            balance += money;
        }
        return balance;
    }
}
