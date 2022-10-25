package ru.job4j.oop;

public class Cat {

    private String food;
    private String nickname;

    public void show() {
        System.out.println(this.nickname + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.nickname = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Murka ");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Tiger ");
        black.eat("fish");
        black.show();
    }
}
