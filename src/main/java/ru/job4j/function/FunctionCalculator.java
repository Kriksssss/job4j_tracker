package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс FunctionCalculator предоставляет методы для вычисления значений функций в заданном диапазоне.
 */
public class FunctionCalculator {
    /**
     * Вычисляет значения функции в заданном диапазоне.
     *
     * @param start начальное значение диапазона (включительно)
     * @param end   конечное значение диапазона (не включая)
     * @param func  функция, принимающая один аргумент типа Double и возвращающая значение типа Double
     * @return список значений функции в заданном диапазоне
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double value = func.apply((double) i);
            result.add(value);
        }
        return result;
    }
}
