package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public class Main {
        public static void main(String[] args) {
            Stream<Card> decks = Stream.of(Suit.values())
                    .flatMap(suit -> Stream.of(Value.values())
                            .map(value -> new Card(suit, value)));
            decks.forEach(card -> System.out.println(card.suit + " " + card.value));
        }
    }
}
