import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCalcNegative {

    public static Calculator calc;


    @BeforeClass
    public static void Init() {
        calc = new Calculator();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testDivByZero() {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("На ноль делить нельзя!");
        calc.div(45, 0);
    }

    @Test
    public void testSquareExtraction() {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Извлекать корень из отрицательного числа нельзя");
        calc.square_extraction(-45);
    }

    @Test
    public void testIsPrimeNegative() {
        exception.expect(IllegalArgumentException.class);
      //  exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Простое число должно быть больше > 1");
        calc.is_prime(-2);
    }



    @Test
    public void testToFibonacciNegative() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Не реализовано для отрицательных чисел");
        calc.fibo(-456);
    }
}

