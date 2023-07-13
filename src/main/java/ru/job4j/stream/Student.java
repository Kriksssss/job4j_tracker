package ru.job4j.stream;

import java.util.Objects;

public record Student(int score, String surname) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(surname, student.surname);
    }

}
