import junit.framework.TestCase;

import java.io.IOException;

public class Day03Test extends TestCase {
    static String RESOURCE = "src/test/resources/day03_test_input.txt";

    public void testPartOneAnswer() throws IOException {
        Day03 day03 = new Day03();
        String expectedResult = "157";
        assertEquals(expectedResult,day03.partOneAnswer(RESOURCE));

    }

    public void testPartTwoAnswer() throws IOException {
        Day03 day03 = new Day03();
        String expectedResult = "70";
        assertEquals(expectedResult,day03.partTwoAnswer(RESOURCE));

    }
}