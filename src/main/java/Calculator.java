import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;

public class Calculator  {
    private static final Logger log = Logger.getLogger(Calculator.class);

    public double add(double first, double second) {log.info("Введенные значения :"+ first + "+" + second + "=" + (first+second));

        return first + second;
    }

    public double minus(double first, double second) { log.info("Введенные значения :"+ first + "-" + second + "=" + (first-second));

            return first - second;

    }

    public double div(double first, double second) {

        if (second == 0){log.error("Делить на ноль нельзя, введеное число :"+ first + "/" + second);
            throw new ArithmeticException("На ноль делить нельзя!");}
        else{log.info(" Введеные значения:" + first + "*" + second +"=" + first/second);
        return first / second;}
    }

    public double multi(double first, double second) {log.info(" Введеные значения:" + first + "*" + second +"=" + (first*second));
        return first * second;
    }

    public double square_extraction(double first) {
        if (first < 0) {log.error("Простое число должно быть больше >1, введеное число :"+ first);
            throw new ArithmeticException("Извлекать корень из отрицательного числа нельзя!");
        }
        else {log.info("Введенное число для извлечения корня " +first +" полученное число " +Math.sqrt(first));
        return Math.sqrt(first);
        }
    }

    public boolean is_prime(double first) {
//try {
        if (first < 0) {throw new IllegalArgumentException("Простое число должно быть больше > 1");}
log.error("Простое число должно быть больше >1, введеное число :"+ first);

        if (first == 0)  { log.error("0 не является простым числом, введеное число :"+ first);
            return false;
        }

        if (first == 1) {log.error("1 не является простым числом, введеное число :"+ first);
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(first); i++) {

                if (first % i == 0) { log.error("Не является простым числом, введеное число :"+ first);
                    return false;
                }
            }
            return true;
        }


    }

        public BigDecimal fibo ( int first){
            if (first < 0){log.error(" Получение н-ого числа Фибоначи,не реализовано для отрицательных чисел, введеное число: " + first);
                throw new IllegalArgumentException("Не реализовано для отрицательных чисел");}

        /** F n = F n+1 - F n+2 или иначе можно так: F -n = (-1) n+1 Fn (Для получения положительных и отрицательных чисел)
        if ( first<0 ){

            BigDecimal[] result = new BigDecimal[first];
            result[0] = new BigDecimal(1);
            result[1] = new BigDecimal(1);

            for (int j = 0; j > first; j--) {
                result[j] = result[j + 2].add(result[j + 1]);
            }
            return result[first + 1];
        }*/
        if  (first == 0) {
            return new BigDecimal(0);
        }

        if (first < 3) {
            return new BigDecimal(1);
        }
        BigDecimal[] result = new BigDecimal[first];
        result[0] = new BigDecimal(1);
        result[1] = new BigDecimal(1);
        for (int j = 2; j < first; j++) {
            result[j] = result[j - 2].add(result[j - 1]);
        }
        log.info("Число фибоначи  " + (result[first-1])     + " от числа "  + first  );

        return result[first - 1];


    }

        public static int summarizeNumberRow ( int[] row){
        log.info("Метод получения числа из массива"+Arrays.toString(row));
        return Arrays.stream(row)
                .sum();


    }


}
























