package model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 2016-02-25.
 */
public class WordSearchFileReader {

    private Puzzle outPuzzle;
    private List<String> grid;
    private int rows;
    private int cols;

    public WordSearchFileReader(){
        grid = new ArrayList<String>();
        rows = 0;
        cols = 0;
    }

    public Puzzle parse(String fileName) throws IOException {
        // replace this with a known encoding if possible
        Charset encoding = Charset.defaultCharset();
        File file = new File(fileName);
        handleFile(file, encoding);
        outPuzzle = new Puzzle(grid, rows, cols);
        return outPuzzle;
    }

    private void handleFile(File file, Charset encoding) throws IOException {
        try (InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in, encoding);
            // buffer for efficiency
            BufferedReader buffer = new BufferedReader(reader))
        {
            handleCharacters(buffer);
        }

    }

    private void handleCharacters(BufferedReader reader) throws IOException {
        String line;
        cols = -1;

        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("\\s","");
            for (int i = 0; i < line.length(); i++) {
                grid.add(Character.toString(line.charAt(i)));
            }
            rows = line.length() - 1;
            cols++;
        }
        reader.close();
    }
}
