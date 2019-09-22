

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberRowSupplier.class)
public class TestCalcPozitive {

    public static Calculator calc;
    public static NumberRowSupplier calc2;
    //   private static final int TIMEOUT_FOR_ISPRIME = 100;


    @BeforeClass
    public static void Init() {
        calc = new Calculator();
    }

    //public static void Init2() {
    //     calc2 = new NumberRowSupplier();
    //   }

    @Test
    public void testAddition_additionCheckResult() {

        double actual = calc.add(2.5d, 5d);

        assertEquals(7.5d, actual, 0.01);

        double actual2 = calc.add(-27.5d, -5d);

        assertEquals(-32.5d, actual2, 0.01);


    }

    @Test
    public void testSubtraction_subtractionCheckResult() {

        double actual = calc.minus(4.5d, 5d);

        assertEquals(-0.5d, actual, 0.01);

        double actual2 = calc.minus(453d, 53.5d);

        assertEquals(399.5d, actual2, 0.01);

    }

    @Test
    public void testDivision_divisionCheckResult() {

        double actual = calc.div(-20.5d, -1d);

        //Exception is thrown "Can't devide by zero!"
        //double actual = calc.div(20.5d, 0d);

        assertEquals(20.5d, actual, 0.01);


        double actual1 = calc.div(20.5d, 1d);
        assertEquals(20.5d, actual1, 0.01);


    }

    @Test
    public void testMultiplication_multiplicationCheckResult() {

        double actual = calc.multi(-20d, -2d);

        assertEquals(40d, actual, 0.01);

        double actual2 = calc.multi(20d, 2d);

        assertEquals(40d, actual2, 0.01);

        double actual3 = calc.multi(57d, 0d);

        assertEquals(0d, actual3, 0.01);

    }

    @Test
    public void testSquare_Extraction() {
        double actual = calc.square_extraction(375.5d);

        assertEquals(19.3778224d, actual, 0.01);
    }


    @Test
    public void testFibonacci() {

        BigDecimal actual = new BigDecimal("1");
        Assert.assertEquals(actual, calc.fibo(1));


        BigDecimal actual0 = new BigDecimal("1");
        Assert.assertEquals(actual0, calc.fibo(2));


        BigDecimal actual1 = new BigDecimal("7540113804746346429");
        Assert.assertEquals(actual1, calc.fibo(92));


        BigDecimal actual2 = new BigDecimal("497307396188898807131503486647178255890061659772976965454458975169527017294027706862807765401189253711316368502706160464099788908414618365227045003478122202833991516361313407194047833564766337836766081");
        Assert.assertEquals(actual2, calc.fibo(962));


        BigDecimal actual3 = new BigDecimal("0");
        Assert.assertEquals(actual3, calc.fibo(0));

        //С отрицательными числам не реализовал
/*
        BigDecimal actual5 = new BigDecimal("-497307396188898807131503486647178255890061659772976965454458975169527017294027706862807765401189253711316368502706160464099788908414618365227045003478122202833991516361313407194047833564766337836766081");
        Assert.assertEquals(actual5, calc.fibo(-962));
*/
    }


    @Test
    public void testRowSupplier() {
        /**   private method*/
        NumberRowSupplier spySupplier = PowerMockito.spy(new NumberRowSupplier());
        try {
            PowerMockito.when(spySupplier, "summarize_row").thenReturn(new int[]{70, 8, 0});
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(78, Calculator.summarizeNumberRow(spySupplier.summarize_row2()));


/**   static method*/
        PowerMockito.mockStatic(NumberRowSupplier.class);
        PowerMockito.when(NumberRowSupplier.summarize_row1()).thenReturn(new int[]{10, 10, 10});
        assertEquals(30, Calculator.summarizeNumberRow(NumberRowSupplier.summarize_row1()));

/**   final method*/
        NumberRowSupplier mockSupplier = Mockito.mock(NumberRowSupplier.class);
        Mockito.when(mockSupplier.summarize_row2()).thenReturn(new int[]{1, 7, 70});
        assertEquals(78, Calculator.summarizeNumberRow(mockSupplier.summarize_row2()));

    }
}