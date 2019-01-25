import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        // Primitive types
        int myInt1 = 25; // int is 32 bit so range is -2^32 to 2^32 - 1, for 64 bit integer use long instead of int
        int myInt2 = 12;
        int myInt3 = 2*myInt2 + 1;
        double myDouble = 37.2; // 64 bit floating point, float type is 32 bit and not commonly used
        boolean myBool = true; // false is other value
        // other primitive types: byte, short, char

        // Math and comparisons
        System.out.println("Integer division: " + myInt1 + "/" + myInt2 + " = " + myInt1/myInt2); // division with no remainder
        System.out.println("Decimal division: 25/12.0 = " + 25/12.0); // adding decimal to one argument casts to double
        System.out.println(myInt1 + " > " + myInt2 + "? " + (myInt1 > myInt2)); // comparisons yield boolean values
        System.out.println(myInt1 + " = " + myInt3 + "? " + (myInt1 == myInt3)); // Use == for numeric equality
        System.out.println(myDouble + "/2 = " + myDouble/2);
        if (myBool){
            System.out.println("Result was true");
        }
        System.out.println();

        // Popular constants and exponentiation
        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);
        System.out.println("Random: " + Math.random()); // No seed - to generate random with seed use a generator
        System.out.println("Exponent: " + myInt1 + "^3 = " + Math.pow(myInt1, 3));
        System.out.println();

        /*
        // Strings - not a primitive type and hence String with a capital S
        String myString1 = "John Smith";
        String myString2 = "John Smyth";

        boolean stringsEqual = myString1.equals(myString2); // == will compare memory locations not values
        System.out.println("Is '" + myString1 + "' equal to '" + myString2 + "'? " + stringsEqual);
        System.out.println("Case insensitive: 'JOHN' equal to 'john'? " + "JOHN".equalsIgnoreCase("john"));

        boolean subsEqual = myString1.substring(0,4).equals(myString2.substring(0,4));
        System.out.println("Substring compare: " + subsEqual);
        System.out.println();

        // Dates
        Date currentDate = new Date();
        System.out.println("Current date: " + currentDate);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Formatted date: " + fmt.format(currentDate));
        System.out.println();

        // Numeric arrays
        double[] numArray1 = {1.2, 3.5, 7.4, 9.2, 17.9, 22.8};
        double[] numArray2 = {2.4, 3.7, 7.4, 12.4, 17.9, 30.8};

        System.out.println("Length of numArray1: " + numArray1.length);
        System.out.println("numArray1: " + numArray1);
        System.out.println("numArray2: " + numArray2);

        for (int i = 0; i < numArray1.length; i++) {
            System.out.print(numArray1[i] + " ");
        }
        System.out.println();

        boolean[] arrayEqual = new boolean[numArray1.length];
        for (int i = 0; i < numArray1.length; i++) {
            arrayEqual[i] = (numArray1[i] == numArray2[i]);
        }
        for (boolean element : arrayEqual) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();

        // String arrays
        String[] stooges= {"Larry", "Moe", "Curly"};

        for (String name : stooges ) {
            System.out.println(name);
        }
        System.out.println();

        // Array list - similar to list in other languages
        List<String> starWarsList = new ArrayList<>();

        starWarsList.add("Luke");
        starWarsList.add("Leia");
        starWarsList.add("Darth");
        starWarsList.add("Rey");
        System.out.println(starWarsList);

        starWarsList.remove("Darth");
        System.out.println(starWarsList);
        starWarsList.add("Poe");
        System.out.println(starWarsList);
        starWarsList.remove(0);
        System.out.println(starWarsList);

        for(String name : starWarsList){
            System.out.println(name);
        }
        System.out.println();

        // Create list of data objects from csv file
        String fileref = "/Users/jlgunnin/IdeaProjects/JavaTraining/student_data.csv";

        List<Student> studentList = ReadCSV.toList(fileref);
        ReadCSV.printN(studentList, 10);
        // ReadCSV.printN(studentList); // This prints out the entire list of objects

        // Rolling two dice and tabulating the distribution with a map object
        int num_sides = 6;
        int num_rolls = 1000;
        String[] rolls = new String[num_rolls];
        for (int i = 0; i < num_rolls; i++) {

            int dice1 = 1 + (int) (Math.random()*num_sides);
            int dice2 = 1 + (int) (Math.random()*num_sides);
            int total = dice1 + dice2;
            String totalStr;
            if (total < 10){
                totalStr = "0" + Integer.toString(total);
            } else {
                totalStr = Integer.toString(total);
            }
            rolls[i] = totalStr;
        }
        System.out.println();
        FreqCounts.dist(rolls);

        // External dependency example - use build.gradle and gradle.properties files to include
        // Descriptive statistics from Apache commons math
        DescriptiveStatistics stats = new DescriptiveStatistics();

        for (Student student: studentList) {
            stats.addValue(student.getGre());
        }

        double n = stats.getN();
        double sum = stats.getSum();
        double min = stats.getMin();
        double p25 = stats.getPercentile(25);
        double mean = stats.getMean();
        double median = stats.getPercentile(50);
        double p75 = stats.getPercentile(75);
        double max = stats.getMax();
        double std = stats.getStandardDeviation();

        System.out.println("n: " + n);
        System.out.println("sum: " + sum);
        System.out.println("min: " + min);
        System.out.println("p25: " + p25);
        System.out.println("mean: " + mean);
        System.out.println("median: " + median);
        System.out.println("p75: " + p75);
        System.out.println("max: " + max);
        System.out.println("std: " + std);
        System.out.println();

        // Using a properties file
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String startDate = prop.getProperty("start_date");
        String endDate = prop.getProperty("end_date");
        int numLoops = Integer.parseInt(prop.getProperty("num_loops"));

        System.out.println("Properties File:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("URL: " + url);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Number of Loops: " + numLoops);
//        */

    }
}