package fileData;

import fileSort.SortFileData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by ralex on 3/6/17.
 */
public class FileReader {

    private SortFileData sortFileData = new SortFileData();

    public void readFileData() throws IOException {
        String line = "";
        String[] nextLine;
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("test.csv"));
        while ((line = bufferedReader.readLine()) != null) {
            nextLine = line.split(";");
            if (nextLine.length == 3) {
                FileLine fileLine = new FileLine();
                fileLine.setEntry_1(nextLine[0]);
                fileLine.setEntry_2(nextLine[1]);
                fileLine.setEntry_3(nextLine[2]);
                sortFileData.checkUnique(fileLine);
            }
        }
        sortFileData.sortFileLineMap();
    }
}
