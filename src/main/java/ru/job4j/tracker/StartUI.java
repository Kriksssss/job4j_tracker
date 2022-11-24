package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI extends Item {
    public static void main(String[] args) {
        Item it = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String k = it.getCreated().format(formatter);
        System.out.println(k);
    }
}
