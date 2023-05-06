package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return (double) sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            int count = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double average = (double) sum / count;
            Label label = new Label(pupil.name(), average);
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> scoresBySubject = new LinkedHashMap<>();
        Map<String, Integer> countsBySubject = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();
                scoresBySubject.merge(subjectName, score, Integer::sum);
                countsBySubject.merge(subjectName, 1, Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoresBySubject.entrySet()) {
            String subjectName = entry.getKey();
            int score = entry.getValue();
            int count = countsBySubject.get(subjectName);
            double average = (double) score / count;
            result.add(new Label(subjectName, average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjects = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.computeIfPresent(subject.name(), (k, v) -> v + subject.score());
                subjects.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
