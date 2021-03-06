package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenBoardIsThreeOnThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        assertThat(result, is(
                String.format("X X%s X %sX X%s", line, line, line)
                )
        );
    }
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        assertThat(result, is(
                String.format("X X %s X X%sX X %s X X%sX X %s", line, line, line, line, line)
                )
        );
    }
}
