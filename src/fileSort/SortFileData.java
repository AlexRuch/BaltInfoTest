package fileSort;

import fileData.FileLine;
import fileWrite.WriteDataToFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by ralex on 3/6/17.
 */


public class SortFileData {

    private Map<FileLine, Integer> fileLineMap = new LinkedHashMap<>();
    private Map<Integer, Integer> groupCounter = new LinkedHashMap<>();
    private FileLine tempFileLine;
    private WriteDataToFile writeDataToFile = new WriteDataToFile();
    int i = 1;


    public void checkUnique(FileLine fileLine) {
        boolean check = false;

        if (!fileLineMap.containsKey(fileLine)) {
            if (fileLineMap.isEmpty()) {
                fileLine.setGroup(1);
                fileLineMap.put(fileLine, 1);
            } else {
                for (Map.Entry<FileLine, Integer> entryMap : fileLineMap.entrySet()) {
                    if ((fileLine.getEntry_1().equals(entryMap.getKey().getEntry_1()) && !fileLine.getEntry_1().equals("\"\"") && !entryMap.getKey().getEntry_1().equals("\"\""))
                            || (fileLine.getEntry_2().equals(entryMap.getKey().getEntry_2()) && !fileLine.getEntry_2().equals("\"\"") && !entryMap.getKey().getEntry_2().equals("\"\""))
                            || (fileLine.getEntry_3().equals(entryMap.getKey().getEntry_3()) && !fileLine.getEntry_3().equals("\"\"") && !entryMap.getKey().getEntry_3().equals("\"\""))) {
                        tempFileLine = fileLine;
                        tempFileLine.setGroup(entryMap.getValue());
                        check = true;
                    } else {
                        tempFileLine = fileLine;
                    }
                }
                if (!check) {
                    i++;
                    tempFileLine.setGroup(i);
                }
            }

        } else {
            System.out.println("COPY");
        }
        if (tempFileLine != null) {
            fileLineMap.put(tempFileLine, tempFileLine.getGroup());
        }
    }

    public void sortFileLineMap() throws IOException {
        for (Map.Entry<FileLine, Integer> entry : fileLineMap.entrySet()) {
            if (groupCounter.containsKey(entry.getValue())) {
                groupCounter.put(entry.getValue(), groupCounter.get(entry.getValue()) + 1);
            } else {
                groupCounter.put(entry.getValue(), 1);
            }
        }

        List<Map.Entry<Integer, Integer>> tempListMapCounter = new LinkedList<>(groupCounter.entrySet());
        Collections.sort(tempListMapCounter, (o1, o2) -> (o1.getValue().compareTo(o2.getValue())));

        Collections.reverse(tempListMapCounter);

        for (Map.Entry<Integer, Integer> entry : tempListMapCounter) {
            writeDataToFile.writeGroupToFile(entry.getKey());
            for (Map.Entry<FileLine, Integer> entryMap : fileLineMap.entrySet()) {
                if (Objects.equals(entry.getKey(), entryMap.getValue())) {
                    writeDataToFile.writeLineToFile(entryMap.getKey());
                }
            }
        }
    }
}
