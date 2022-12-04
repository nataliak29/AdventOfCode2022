import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Day04 extends Day {
    static String RESOURCE = "src/main/resources/day04_input.txt";

    public Day04() {
        super();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Part1: " + new Day04().partOneAnswer(RESOURCE));
        System.out.println("Part2: "+ new Day04().partTwoAnswer(RESOURCE));
    }

    public Integer countPairsContainingAnother(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer countPairsContainingAnother = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            Integer indexOfSeparator = line.indexOf(",");
            String firstElf = line.substring(0,indexOfSeparator);
            Integer startFirstElf = Integer.valueOf(firstElf.substring(0,firstElf.indexOf("-")));
            Integer endFirstElf = Integer.valueOf(firstElf.substring(firstElf.indexOf("-")+1,firstElf.length()));
            String secondElf = line.substring(indexOfSeparator + 1,line.length());
            Integer startSecondElf = Integer.valueOf(secondElf.substring(0,secondElf.indexOf("-")));
            Integer endSecondElf = Integer.valueOf(secondElf.substring(secondElf.indexOf("-")+1,secondElf.length()));
            if (pairContainsAnother(startFirstElf, endFirstElf, startSecondElf, endSecondElf) == true){
                countPairsContainingAnother += 1;
            }
        }
        return countPairsContainingAnother;
    }

    public boolean pairContainsAnother(Integer startFirstElf,
                                       Integer endFirstElf,
                                       Integer startSecondElf,
                                       Integer endSecondElf){
        boolean flag = false;
        if ( (startFirstElf <= startSecondElf & endFirstElf >= endSecondElf) ||
                (startSecondElf <= startFirstElf & endSecondElf >= endFirstElf)){
           flag = true;
        }
        return flag;
    }



    @Override
    public String partOneAnswer(String RESOURCE) throws IOException {
        int answer =  countPairsContainingAnother(RESOURCE);
        return String.valueOf(answer);
    }

    public Integer countPairsOverlapping(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer countPairsOverlapping = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            Integer indexOfSeparator = line.indexOf(",");
            String firstElf = line.substring(0,indexOfSeparator);
            Integer startFirstElf = Integer.valueOf(firstElf.substring(0,firstElf.indexOf("-")));
            Integer endFirstElf = Integer.valueOf(firstElf.substring(firstElf.indexOf("-")+1,firstElf.length()));
            String secondElf = line.substring(indexOfSeparator + 1,line.length());
            Integer startSecondElf = Integer.valueOf(secondElf.substring(0,secondElf.indexOf("-")));
            Integer endSecondElf = Integer.valueOf(secondElf.substring(secondElf.indexOf("-")+1,secondElf.length()));
            if (pairOverlapping(startFirstElf, endFirstElf, startSecondElf, endSecondElf) == true){
                countPairsOverlapping += 1;
            }
        }
        return countPairsOverlapping;
    }

    public boolean pairOverlapping(Integer startFirstElf,
                                       Integer endFirstElf,
                                       Integer startSecondElf,
                                       Integer endSecondElf){
        boolean flag = true;
        if ( (startFirstElf > startSecondElf & endFirstElf > endSecondElf & startFirstElf > endSecondElf) ||
                (startSecondElf > startFirstElf & endSecondElf > endFirstElf & startSecondElf > endFirstElf )){
            flag = false;
        }
        return flag;
    }

    @Override
    public String partTwoAnswer(String RESOURCE) throws IOException  {
        int answer =  countPairsOverlapping(RESOURCE);;
        return String.valueOf(answer);
    }


}
