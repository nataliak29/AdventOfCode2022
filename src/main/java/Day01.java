import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day01 extends Day {
    static String RESOURCE = "src/main/resources/day01_input.txt";

    public Day01() {
        super();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Part1: " + new Day01().partOneAnswer(RESOURCE));
        System.out.println("Part2: "+ new Day01().partTwoAnswer(RESOURCE));
    }

    public Integer largestCaloriesCount(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer largestCaloriesCount = 0;
        Integer largestCaloriesCountElfOrder = 0;
        Integer currentCaloriesCount = 0;
        Integer currentElfOrder = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if (!line.trim().isEmpty()) {
                Integer itemCalories = parseInt(line);
                currentCaloriesCount += itemCalories;
            } else {
                currentElfOrder += 1;
                if (largestCaloriesCount <= currentCaloriesCount) {
                    largestCaloriesCount = currentCaloriesCount;
                    largestCaloriesCountElfOrder = currentElfOrder;
                }
                currentCaloriesCount = 0;
            }
        }
        return largestCaloriesCount;
    }

    @Override
    public String partOneAnswer(String RESOURCE) throws IOException {
        int answer =  largestCaloriesCount(RESOURCE);
        return String.valueOf(answer);
    }


    public Integer largestThreeCaloriesCount(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer largestCaloriesCount = 0;
        Integer secondLargestCaloriesCount = 0;
        Integer thirdLargestCaloriesCount = 0;
        Integer currentCaloriesCount = 0;
        Integer currentElfOrder = 0;
        while(scan.hasNextLine()) {
            if (currentElfOrder == 1){
                secondLargestCaloriesCount =  currentCaloriesCount;
                thirdLargestCaloriesCount = currentCaloriesCount;
            }
            String line = scan.nextLine();
            if (!line.trim().isEmpty() && scan.hasNextLine() ) {
                Integer itemCalories = parseInt(line);
                currentCaloriesCount += itemCalories;
            } else {
                currentElfOrder += 1;
                if (largestCaloriesCount <= currentCaloriesCount) {
                    thirdLargestCaloriesCount = secondLargestCaloriesCount;
                    secondLargestCaloriesCount = largestCaloriesCount;
                    largestCaloriesCount = currentCaloriesCount;
                }
                if (currentCaloriesCount < largestCaloriesCount &&
                 currentCaloriesCount >= secondLargestCaloriesCount) {
                    thirdLargestCaloriesCount = secondLargestCaloriesCount;
                    secondLargestCaloriesCount = currentCaloriesCount;
                }
                if (currentCaloriesCount < secondLargestCaloriesCount &&
                        currentCaloriesCount >= thirdLargestCaloriesCount) {
                    thirdLargestCaloriesCount = currentCaloriesCount;
                }
                currentCaloriesCount = 0;
            }
        }
        return largestCaloriesCount + secondLargestCaloriesCount + thirdLargestCaloriesCount ;
    }

    @Override
    public String partTwoAnswer(String RESOURCE) throws IOException  {
        int answer =  largestThreeCaloriesCount(RESOURCE);
        return String.valueOf(answer);
    }


}
