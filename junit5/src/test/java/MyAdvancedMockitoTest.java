import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;


@ExtendWith(MockitoExtension.class)
public class MyAdvancedMockitoTest {

    @Mock
    private Fibonacci fiBoMock;


    @BeforeEach
    public void init(@Mock Fibonacci fiboMock){
        Mockito.when(fiboMock.compute(1)).thenReturn(1);
    }

    @Test
    public void should_be_verified() {

        //Given
        Mockito.when(fiBoMock.compute(1)).thenReturn(1);

        //When
        int compute = fiBoMock.compute(1);

        //Then
        Assertions.assertEquals(1, compute);
        Mockito.verify(fiBoMock, Mockito.times(1)).compute(1);

    }

}
