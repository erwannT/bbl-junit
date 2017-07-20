import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciArgTest {

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testFiboWithArgument(int input, int expected) {
        Fibonacci fibo = new Fibonacci();
        assertEquals(expected, fibo.compute(input));
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext context) {
            return Stream.of(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 2}, new int[]{4, 3}, new int[]{5, 5}, new int[]{6, 8})
                    .map( prop ->  ObjectArrayArguments.create(prop[0],prop[1]));
        }
    }
}
