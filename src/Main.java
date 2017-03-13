/**
 * Created by ralex on 3/6/17.
 */

import fileData.FileLine;
import fileData.FileReader;
import fileWrite.WriteDataToFile;

import java.io.IOException;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        fileReader.readFileData();
    }
}
