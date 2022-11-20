package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public Battery() {
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery charger = new Battery();
        Battery another = new Battery();
        charger.exchange(another);
        System.out.println(charger.getLoad() + another.getLoad());
    }
}
