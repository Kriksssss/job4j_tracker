package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        String passwordUp = password.toUpperCase();
        if (password.equals(passwordUp)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        String passwordLc = password.toLowerCase();
        if (password.equals(passwordLc)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        boolean passDigit = false;
        for (Character ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                passDigit = true;
                break;
            }
        }
        if (!passDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        boolean passSpecial = false;
        for (Character ch : password.toCharArray()) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                passSpecial = true;
                break;
            }
        }
        if (!passSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] passContain = {"qwerty", "12345", "password", "admin", "user"};
        for (String i : passContain) {
            if (password.toLowerCase().contains(i)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings:" +
                        " qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}