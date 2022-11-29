import junit.framework.TestCase;

public class Day01Test extends TestCase {

    public void testMeasurementIncrease(){
        Day01 day01 = new Day01();
        String expectedResult = "Test";
        String expectedResult2 = "Test2";
        assertEquals(expectedResult,day01.partOneAnswer());
        assertEquals(expectedResult2,day01.partTwoAnswer());
    }
}