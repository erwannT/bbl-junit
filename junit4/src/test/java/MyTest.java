import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by erwann on 01/07/17.
 */
public class MyTest {

    @Test
    public void my_first_test(){
        org.junit.Assert.assertEquals(2, 1+1);
        Assert.assertThat(Arrays.asList("Junit", "TestNG"), CoreMatchers.hasItem("Junit"));
    }

    @Test(expected = NullPointerException.class)
    public void my_first_test_with_exception(){
        String value = null;
        value.split(";");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void my_first_test_with_advanced_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(CoreMatchers.containsString("Invalid age"));

        throw new IllegalArgumentException("Invalid age");
    }

    @Test(timeout = 10000)
    public void should_last_10s(){
        // too long !!!
    }

    @Rule
    public Timeout timeout = Timeout.seconds(10);

    @Test
    public void should_last_10s_advanced() throws InterruptedException {
        TimeUnit.SECONDS.sleep(15);
    }
}
