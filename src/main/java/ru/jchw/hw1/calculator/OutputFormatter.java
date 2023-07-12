package ru.jchw.hw1.calculator;

/**
 * Класс выводящий результат вычислений в определенном формате
 */
public class OutputFormatter {
    /**
     *
     * @param operationName название операции
     * @param result результат операции
     */
    public static void printResult(String operationName, double result) {
        System.out.println("Результат " + operationName + ": " + result);
    }
}
