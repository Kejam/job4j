package ru.job4j;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.bot.Bot;
import ru.job4j.bot.ChatBot;
import ru.job4j.bot.User;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestBot {
    User user;
    Bot bot;
    ChatBot chat;

    @Before
    public void setUp() {
        user = new User();
        bot = new Bot();
    }

    @Test
    public void whenUserSay() {
        user.say("test");
        assertThat(user.getInput(), is("test"));
    }

    @Test
    public void whenFlagStop() {
        bot.stop();
        assertThat(bot.say(), is("I'm waiting while flag will true"));
    }

    @Ignore
    @Test
    public void whenFlagStart() {
        bot.start();
        assertThat(bot.getList().contains(bot.say()), is(true));
    }
}
