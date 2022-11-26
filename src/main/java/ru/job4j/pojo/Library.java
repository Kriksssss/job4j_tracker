package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
     Book book0 = new Book("1984", 450);
     Book book1 = new Book("Clean code", 903);
     Book book2 = new Book("Три товарища", 444);
     Book book3 = new Book("Двенадцать стульев", 350);
     Book[] mass = new Book[4];
     mass[0] = book0;
     mass[1] = book1;
     mass[2] = book2;
     mass[3] = book3;
        for (Book out : mass) {
            System.out.println(out.getName() + " - " + out.getPages() + " страниц");
        }
     System.out.println("  Переставим местами книги с индексом 0 и 3");
     mass[0] = book3;
     mass[3] = book0;
        for (Book out : mass) {
            System.out.println(out.getName() + " - " + out.getPages() + " страниц");
        }
     System.out.println("  Книги с именем Clean code");
        for (Book out : mass) {
            if ("Clean code".equals(out.getName())) {
                System.out.println(out.getName() + " - " + out.getPages() + " страниц");
            }
        }
    }
}
