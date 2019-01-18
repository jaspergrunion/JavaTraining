import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        double[] myArray = {1.2, 3.5, 7.4, 9.2, 17.9, 22.8};
        DescriptiveStatistics stats = new DescriptiveStatistics();

        for (int i = 0; i < myArray.length; i++) {
            stats.addValue(myArray[i]);
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

        String[] nameList= {"Larry", "Moe", "Curly"};

        for (String name : nameList ) {
            System.out.println(name);
        }
        System.out.println();

        List<String> anotherList = new ArrayList<>();

        anotherList.add("Luke");
        anotherList.add("Leia");
        anotherList.add("Darth");
        anotherList.add("Rey");

        System.out.println(anotherList);
        System.out.println();

        for(String name : anotherList){
            System.out.println(name);
        }
        System.out.println();

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

        // Create array list of strings from csv file
        String fileref = "/Users/jlgunnin/IdeaProjects/JavaTraining/testin.csv";
        String[][] data = ReadCSV.toStringArray(fileref);

//        for (int r = 0; r < data.length; r++) {
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < data[r].length; c++) {
//                System.out.print(data[r][c] + " ");
                System.out.print(String.format("%-20s", data[r][c]));
            }
            System.out.println();
        }
        System.out.println();

        ReadCSV.printRows(data, 10);

        double[] gre = new double[data.length - 1];
        for (int r = 1; r < data.length; r++) {
            gre[r-1] = Double.parseDouble(data[r][2]);
        }
        System.out.println();

//        for (int i = 0; i < 10; i++) {
//            System.out.println(gre[i]);
//        }

        List<Student> studentList = ReadCSV.toArrayList(fileref);
        System.out.println(studentList.get(0));

//        System.out.println(studentList.get(0));
//        for (int i = 0; i < 5; i++) {
//            System.out.println(studentList.get(i));
//        }

    }
}