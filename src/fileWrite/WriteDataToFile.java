package fileWrite;

import fileData.FileLine;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ralex on 3/6/17.
 */
public class WriteDataToFile {

    private FileWriter fileWriter;
    private int i = 0;

    public void writeGroupToFile(Integer group) throws IOException {
        fileWriter = new FileWriter("./out.txt", true);
        fileWriter.write("GROUP: " + group);
        fileWriter.append('\n');
        fileWriter.flush();
    }

    public void writeLineToFile(FileLine fileLine) throws IOException {
        fileWriter = new FileWriter("./out.txt", true);
        fileWriter.append(fileLine.getEntry_1()).append(";")
                .append(fileLine.getEntry_2()).append(";")
                .append(fileLine.getEntry_3())
                .append('\n');
        fileWriter.flush();
    }

}
