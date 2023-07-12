package ru.jchw.hw1.calculator;

/**
 * Класс вычислений
 */
public class Calculator {
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Метод
     * @param num1 первое число
     * @param num2 второе число
     * @return результат
     */

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Метод деления двух чисел
     * @param num1 первое число
     * @param num2 второе число
     * @return результат деления
     */
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Деление на ноль невозможно");
            System.exit(0);
        }

        return num1 / num2;
    }
}
