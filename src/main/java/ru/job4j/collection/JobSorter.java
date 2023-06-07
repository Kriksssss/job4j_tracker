package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        sortLeftOnRight(jobs);
        sortRightOnLeft(jobs);
    }

    private static void sortLeftOnRight(List<Job> jobs) {
        jobs.sort(new SortByNameJob());
        System.out.println(jobs);
    }

    private static void sortRightOnLeft(List<Job> jobs) {
        jobs.sort(new SortDescByNameJob());
        System.out.println(jobs);
    }
}
