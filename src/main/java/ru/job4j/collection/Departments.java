package ru.job4j.collection;

import java.util.*;

/**
 * Класс Departments предоставляет методы для работы с коллекцией подразделений.
 *
 * @author NABI DZHEBIEV
 * @version 1.0
 */
public class Departments {

    /**
     * Метод fillGaps заполняет пропущенные коды подразделений.
     *
     * @param deps список строк с кодами подразделений
     * @return список строк с полными кодами подразделений
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод sortAsc сортирует список подразделений по возрастанию.
     *
     * @param orgs список подразделений для сортировки
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод sortDesc сортирует список подразделений по убыванию.
     *
     * @param orgs список подразделений для сортировки
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}