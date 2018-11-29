package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> bankAccounts = new HashMap<>();
    public void addUser(User user) {
        this.bankAccounts.putIfAbsent(user, new ArrayList<>());
    }
    public void deleteUser(User user) {
        if (bankAccounts.containsKey(user)) {
            bankAccounts.remove(user);
        }
    }
    public void addAccountToUser(String passport, Account account) {
        User user = findUser(passport);
        if (bankAccounts.containsKey(user)) {
            bankAccounts.get(user).add(account);
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUser(passport);
        if (bankAccounts.containsKey(user)) {
            bankAccounts.get(user).remove(account);
        }
    }
    private User findUser(String passport) {
        for (Map.Entry<User, List<Account>> desired : this.bankAccounts.entrySet()) {
            if (desired.getKey().getPassport().equals(passport)) {
                return desired.getKey();
            }
        }
        return null;
    }
    public List<Account> getUserAccounts (String passport) {
        User user = findUser(passport);
        List<Account> accounts =  bankAccounts.get(user);
        return accounts;
    }
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account account = getActualAccount(srcPassport, srcRequisite);
        Account account1 = getActualAccount(destPassport, dstRequisite);
        if (account.getValue() >= amount) {
            account.setValue((int) (account.getValue() - amount));
            account1.setValue((int) (account.getValue() + amount));
            result = true;
        }
        return result;
    }
    private Account getActualAccount(String passport, String requisite) {
        Account account = null;
        for (Map.Entry<User, List<Account>> desired : this.bankAccounts.entrySet()) {
            for (Account account1 : desired.getValue()) {
                if (account1.toString().equals(requisite)) {
                    account = account1;
                    break;
                }
            }
        }
        List<Account> list = this.bankAccounts.get(findUser(passport));
        return list.get(list.indexOf(account));
    }
}
