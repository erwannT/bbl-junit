import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by erwann on 03/07/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MyMockitoTest {

    @Mock
    private Fibonacci fiBoMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_be_verified() {

        //Given
        Mockito.when(fiBoMock.compute(1)).thenReturn(1);

        //When
        int compute = fiBoMock.compute(1);

        //Then
        Assert.assertEquals(1, compute);
        Mockito.verify(fiBoMock, Mockito.times(1)).compute(1);

    }
}
