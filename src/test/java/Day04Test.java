import junit.framework.TestCase;

import java.io.IOException;

public class Day04Test extends TestCase {
    static String RESOURCE = "src/test/resources/day04_test_input.txt";

    public void testPartOneAnswer() throws IOException {
        Day04 day04 = new Day04();
        String expectedResult = "2";
        assertEquals(expectedResult,day04.partOneAnswer(RESOURCE));

    }

    public void testPartTwoAnswer() throws IOException {
        Day04 day04 = new Day04();
        String expectedResult = "4";
        assertEquals(expectedResult,day04.partTwoAnswer(RESOURCE));

    }
}