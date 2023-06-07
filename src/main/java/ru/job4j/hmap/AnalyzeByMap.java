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
        List<Label> label = new ArrayList<>();
        Map<String, Integer> score = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject s : subjects) {
                score.put(s.name(), score.getOrDefault(s.name(), 0) + s.score());
            }
        }
        score.forEach((key, value) -> label.add(new Label(key, (double) value / pupils.size())));
        return label;
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
        Map<String, Integer> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}