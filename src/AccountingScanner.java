import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class AccountingScanner {
    private static final File dir = new File("resources");

    public MonthData scanMonthlyReport(File file){
        ArrayList<MonthEntry> monthEntries = new ArrayList<>();
        String monthDataString = readFileContentsOrNull(file.getPath());
        String[] splitMonthDataString;
        String[] splitLine;
        String[] headers;
        if (monthDataString != null) {
            splitMonthDataString = monthDataString.split("\\n");
            headers = splitMonthDataString[0].split(",");
            for (int i = 1; i < splitMonthDataString.length; i ++){
                splitLine = splitMonthDataString[i].split(",");
                MonthEntry monthEntry = new MonthEntry(splitLine[0], getBool(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
                monthEntries.add(monthEntry);
            }
            return new MonthData(file.getName(), headers, monthEntries);
        }
        return null;
    }

    public YearData scanYearlyReport(File file){
        ArrayList<YearEntry> yearEntries = new ArrayList<>();
        String yearDataString = readFileContentsOrNull(file.getPath());
        String[] splitYearDataString;
        String[] splitLine;
        String[] headers;
        if (yearDataString != null){
            splitYearDataString = yearDataString.split("\\n");
            headers = splitYearDataString[0].split(",");
            for (int i = 1; i < splitYearDataString.length; i++){
                splitLine = splitYearDataString[i].split(",");
                YearEntry yearEntry = new YearEntry(splitLine[0], Integer.parseInt(splitLine[1]),
                        getBool(splitLine[2]));
                yearEntries.add(yearEntry);
            }
            return new YearData(file.getName(),headers, yearEntries);
        }
        return null;
    }

    private String readFileContentsOrNull(String path)
    {
        try {
            return  Files.readString(Path.of(path));
            //return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public  ArrayList<MonthData> readAllMonthFiles(){
        ArrayList<MonthData> monthDataArrayList = new ArrayList<>();
        File[] files = dir.listFiles();
        ArrayList<File> monthFiles = new ArrayList<>();
        if (files != null) {
            for (File file: files){
                if (file.getName().contains("m")){
                    monthFiles.add(file);
                }
            }
            for (File file: monthFiles){
                monthDataArrayList.add(scanMonthlyReport(file));
            }
        }
        return monthDataArrayList;
    }

    public  ArrayList<YearData> readAllYearFiles(){
        ArrayList<YearData> yearDataArrayList = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null){
            for (File file: files){
                if (file.getName().contains("y")){
                    yearDataArrayList.add(scanYearlyReport(file));
                }
            }
        }
        return yearDataArrayList;
    }

    private boolean getBool(String value){
        return Boolean.parseBoolean(value);
    }
}
