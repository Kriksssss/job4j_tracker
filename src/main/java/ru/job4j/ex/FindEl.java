package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("нет такого ключа в массиве");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] k = new String[] {"lll", "sss", "ooo"};
        try {
            System.out.println(indexOf(k, "sdsd"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

