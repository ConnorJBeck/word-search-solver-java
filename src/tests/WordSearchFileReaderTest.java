package tests;

import model.WordSearchFileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Connor on 2016-02-25.
 */
public class WordSearchFileReaderTest {

    private WordSearchFileReader testReader;
    private final static String fileName = "./data/G10Picnic.txt";

    @Before
    public void runBefore() { testReader = new WordSearchFileReader(); }


    @Test
    public void testParse() throws IOException {
        testReader.parse(fileName);
    }



}
