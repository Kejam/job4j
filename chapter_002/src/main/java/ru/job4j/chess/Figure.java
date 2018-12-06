package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

public abstract class Figure implements ru.job4j.chess.firuges.Figure {
    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }

}
