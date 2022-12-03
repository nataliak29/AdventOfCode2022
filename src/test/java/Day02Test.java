import junit.framework.TestCase;

import java.io.IOException;

public class Day02Test extends TestCase {
    static String RESOURCE = "src/test/resources/day02_test_input.txt";

    public void testPartOneAnswer() throws IOException {
        Day02 day02 = new Day02();
        String expectedResult = "15";
        assertEquals(expectedResult,day02.partOneAnswer(RESOURCE));

    }

    public void testPartTwoAnswer() throws IOException {
        Day02 day02 = new Day02();
        String expectedResult = "12";
        assertEquals(expectedResult,day02.partTwoAnswer(RESOURCE));

    }
}