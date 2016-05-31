package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by Connor on 2016-02-25.
 */
public class Solver {

    public static void main(String[] args) {

        String fileName = "./data/G3Random.txt";
        Puzzle puzzle;
        List<List<Position>> solution = new ArrayList<>();

        List<String> wordList = new ArrayList<>();
        wordList.add("JMR");
        wordList.add("DMA");
        wordList.add("XMT");
        wordList.add("PME");
        wordList.add("EMP");
        wordList.add("TMX");
        wordList.add("AMD");
        wordList.add("RMJ");

        int[] fable;


        try {
            puzzle = new WordSearchFileReader().parse(fileName);
            for (String word : wordList) {
                solution.add(puzzle.findWord(word));
            }
        } catch (IOException e){
            fail("Unable to parse file.");
        }

        for (List<Position> solutionWord : solution) {
            for (Position solutionLetter : solutionWord) {
                System.out.println(solutionLetter.toString());
            }

        }





    }
}
