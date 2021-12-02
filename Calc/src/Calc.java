package com.company;

import static java.lang.Double.NaN;

public class Calc {

    public static double calc(double x, double y, char operation) {
        switch (operation) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                if (y == 0) {
                    return NaN;
                }
                return x / y;
            default:
                return NaN;
        }
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Nan!");
            return;
        }

        try {
            double x = Double.parseDouble(args[0]);
            char operation = args[1].charAt(0);
            double y = Double.parseDouble(args[2]);
            System.out.println("Answer: " + calc(x, y, operation));
        } catch (Exception ex) {
            System.out.println("Nan!");
        }
    }
}