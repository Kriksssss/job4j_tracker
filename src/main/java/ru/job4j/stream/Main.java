package ru.job4j.stream;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Card> decks = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)));
        decks.forEach(System.out::println);
    }
}
