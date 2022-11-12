package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public static void main(String[] args) {
        Error error = new Error(true, 2, "Intel Core I7-10700K");
        error.printInfo();
        Error comp = new Error(true, 3, "AMD Ryzen 5 3600");
        comp.printInfo();
        Error third = new Error();
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println("Статус " + status);
        System.out.println(message);
    }
}