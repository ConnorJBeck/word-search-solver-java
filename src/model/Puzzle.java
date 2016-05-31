package model;

import java.util.ArrayList;
import java.util.List;


public class Puzzle {

    private List<String> grid;
    private int rows;
    private int cols;
    private List<Position> posList;
    private List<List<Position>> units;
    private String word;


    public Puzzle(List<String> grid, int rows, int cols) {
        this.grid = grid;
        this.rows = rows;
        this.cols = cols;
        posList = null;
        units = null;
    }


    // MODIFIES: this
    // EFFECTS: Find the word in the puzzle, returns to positions of each letter in the word in the puzzle
    //          If word not found, return null
    public List<Position> findWord(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        posList = new ArrayList<>();
        units = new ArrayList<>();
        this.word = word;

        String firstLetter = word.substring(0,1);
        posList = findLetterPositions(firstLetter);

        return posList;
    }

    // MODIFIES: this
    // EFFECTS: searches the puzzle for all occurrences of the given letter, sets posList to a list of each of those
    private List<Position> findLetterPositions(String letter) {

        List<Position> result;

        for (int i = 0; i <= rows; i++) {
            int currentRow = i * (cols + 1);
            for (int j = 0; j <= cols; j++) {
                String currentLetter = grid.get(currentRow + j);
                if (currentLetter.equals(letter)) {
                    result = searchAroundLetter(new Position(j, i));
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
         return null;
    }

    // MODIFIES: this
    // EFFECTS: takes a position in the puzzle, and searches the units around the position for the word
    //          returns the list of positions of letters if found, null otherwise
    private List<Position> searchAroundLetter(Position pos) {
        List<Position> tempPosList;

        makeUnits(pos);

        for (List<Position> unit : units) {
            tempPosList = searchUnit(unit);
            if (tempPosList != null) {
                return tempPosList;
            }
        }
        units.clear();
        return null;
    }

    // MODIFIES: this
    // EFFECTS: takes a list of positions in the puzzle, and compares each letter in the unit with each letter in word
    //          returns the list of positions (trimmed to length of word) if word is found in unit, else return null
    private List<Position> searchUnit(List<Position> unit) {

        if (unit.size() < word.length()) {
            return null;
        }

        Position currentPos;
        String currentWordLetter;
        String currentUnitLetter;

        for (int i = 0; i < word.length(); i++) {
            currentWordLetter = word.substring(i,i+1);
            currentPos = unit.get(i);
            int x = currentPos.getX();
            int y = currentPos.getY() * (cols + 1);
            currentUnitLetter = grid.get(x + y);
            if (!(currentUnitLetter.equals(currentWordLetter))) {
                return null;
            }
        }

        while (unit.size() > word.length()) {
            unit.remove(unit.size() - 1);
        }

        return unit;
    }

    // MODIFIES: this
    // EFFECTS: creates the eight units around a letter, starting from the letter. That is, Up-Left, Left, Down-Left
    //          Up, Down, Up-Right, Right, and Down-Right
    private void makeUnits(Position pos) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    units.add(buildUnit(i, j, pos));
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: generates a list of positions by navigating through the grid in a given direction until a boundary is
    //          reached. returns that list of positions.
    private List<Position> buildUnit(int i, int j, Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        List<Position> unit = new ArrayList<>();
        while (x >= 0 && y >= 0 && x <= rows && y <= cols) {
            unit.add(new Position(x, y));
            x = x + i;
            y = y + j;
        }

        return unit;
    }

}
