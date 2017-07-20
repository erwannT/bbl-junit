import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class DynamicFiboTests {


    @TestFactory
    Stream<DynamicTest> dynamicTestsFibo() {

        Fibonacci fibo = new Fibonacci();
        return Stream.of(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 2}, new int[]{4, 3}, new int[]{5, 5}, new int[]{6, 8})
                .map(
                        input ->
                                dynamicTest("Compute fibonacci for " + input[0], () -> assertEquals(input[1], fibo.compute(input[0])))
                );

    }


}