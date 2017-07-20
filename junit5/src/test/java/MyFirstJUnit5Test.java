import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class MyFirstJUnit5Test {

    // cas simple : la meme qu'avant
    @Test
    @DisplayName("My first test \uD83D\uDE31")
    void myFirstTest() throws MalformedURLException {

        org.junit.jupiter.api.Assertions.assertEquals(2, 1 + 1);

        // lambda can be lazily evaluated
        assertEquals(2, 2, () -> "Failure");

    }

    @Test
    public void testWithAssertj(){
        assertThat(25).isBetween(12,45);
        assertThat(25).isCloseTo(20, Offset.offset(5));


        assertThat(Arrays.asList("JUnit", "TestNG")).contains("JUnit");
    }

    @Test
    public void testURL() throws MalformedURLException {
        assertThat(new URL("http://google.fr")).hasNoPort();
        assertThat(new URL("http://google.fr")).hasHost("google.fr");
        assertThat(new URL("http://google.fr")).hasNoUserInfo();
    }

    @Test
    public void assume() {
        // junit4 Assume.assumeFalse(true);
        assumeTrue("CI".equals(System.getenv("ENV")));
        System.out.println("execute test");
    }

    @Test
    @Disabled
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, 2);
                });

        // perform these assertions in all environments
        assertEquals("a string", "a string");
    }


    @Test
    public void testException(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }


    @Test
    public void testAssertAll(){
        assertAll("address",
                () -> assertEquals("JUnit", "JUnit1"),
                () -> assertEquals("TestNG", "TestNG"),
                () -> assertEquals("EasyMock", "Mockito")
        );
    }

    @Test
    public void timeoutNotExceeded(){
        assertTimeout(ofSeconds(5), () -> {
            TimeUnit.SECONDS.sleep(10);
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofSeconds(5), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofSeconds(2), () -> {
            TimeUnit.SECONDS.sleep(5);
        });
    }

    @Test
    void test2(){
        assertEquals("vendredi", "lundi", () -> "oh non, on est que lundi");
    }

    @Test
    @DisplayName("Avec plein d'emoji, ça ne peut que marcher \uD83D\uDC30 \uD83D\uDC31 \uD83D\uDC3C \uD83D\uDC19")
    public void shouldWorkBecauseThereAreEmoji(){

    }

    @RepeatedTest(10)
    @DisplayName("Test en répétition")
    public void isInferiorTo5(TestInfo testInfo, RepetitionInfo repetitionInfo){
        int value = 5;

        System.out.print("Test "+ testInfo.getTestMethod().get().getName() + "( " +  repetitionInfo.getCurrentRepetition() + " de " + repetitionInfo.getTotalRepetitions() +" )");
        assertThat(5).isGreaterThan(repetitionInfo.getCurrentRepetition());
    }






}

