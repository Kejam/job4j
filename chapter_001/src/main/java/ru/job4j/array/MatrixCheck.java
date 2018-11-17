package ru.job4j.array;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Проверяет диагонали.
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0].length != data.length) { //Если массив не квадратный, то у него нет явных диагоналей.
                result = false;
                break;
            }
            boolean value = data[0][0];
            for (int j = 0; j < data[i].length; j++) {
               if ((i == j || i == data[i].length - i) && data[i][j] != value) {
                   result = false;
                   break;
               }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, true, false},
                {true, false, true, false}
        };
        System.out.println(input[0].length);
    }
}
