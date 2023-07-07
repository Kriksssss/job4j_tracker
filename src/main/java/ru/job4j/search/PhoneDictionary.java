package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Класс PhoneDictionary представляет собой телефонный справочник, содержащий список абонентов.
 */
public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    /**
     * Добавляет абонента в телефонный справочник.
     *
     * @param person абонент для добавления
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Выполняет поиск абонентов в телефонном справочнике, соответствующих заданному предикату.
     *
     * @param predicate предикат для фильтрации абонентов
     * @return список абонентов, удовлетворяющих предикату
     */
    public ArrayList<Person> find(Predicate<Person> predicate) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}




