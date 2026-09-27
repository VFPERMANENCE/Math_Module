

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathModuleTest {

    @Test
    void testAdd() {
        assertEquals(5, MathModule.add(2, 3));
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
        assertThrows(IllegalArgumentException.class, () -> MathModule.divide(1, 0));
    }

    @Test
    void testIsEven() { assertTrue(MathModule.isEven(2)); assertFalse(MathModule.isEven(3)); }
}
