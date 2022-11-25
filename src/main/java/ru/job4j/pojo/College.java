package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Рамазанов Надыр Рамазанович");
        student.setGroup(5);
        student.setReceiptDate(new Date());
        System.out.println(student.getFullName() + ". Группа: " + student.getGroup() + ". Дата поступления: " + student.getReceiptDate());

    }
}
