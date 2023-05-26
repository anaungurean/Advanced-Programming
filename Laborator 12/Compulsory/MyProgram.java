package org.example;


import org.testng.annotations.Test;

public class MyProgram {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
@Test
    public static void testAddition() {
        int result = add(2, 3);
        System.out.println("Addition Test: " + result);
    }

    public static void testSubtraction() {
        int result = subtract(5, 3);
        System.out.println("Subtraction Test: " + result);
    }

    public static void testMultiplication() {
        int result = multiply(4, 5);
        System.out.println("Multiplication Test: " + result);
    }

    public static void testDivision() {
        int result = divide(10, 2);
        System.out.println("Division Test: " + result);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

