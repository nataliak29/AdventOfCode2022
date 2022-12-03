import junit.framework.TestCase;

import java.io.IOException;

public class Day01Test extends TestCase {
    static String RESOURCE = "src/test/resources/day01_test_input.txt";

    public void testPartOneAnswer() throws IOException {
        Day01 day01 = new Day01();
        String expectedResult = "24000";
        assertEquals(expectedResult,day01.partOneAnswer(RESOURCE));

    }

    public void testPartTwoAnswer() throws IOException {
        Day01 day01 = new Day01();
        String expectedResult = "41000";
        assertEquals(expectedResult,day01.partTwoAnswer(RESOURCE));

    }
}