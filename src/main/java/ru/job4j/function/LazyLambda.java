package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLambda {
    public static void main(String[] args) {
        String[] names = {"Ivan"};
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);
    }
}
