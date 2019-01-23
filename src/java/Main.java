import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Primitive types
        int myInt1 = 25; // int is 32 bit so range is -2^32 to 2^32 - 1, for 64 bit integer use long instead of int
        int myInt2 = 12;
        int myInt3 = 2*myInt2 + 1;
        boolean myBool = true; // false is other value
        double myDouble = 37.2; // 64 bit floating point, float type is 32 bit and not commonly used
        // other primitive types: byte, short, char

        // Math and comparisons
        System.out.println(myInt1/myInt2);
        System.out.println(25/12.0);
        System.out.println(myInt1 > myInt2);
        System.out.println(myInt1 == myInt3);
        System.out.println(myDouble/2);
        System.out.println();

        // Popular constants and exponentiation
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.random()); // No seed - to generate random with seed use a generator
        System.out.println(Math.pow(myInt1, 3));
        System.out.println();

        // Strings - not a primitive type and hence String with a capital S
        String myString1 = "John Smith";
        String myString2 = "John Smyth";

        boolean stringsEqual = myString1.equals(myString2);
        System.out.println("Is '" + myString1 + "' equal to '" + myString2 + "'? - " + stringsEqual);
        System.out.println("JOHN".equalsIgnoreCase("john"));

        boolean subsEqual = myString1.substring(0,4).equals(myString2.substring(0,4));
        System.out.println(subsEqual);
        System.out.println();

        // Convert decimal to string
        double gpa = 3.8;
        String gpaString = Double.toString(gpa);

        String compoundString = "GPA: " + gpa;
//        String compoundString = "GPA: " + gpaString;
        System.out.println(compoundString);
        System.out.println();

        // Arrays of primitives
        double[] myArray1 = {1.2, 3.5, 7.4, 9.2, 17.9, 22.8};
        double[] myArray2 = {2.4, 3.7, 7.4, 12.4, 17.9, 30.8};
        double[] myArray3 = {1.2, 3.5, 7.4, 9.2, 17.9, 22.8};

        System.out.println(myArray1 == myArray2);
        System.out.println(myArray1 == myArray3);
        System.out.println(myArray1);
        System.out.println(myArray3);

        boolean[] arrayEqual = new boolean[myArray1.length];
        for (int i = 0; i < myArray1.length; i++) {
            arrayEqual[i] = (myArray1[i] == myArray2[i]);
        }
        for (boolean element : arrayEqual) {
            System.out.print(element + " ");
        }
        System.out.println();

        // String list
        String[] nameList= {"Larry", "Moe", "Curly"};

        for (String name : nameList ) {
            System.out.println(name);
        }
        System.out.println();

        // Array list - a Collection
        List<String> starWarsList = new ArrayList<>();

        starWarsList.add("Luke");
        starWarsList.add("Leia");
        starWarsList.add("Darth");
        starWarsList.add("Rey");
        System.out.println(starWarsList);

        starWarsList.remove("Rey");
        System.out.println(starWarsList);
        starWarsList.add("Poe");
        System.out.println(starWarsList);
        starWarsList.remove(0);

        for(String name : starWarsList){
            System.out.println(name);
        }
        System.out.println();

        // Create list of data objects from csv file
        String fileref = "/Users/jlgunnin/IdeaProjects/JavaTraining/student_data.csv";

        List<Student> studentList = ReadCSV.toList(fileref);
        ReadCSV.printN(studentList, 10);
//        ReadCSV.printN(studentList);

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

        // Define interface instead of class - kind of like a function in other languages
        // Rolling two dice and tabulating the distribution
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
        FreqCounts.table(rolls);

    }
}