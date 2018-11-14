package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value * 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value * 60;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value рубли.
     * @return Евро.
     */
    public int euroToRub(int value) {
        return value / 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value рубли.
     * @return Доллары
     */
    public int dollarToRub(int value) {
        return value / 60;
    }
}