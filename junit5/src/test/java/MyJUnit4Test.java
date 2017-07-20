import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class MyJUnit4Test {

    @Test
    public void myFirstTest(){
        org.junit.Assert.assertEquals(2, 1+1);

        Assert.assertThat(Arrays.asList("Junit", "TestNG"), CoreMatchers.hasItem("Junit"));
    }
}
