import java.util.ArrayList;
import java.util.Arrays;

public class YearData {
    private String yearFileName;
    private String yearName;
    private String[] headers;
    private ArrayList<YearEntry> yearEntries = new ArrayList<>();

    public YearData(String yearFileName, String[] headers, ArrayList<YearEntry> yearEntries){
        setYearFileName(yearFileName);
        setHeaders(headers);
        setYearEntries(yearEntries);
        setYearName(yearFileName.substring(2,6));
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }


    public void setYearFileName(String yearFileName) {
        this.yearFileName = yearFileName;
    }

    public ArrayList<YearEntry> getYearEntries() {
        return yearEntries;
    }

    public void setYearEntries(ArrayList<YearEntry> yearEntries) {
        this.yearEntries = yearEntries;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    @Override
    public String toString() {
        return "YearData{" +
                "yearName='" + yearFileName + '\'' +
                ", headers=" + Arrays.toString(headers) +
                ", yearEntries=" + Arrays.toString(yearEntries.toArray()) +
                '}';
    }
}
