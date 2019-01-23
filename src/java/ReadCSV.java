import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    public static List toList(String fileref){
        List<Student> resultList = new ArrayList<Student>();

        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileref))) {
            reader.readLine(); // Skip first line
            while ((line = reader.readLine()) != null) {
                String[] linelist = line.split(",");
                Student student = new Student();
                for (int l = 0; l < linelist.length; l++) {
                    linelist[l] = linelist[l].replace("\"", "").trim();
                }
                student.setId(Integer.parseInt(linelist[0]));
                student.setAdmit(Integer.parseInt(linelist[1]));
                student.setGre(Double.parseDouble(linelist[2]));
                student.setGpa(Double.parseDouble(linelist[3]));
                student.setRank(Integer.parseInt(linelist[4]));
                student.setStatus(linelist[5]);
                student.setGender(linelist[6]);
                student.setDate(linelist[7]);
                resultList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    // Method to print list of n elements of list
    public static void printN(List<Student> data, int n){
        for (int r = 0; r < n; r++) {
            System.out.println(data.get(r));
        }
        System.out.println();
    }

    // Method to print full list - this is how default values are handled
    public static void printN(List<Student> data){
        printN(data, data.size());
    }

}
