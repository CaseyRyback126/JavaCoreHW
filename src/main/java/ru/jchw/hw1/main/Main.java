package ru.jchw.hw1.main;

import ru.jchw.hw1.calculator.Calculator;
import ru.jchw.hw1.calculator.OutputFormatter;

public class Main {
    public static void main(String[] args) {
        double res = Calculator.add(4,2);
        OutputFormatter.printResult("сложения", res);
        res = Calculator.subtract(4,2);
        OutputFormatter.printResult("вычитания", res);
        res = Calculator.divide(4,2);
        OutputFormatter.printResult("деления", res);
        res = Calculator.multiply(4,2);
        OutputFormatter.printResult("умножения", res);
    }
}
