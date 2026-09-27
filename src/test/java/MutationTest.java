import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class MutationTest {

    private boolean isMutantKilled(Runnable test) {
        try {
            test.run();
            return false; // Мутант ВЫЖИЛ (тест не заметил ошибку)
        } catch (AssertionError | Exception e) {
            return true;  // Мутант УБИТ (тест упал на ошибке)
        }
    }

    @Test
    @DisplayName("Автоматическая проверка 5 мутантов")
    void runAutomaticMutationTesting() {
        System.out.println("ЗАПУСК АВТОМАТИЧЕСКОГО МУТАЦИОННОГО ТЕСТИРОВАНИЯ");

        // 1. Мутант 1: замена '+' на '-' в add
        BiFunction<Integer, Integer, Integer> mutantAdd = (a, b) -> a - b;
        boolean killed1 = isMutantKilled(() -> assertEquals(5, mutantAdd.apply(2, 3)));
        System.out.println("Мутант 1 (add: + -> -): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));

        // 2. Мутант 2: замена '-' на '+' в subtract
        BiFunction<Integer, Integer, Integer> mutantSubtract = (a, b) -> a + b;
        boolean killed2 = isMutantKilled(() -> assertEquals(3, mutantSubtract.apply(5, 2)));
        System.out.println("Мутант 2 (subtract: - -> +): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));

        // 3. Мутант 3: замена '*' на '/' в multiply
        BiFunction<Integer, Integer, Integer> mutantMultiply = (a, b) -> a / b;
        boolean killed3 = isMutantKilled(() -> assertEquals(12, mutantMultiply.apply(4, 3)));
        System.out.println("Мутант 3 (multiply: * -> /): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));

        // 4. Мутант 4: замена 'b == 0' на 'b != 0' в divide
        BiFunction<Integer, Integer, Double> mutantDivide = (a, b) -> {
            if (b != 0) throw new IllegalArgumentException("Division by zero");
            return (double) a / b;
        };
        boolean killed4 = isMutantKilled(() -> {
            assertThrows(IllegalArgumentException.class, () -> mutantDivide.apply(10, 0));
        });
        System.out.println("Мутант 4 (divide: == -> !=): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));

        // 5. Мутант 5: замена '0' на '1' в isEven
        java.util.function.Function<Integer, Boolean> mutantIsEven = (n) -> n % 2 == 1;
        boolean killed5 = isMutantKilled(() -> {
            assertTrue(mutantIsEven.apply(2));
            assertFalse(mutantIsEven.apply(3));
        });
        System.out.println("Мутант 5 (isEven: 0 -> 1): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));


        assertTrue(killed1 && killed2 && killed3 && killed4 && killed5,
                "Ошибка! Не все мутанты были убиты тестами.");
    }
}