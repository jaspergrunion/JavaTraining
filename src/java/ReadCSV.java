import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    public static String[][] toStringArray(String fileref) {

        ArrayList<String[]> resultList = new ArrayList<String[]>();

        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileref))) {
            while ((line = br.readLine()) != null) {
                String[] linelist = line.split(",");
                for (int l = 0; l < linelist.length; l++) {
                    linelist[l] = linelist[l].replace("\"", "").trim();
                }
                resultList.add(linelist);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] resultArray = new String[resultList.size()][];
        resultList.toArray(resultArray);

        return resultArray;
    }

    public static void printRows(String[][] data, int nrows){
        for (int r = 0; r <  nrows + 1; r++) {
            for (int c = 0; c < data[0].length; c++) {
                System.out.print(String.format("%-20s", data[r][c]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList toArrayList(String fileref){
        ArrayList<Student> resultList = new ArrayList<Student>();

        String line = "";
        int line_number = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileref))) {
            while ((line = br.readLine()) != null) {
                if (line_number == 0) {
                    continue;
                } else {
                    String[] linelist = line.split(",");
                    Student student = new Student();
                    for (int l = 0; l < linelist.length; l++) {
                        linelist[l] = linelist[l].replace("\"", "").trim();
                    }
                    student.id = Integer.parseInt(linelist[0]);
                    student.admit = Integer.parseInt(linelist[1]);
                    student.gre = Double.parseDouble(linelist[2]);
                    student.gpa = Double.parseDouble(linelist[3]);
                    student.rank = Integer.parseInt(linelist[4]);
                    student.status = linelist[5];
                    student.gender = linelist[6];
                    student.date = linelist[7];
//                    System.out.println(student.gre);
                    resultList.add(student);
                }
                line_number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
