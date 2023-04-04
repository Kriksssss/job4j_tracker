package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastCutomer = null;
        for (int i = 0; i < count; i++) {
            lastCutomer = queue.poll();
        }
        return lastCutomer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer upsetCustomer = null;
        for (int i = 0; i <= count; i++) {
            upsetCustomer = queue.poll();
        }
        return upsetCustomer.name();
    }
}
