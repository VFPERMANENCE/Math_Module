public class MathModule {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return (double) a / b;
    }

    public static boolean isEven(int n) {
        // return n % 2 == 1; // Ошибка из Части 1 (проверка на нечётность)
        return n % 2 == 0; // Исправление для Части 2
    }
}