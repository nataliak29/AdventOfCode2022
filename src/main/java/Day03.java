import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Day03 extends Day {
    static String RESOURCE = "src/main/resources/day03_input.txt";

    public Day03() {
        super();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Part1: " + new Day03().partOneAnswer(RESOURCE));
        System.out.println("Part2: "+ new Day03().partTwoAnswer(RESOURCE));
    }

    public Integer sumOfPriorities(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer sumOfPriorities = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            Integer lineLength = line.length();
            String firstCompartment = line.substring(0,lineLength/2);
            String secondCompartment = line.substring(lineLength/2, lineLength);
            Integer thisBackpackPriority = backpackPriority(firstCompartment,secondCompartment);
            sumOfPriorities += thisBackpackPriority;
        }
        return sumOfPriorities;
    }

    public Integer backpackPriority(String firstCompartment,String secondCompartment) {
        Integer backpackPriority = 0;
        HashMap<String,String> itemFrequency = new HashMap<>();
        itemFrequency = recordFrequency(itemFrequency,firstCompartment,"first");
        itemFrequency = recordFrequency(itemFrequency,secondCompartment,"second");
        for (String key: itemFrequency.keySet()){
            if (itemFrequency.get(key).equals("both")) {
                backpackPriority += letterPriority(key);
            }
        }
        return backpackPriority;
    }
    public Integer letterPriority(String letter){
        Integer letterPriority = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Character c = letter.charAt(0);

        if (Character.isLowerCase(c)){
            Integer orderOfLetter = alphabet.indexOf(c) + 1;
            letterPriority = orderOfLetter;
        }
        else {
            Integer orderOfLetter = alphabet.indexOf(Character.toLowerCase(c)) + 1;
            letterPriority = orderOfLetter + 26;
        }
        return letterPriority;
    }

    public HashMap<String,String> recordFrequency(HashMap<String,String> frequencyMap,
                                                  String input,
                                                  String inputName){
        for (int i = 0; i < input.length(); i++){
            String thisItem = input.substring(i,i+1);
            if ( !frequencyMap.containsKey(thisItem)){
                frequencyMap.put(thisItem,inputName);
            }
            if ((frequencyMap.containsKey(thisItem)) && !frequencyMap.get(thisItem).equals(inputName))
            {
                frequencyMap.put(thisItem,"both");
            }
        }
        return frequencyMap;
    }


    @Override
    public String partOneAnswer(String RESOURCE) throws IOException {
        int answer =  sumOfPriorities(RESOURCE);
        return String.valueOf(answer);
    }


    public Integer sumOfPrioritiesForGroups(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer sumOfPriorities = 0;
        Integer lineCounter = 0;
        String firstElfItems = null;
        String secondElfItems = null;
        String thirdElfItems = null;
        Integer thisGroupPriority = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();

            lineCounter += 1;
            if (lineCounter % 3 == 1){
                firstElfItems = line;
                thisGroupPriority = 0;
            }
            if (lineCounter % 3 == 2){
                secondElfItems = line;
            }
            if (lineCounter % 3 == 0){
                thirdElfItems = line;
                thisGroupPriority = groupPriority(firstElfItems,secondElfItems,thirdElfItems);
                sumOfPriorities += thisGroupPriority;
            }
        }
        return sumOfPriorities;
    }

    public Integer groupPriority(String firstElfItems,String secondElfItems, String thirdElfItems) {
        Integer groupPriority = 0;
        HashMap<String,String> itemFrequency = new HashMap<>();
        itemFrequency = recordFrequencyForThree(itemFrequency,firstElfItems,"first");
        itemFrequency = recordFrequencyForThree(itemFrequency,secondElfItems,"second");
        itemFrequency = recordFrequencyForThree(itemFrequency,thirdElfItems,"third");

        for (String key: itemFrequency.keySet()){
            if (itemFrequency.get(key).equals("first second third")) {
                groupPriority += letterPriority(key);
            }
        }
        return groupPriority;
    }

    public HashMap<String,String> recordFrequencyForThree(HashMap<String,String> frequencyMap,
                                                  String input,
                                                  String inputName){
        for (int i = 0; i < input.length(); i++){
            String thisItem = input.substring(i,i+1);
            if ( (!frequencyMap.containsKey(thisItem)) || ((frequencyMap.containsKey(thisItem))
                    && frequencyMap.get(thisItem).equals(inputName))){
                frequencyMap.put(thisItem,inputName);
            }
            if ((frequencyMap.containsKey(thisItem))
                    && !frequencyMap.get(thisItem).contains(inputName))
            {
                frequencyMap.put(thisItem,frequencyMap.get(thisItem) + " " + inputName);
            }

        }
        return frequencyMap;
    }
    @Override
    public String partTwoAnswer(String RESOURCE) throws IOException  {
        int answer =  sumOfPrioritiesForGroups(RESOURCE);;
        return String.valueOf(answer);
    }


}
