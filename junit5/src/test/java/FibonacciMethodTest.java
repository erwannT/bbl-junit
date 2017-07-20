import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by erwann on 01/07/17.
 */
public class FibonacciMethodTest {

    @ParameterizedTest
    @MethodSource(names = "stringAndIntProvider")
    void testWithMultiArgMethodSource(int input, int expected) {
        Fibonacci fibo = new Fibonacci();
        assertEquals(expected, fibo.compute(input));
    }

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 2}, new int[]{4, 3}, new int[]{5, 5}, new int[]{6, 8})
                .map( prop ->  ObjectArrayArguments.create(prop[0],prop[1]));
    }
}
