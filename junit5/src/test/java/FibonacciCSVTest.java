import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by erwann on 01/07/17.
 */
public class FibonacciCSVTest {

    @ParameterizedTest
    @CsvSource({ "0,0","1,1", "2,1", "3,2", "4,3", "5,5", "6,8"})
    void testWithCsvSource(int input, int expected) {
        Fibonacci fibo = new Fibonacci();
        assertEquals(expected, fibo.compute(input));
    }

}
