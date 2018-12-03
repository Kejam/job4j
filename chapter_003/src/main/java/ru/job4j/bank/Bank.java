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
    public User findUser(String passport) {
        for (Map.Entry<User, List<Account>> desired : this.bankAccounts.entrySet()) {
            if (desired.getKey().getPassport().equals(passport)) {
                return desired.getKey();
            }
        }
        return null;
    }
    public List<Account> getUserAccounts(String passport) {
        User user = findUser(passport);
        List<Account> accounts =  bankAccounts.get(user);
        return accounts;
    }
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, int amount) {
        boolean result = false;
        if ((findUser(srcPassport)) != null && findUser(dstPassport) != null && getActualAccount(srcPassport,
                srcRequisite).getValue() >= amount) {
            getActualAccount(srcPassport, srcRequisite).setValue(getActualAccount(srcPassport, srcRequisite).getValue() - amount);
            getActualAccount(dstPassport, dstRequisite).setValue(getActualAccount(dstPassport, dstRequisite).getValue() + amount);
            result = true;
        }
        return result;
    }
    public Account getActualAccount(String passport, String requisite) {
        Account account = null;
        List<Account> accounts = getUserAccounts(passport);
        if (accounts != null) {
            for (Account a: accounts) {
                String check = String.valueOf(a.getRequisites());
                if (requisite.equals(check)) {
                    account = a;
                    break;
                }
            }
        }
        return account;
    }
}
