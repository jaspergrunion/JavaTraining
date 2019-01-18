import java.util.Date;

public class Student {

    public int id;
    public int admit;
    public double gre;
    public double gpa;
    public int rank;
    public String status;
    public String gender;
    public String date;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", admit=" + admit +
                ", gre=" + gre +
                ", gpa=" + gpa +
                ", rank=" + rank +
                ", status='" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
