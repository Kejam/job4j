package ru.job4j.questions;

import java.util.concurrent.locks.ReentrantLock;

public class Boom {
    final ReentrantLock[][] board;

    public Boom(ReentrantLock[][] board) {
        this.board = board;
    }


}
