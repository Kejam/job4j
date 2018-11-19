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
        boolean value = data[0][0];
        boolean revetValue = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (data[0].length != data.length) { //Если массив не квадратный, то у него нет явных диагоналей.
                result = false;
                break;
            }
            for (int j = 0; j < data[i].length; j++) {
               if (data[i][i] != value) {
                   result = false;
                   break;
               }
               if (data[i][data[i].length - i - 1] != revetValue) {
                   result = false;
                   break;
               }
            }
        }
        return result;
    }
}
