import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day02 extends Day {
    static String RESOURCE = "src/main/resources/day02_input.txt";

    public Day02() {
        super();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Part1: " + new Day02().partOneAnswer(RESOURCE));
        System.out.println("Part2: "+ new Day02().partTwoAnswer(RESOURCE));
    }

    public Integer myFinalScore(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer finalScore = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String opponentMove = String.valueOf(line.charAt(0));
            String myMove = String.valueOf(line.charAt(2));
            Integer thisGameScore = myScore(opponentMove,myMove);
            finalScore += thisGameScore;
        }
        return finalScore;
    }

    public Integer myScore(String opponentMove, String myMove) {
        Integer myScore = 0;
        HashMap<String,String> opponentDecrypt = new HashMap<>();
        opponentDecrypt.put("A", "Rock");
        opponentDecrypt.put("B","Paper");
        opponentDecrypt.put("C","Scissors");
        HashMap<String,String> myDecrypt = new HashMap<>();
        myDecrypt.put("X", "Rock");
        myDecrypt.put("Y","Paper");
        myDecrypt.put("Z","Scissors");
        HashMap<String,Integer> moveValue = new HashMap<>();
        moveValue.put("Rock",1);
        moveValue.put("Paper",2);
        moveValue.put("Scissors",3);
        String opponentDecryptMove = opponentDecrypt.get(opponentMove);
        String myDecryptMove = myDecrypt.get(myMove);
        myScore += moveValue.get(myDecryptMove);
        if (opponentDecryptMove == myDecryptMove){
            myScore += 3;
        }
        if ((myDecryptMove == "Paper" && opponentDecryptMove == "Rock") ||
                (myDecryptMove == "Rock" && opponentDecryptMove == "Scissors") ||
                (myDecryptMove == "Scissors" && opponentDecryptMove == "Paper")) {
            myScore += 6;
        }
        return myScore;
    }


    @Override
    public String partOneAnswer(String RESOURCE) throws IOException {
        int answer =  myFinalScore(RESOURCE);
        return String.valueOf(answer);
    }

    public Integer myFinalScoreCorrected(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Integer finalScore = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String opponentMove = String.valueOf(line.charAt(0));
            String gameResult = String.valueOf(line.charAt(2));
            Integer thisGameScore = myScoreCorrected(opponentMove,gameResult);
            finalScore += thisGameScore;
        }
        return finalScore;
    }


    public Integer myScoreCorrected(String opponentMove, String gameResult) {
        Integer myScore = 0;
        HashMap<String,Integer> gameResultValue = new HashMap<>();
        gameResultValue.put("X", 0);
        gameResultValue.put("Y",3);
        gameResultValue.put("Z",6);
        myScore += gameResultValue.get(gameResult);

        HashMap<String,String> opponentDecrypt = new HashMap<>();
        opponentDecrypt.put("A", "Rock");
        opponentDecrypt.put("B","Paper");
        opponentDecrypt.put("C","Scissors");
        String opponentDecryptMove = opponentDecrypt.get(opponentMove);

        HashMap<String,Integer> moveValue = new HashMap<>();
        moveValue.put("Rock",1);
        moveValue.put("Paper",2);
        moveValue.put("Scissors",3);
        String myMove = null;

        if (gameResult.equals("Y")){
            myMove = opponentDecryptMove;
        }
        if ((opponentDecryptMove.equals("Rock") && gameResult.equals("X")) ||
                (opponentDecryptMove.equals("Paper") && gameResult.equals("Z"))){
            myMove = "Scissors";
        }
        if ((opponentDecryptMove.equals("Rock") && gameResult.equals("Z")) ||
                (opponentDecryptMove.equals("Scissors") && gameResult.equals("X"))){
            myMove = "Paper";
        }
        if ((opponentDecryptMove.equals("Paper") && gameResult.equals("X")) ||
                (opponentDecryptMove.equals("Scissors") && gameResult.equals("Z"))){
            myMove = "Rock";
        }

        myScore += moveValue.get(myMove);
        return myScore;
    }

    @Override
    public String partTwoAnswer(String RESOURCE) throws IOException  {
        int answer =  myFinalScoreCorrected(RESOURCE);;
        return String.valueOf(answer);
    }


}
