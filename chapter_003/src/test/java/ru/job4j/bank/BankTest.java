package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddClient() {
        Bank bank = new Bank();
        User user = new User("Aleksey","4500", 1);
        bank.addUser(user);
        assertThat(bank.findUser("4500"), is(user));
    }
    @Test
    public void whenDeleteClient() {
        Bank bank = new Bank();
        User user = new User("Aleksey","4500", 1);
        bank.addUser(user);
        bank.deleteUser(user);
        Object o = null;
        assertThat(bank.findUser("4500"), is(o));
    }
    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Aleksey","4500", 1);
        Account account = new Account(12000, 11);
        bank.addUser(user);
        bank.addAccountToUser("4500", account);
        List<Account> accounts = new LinkedList<>();
        accounts.add(account);
        assertThat(bank.getUserAccounts("4500"), is(accounts));
    }
    @Test
    public void whenDeleteAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Aleksey","4500", 1);
        Account account = new Account(12000, 11);
        bank.addUser(user);
        bank.addAccountToUser("4500", account);
        bank.deleteAccountFromUser("4500", account);
        List<Account> accounts = new LinkedList<>();
        assertThat(bank.getUserAccounts("4500"), is(accounts));
    }
    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        User user = new User("Aleksey","4500", 1);
        Account account = new Account(12000, 11);
        User user1 = new User("Alex","2000", 2);
        Account account1 = new Account(20000, 22);
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser("4500",account);
        bank.addAccountToUser("2000",account1);
        bank.transferMoney("4500", "11", "2000", "22", 1000);
        Account account2 = new Account(21000, 22);
        List<Account> accounts = new LinkedList<>();
        accounts.add(account2);
        assertThat(bank.getUserAccounts("2000"), is(accounts));
    }
}
