import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MyNestedTest {

    private int i = 0;

    @BeforeEach
    public void setup() {
        i = 0;
    }

    @Nested
    class NominalTest{

        @BeforeEach
        public void setup(){
            i++;
        }

        @Test
        public void test(){
            Assertions.assertEquals(1, i);
        }

    }

    @Nested
    class DecrementTest{

        @BeforeEach
        public void setup(){
            i--;
        }

        @Test
        public void test(){
            Assertions.assertEquals(-1, i);
        }

    }

    @Test
    public void test(){
        Assertions.assertEquals(0, i);
    }
}
