package tests;

import model.Position;
import model.Puzzle;
import model.WordSearchFileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by Connor on 2016-02-25.
 */
public class PuzzleTest {

    private Puzzle testPuzzle;
    private Puzzle testPuzzle2;
    private final static String fileName = "./data/G3Random.txt";
    private final static String fileName2 = "./data/G10Picnic.txt";

    @Before
    public void runBefore() throws IOException{
        testPuzzle = new WordSearchFileReader().parse(fileName);
    }

    @Test
    public void testFindWordSuccessUpLeft() {
        List<Position> wordPos = testPuzzle.findWord("JMR");
        assertEquals(2, wordPos.get(0).getX());
        assertEquals(2, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(0, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessUp() {
        List<Position> wordPos = testPuzzle.findWord("XER");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(2, wordPos.get(0).getY());
        assertEquals(0, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(0, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessUpRight() {
        List<Position> wordPos = testPuzzle.findWord("XMT");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(2, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(2, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessLeft() {
        List<Position> wordPos = testPuzzle.findWord("TAR");
        assertEquals(2, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(0, wordPos.get(1).getY());
        assertEquals(0, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessRight() {
        List<Position> wordPos = testPuzzle.findWord("RAT");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(0, wordPos.get(1).getY());
        assertEquals(2, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessDownLeft() {
        List<Position> wordPos = testPuzzle.findWord("TMX");
        assertEquals(2, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(0, wordPos.get(2).getX());
        assertEquals(2, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessDown() {
        List<Position> wordPos = testPuzzle.findWord("REX");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(0, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(0, wordPos.get(2).getX());
        assertEquals(2, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessDownRight() {
        List<Position> wordPos = testPuzzle.findWord("RMJ");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
        assertEquals(2, wordPos.get(2).getX());
        assertEquals(2, wordPos.get(2).getY());
    }

    @Test
    public void testFindWordSuccessTwoLetterWord() {
        List<Position> wordPos = testPuzzle.findWord("RM");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(1, wordPos.get(1).getY());
    }

    @Test
    public void testFindWordSuccessMultipleFirstLettersFirstHit() throws IOException {
        testPuzzle2 = new WordSearchFileReader().parse(fileName2);
        List<Position> wordPos = testPuzzle2.findWord("GRAP");
        assertEquals(0, wordPos.get(0).getX());
        assertEquals(0, wordPos.get(0).getY());
        assertEquals(1, wordPos.get(1).getX());
        assertEquals(0, wordPos.get(1).getY());
        assertEquals(2, wordPos.get(2).getX());
        assertEquals(0, wordPos.get(2).getY());
        assertEquals(3, wordPos.get(3).getX());
        assertEquals(0, wordPos.get(3).getY());
    }

    @Test
    public void testFindWordSuccessMultipleFirstLettersLateHit() throws IOException {
        testPuzzle2 = new WordSearchFileReader().parse(fileName2);
        List<Position> wordPos = testPuzzle2.findWord("BLAN");
        assertEquals(2, wordPos.get(0).getX());
        assertEquals(8, wordPos.get(0).getY());
        assertEquals(3, wordPos.get(1).getX());
        assertEquals(8, wordPos.get(1).getY());
        assertEquals(4, wordPos.get(2).getX());
        assertEquals(8, wordPos.get(2).getY());
        assertEquals(5, wordPos.get(3).getX());
        assertEquals(8, wordPos.get(3).getY());
    }

    @Test
    public void testFindWordFailNoLetterMatch() {
        List<Position> wordPos = testPuzzle.findWord("YCK");
        assertNull(wordPos);
    }

    @Test
    public void testFindWordFailFirstLetterMatch() {
        List<Position> wordPos = testPuzzle.findWord("MCK");
        assertNull(wordPos);
    }

    @Test
    public void testFindWordFailTwoLetterMatch() {
        List<Position> wordPos = testPuzzle.findWord("XDT");
        assertNull(wordPos);
    }

    @Test
    public void testFindWordFailTooLong() {
        List<Position> wordPos = testPuzzle.findWord("REXR");
        assertNull(wordPos);
    }

    @Test
    public void testFindWordFailMultipleFirstLettersNoHit() throws IOException {
        testPuzzle2 = new WordSearchFileReader().parse(fileName2);
        List<Position> wordPos = testPuzzle2.findWord("BKR");
        assertNull(wordPos);
    }

    @Test
    public void testFindWordFailMultipleFirstLettersMatchSomeLettersNoHit() throws IOException {
        testPuzzle2 = new WordSearchFileReader().parse(fileName2);
        List<Position> wordPos = testPuzzle2.findWord("BLAND");
        assertNull(wordPos);
    }

}
