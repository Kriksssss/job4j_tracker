package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает работу простейшего сервиса банковского приложения.
 * Позволяет добавлять пользователей, удалять пользователей,
 * добавлять счета пользователям, искать пользователя по паспорту,
 * искать счет пользователя по реквизитам, осуществлять переводы между счетами.
 * Может предоставлять список счетов пользователя.
 *
 * @author NABI DZHEBIEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранит информацию о пользователях и связанных с ними счетах.
     * Ключом является объект класса User, значением - список счетов пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в сервис банковского приложения.
     * Если пользователь уже существует, метод не выполняет никаких действий.
     *
     * @param user объект класса User, представляющий пользователя
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    /**
     * Удаляет пользователя из сервиса банковского приложения.
     *
     * @param passport номер паспорта пользователя
     * @return true, если пользователь успешно удален, иначе false
     */
    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user == null) {
            return false;
        }
        return users.remove(user) != null;
    }

    /**
     * Добавляет счет пользователю.
     * Если пользователь не существует, метод не выполняет никаких действий.
     *
     * @param passport номер паспорта пользователя
     * @param account  объект класса Account, представляющий счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        users.put(user, accounts);
    }

    /**
     * Ищет пользователя по номеру паспорта.
     *
     * @param passport номер паспорта для поиска пользователя
     * @return объект класса User, соответствующий пользователю, или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет счет пользователя по реквизитам.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счета для поиска
     * @return объект класса Account, соответствующий счету, или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Осуществляет перевод средств между счетами.
     *
     * @param srcPassport   номер паспорта отправителя
     * @param srcRequisite  реквизиты счета отправителя
     * @param destPassport  номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount        сумма перевода
     * @return true, если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        Account srcAccount = findByRequisite(srcUser.getPassport(), srcRequisite);
        User destUser = findByPassport(destPassport);
        Account destAccount = findByRequisite(destUser.getPassport(), destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user объект класса User, представляющий пользователя
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
