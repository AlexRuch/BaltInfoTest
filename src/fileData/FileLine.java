package fileData;

/**
 * Created by ralex on 3/6/17.
 */
public class FileLine {
    private String entry_1;
    private String entry_2;
    private String entry_3;
    private int group;


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null)
            return false;

        if (!(getClass() == obj.getClass()))
            return false;
        else {
            FileLine tmp = (FileLine) obj;
            return tmp.entry_1.equals(this.entry_1) && tmp.getEntry_2().equals(this.entry_2) && tmp.entry_3.equals(entry_3);
        }
    }

    @Override
    public int hashCode() {
        int result = entry_1.hashCode();
        result = 31 * result + entry_2.hashCode();
        result = 31 * result + entry_3.hashCode();
        return result;
    }

    public String getEntry_1() {
        return entry_1;
    }

    public void setEntry_1(String entry_1) {
        this.entry_1 = entry_1;
    }

    public String getEntry_2() {
        return entry_2;
    }

    public void setEntry_2(String entry_2) {
        this.entry_2 = entry_2;
    }

    public String getEntry_3() {
        return entry_3;
    }

    public void setEntry_3(String entry_3) {
        this.entry_3 = entry_3;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
