package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс DepDescComp реализует компаратор для сортировки подразделений в порядке убывания.
 */
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arr1 = o1.split("/");
        String[] arr2 = o2.split("/");
        int result = arr2[0].compareTo(arr1[0]);
        if (result == 0) {
            return o1.compareTo(o2);
        }
        return result;
    }
}
