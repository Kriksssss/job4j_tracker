package ru.job4j.hmap;

import java.util.*;

/**
 * Класс для анализа данных оценок учеников с использованием коллекций Map.
 */
public class AnalyzeByMap {

    /**
     * Вычисляет средний балл всех учеников.
     *
     * @param pupils список учеников
     * @return средний балл всех учеников
     */
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0; // Общая сумма баллов
        int count = 0; // Количество оценок
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score(); // Добавляем балл к общей сумме
                count++; // Увеличиваем счетчик оценок
            }
        }
        return (double) sum / count; // Возвращаем средний балл
    }

    /**
     * Вычисляет средний балл по каждому ученику.
     *
     * @param pupils список учеников
     * @return список меток, где каждая метка содержит имя ученика и его средний балл
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(); // Результат
        for (Pupil pupil : pupils) {
            int sum = 0; // Общая сумма баллов
            int count = pupil.subjects().size(); // Количество предметов у ученика
            for (Subject subject : pupil.subjects()) {
                sum += subject.score(); // Добавляем балл к общей сумме
            }
            double average = (double) sum / count; // Вычисляем средний балл
            Label label = new Label(pupil.name(), average); // Создаем метку с именем ученика и его средним баллом
            result.add(label); // Добавляем метку к результату
        }
        return result; // Возвращаем результат
    }

    /**
     * Вычисляет средний балл по каждому предмету.
     *
     * @param pupils список учеников
     * @return список меток, где каждая метка содержит название предмета и его средний балл
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>(); // Результат
        Map<String, Integer> score = new LinkedHashMap<>(); // Хранение общих баллов по предметам
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects(); // Получаем список предметов ученика
            for (Subject s : subjects) {
                score.put(s.name(), score.getOrDefault(s.name(), 0) + s.score()); // Добавляем баллы к общему баллу предмета
            }
        }
        // Преобразуем общие баллы в средние баллы и создаем метки для каждого предмета
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            label.add(new Label(key, (double) value / pupils.size()));
        }
        return label; // Возвращаем результат
    }


    /**
     * Определяет ученика с наилучшим средним баллом.
     *
     * @param pupils список учеников
     * @return метка с именем ученика и его общим баллом
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>(); // Результат
        for (Pupil pupil : pupils) {
            int sum = 0; // Общая сумма баллов ученика
            for (Subject subject : pupil.subjects()) {
                sum += subject.score(); // Добавляем балл к общей сумме
            }
            labels.add(new Label(pupil.name(), sum)); // Добавляем ученика и его сумму баллов в результат
        }
        labels.sort(Comparator.naturalOrder()); // Сортируем результат
        return labels.get(labels.size() - 1); // Возвращаем ученика с наилучшим баллом
    }


    /**
     * Определяет предмет с наилучшим средним баллом.
     *
     * @param pupils список учеников
     * @return метка с названием предмета и его общим баллом
     */
    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>(); // Хранение общих баллов по предметам
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), subject.score(), Integer::sum); // Добавляем баллы к общему баллу предмета
            }
        }
        List<Label> labels = new ArrayList<>(); // Результат
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue())); // Добавляем предмет и его общий балл в результат
        }
        labels.sort(Comparator.naturalOrder()); // Сортируем результат
        return labels.get(labels.size() - 1); // Возвращаем предмет с наилучшим баллом
    }
}