import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathModuleTest {

    @Test
    void testAdd() {
        assertEquals(5, MathModule.add(2, 3));
        assertEquals(0, MathModule.add(-2, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(3, MathModule.subtract(5, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(12, MathModule.multiply(4, 3));
    }

    @Test
    void testDivide() {
        assertEquals(5.0, MathModule.divide(10, 2), 0.0001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> MathModule.divide(10, 0));
    }

    // ТЕСТ ДЛЯ ПРОВЕРКИ ЧЁТНОСТИ (защищает от будущих ошибок/мутаций в isEven)
    @Test
    void testIsEven() {
        assertTrue(MathModule.isEven(2), "Должно быть true для положительного чётного");
        assertFalse(MathModule.isEven(3), "Должно быть false для нечётного");
        assertTrue(MathModule.isEven(0), "Должно быть true для нуля");
        assertTrue(MathModule.isEven(-4), "Должно быть true для отрицательного чётного");
        assertFalse(MathModule.isEven(-5), "Должно быть false для отрицательного нечётного");
    }
}