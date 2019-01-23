import java.util.Date;

public class Student {

    // Declare object fields
    private int id;
    private int admit;
    private double gre;
    private double gpa;
    private int rank;
    private String status;
    private String gender;
    private String date;

    // Getters
    public int getId() {
        return id;
    }

    public int getAdmit() {
        return admit;
    }

    public double getGre() {
        return gre;
    }

    public double getGpa() {
        return gpa;
    }

    public int getRank() {
        return rank;
    }

    public String getStatus() {
        return status;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAdmit(int admit) {
        this.admit = admit;
    }

    public void setGre(double gre) {
        this.gre = gre;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Override toString for printing
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
