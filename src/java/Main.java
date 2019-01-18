import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Main {
    public static void main(String[] args) {

        double[] myArray = {1.2, 3.5, 7.4, 9.2, 17.9, 22.8};
        DescriptiveStatistics stats = new DescriptiveStatistics();

        for( int i = 0; i < myArray.length; i++) {
            stats.addValue(myArray[i]);
        }

        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        System.out.println(mean);
        System.out.println(std);
        System.out.println(median);

//        double median = stats.getPercentile(50);

//
//        int num_sides = 6;
//        int num_rolls = 1000;
//        String[] rolls = new String[num_rolls];
//        for (int i = 0; i < num_rolls; i++) {
//
//            int dice1 = 1 + (int) (Math.random()*num_sides);
//            int dice2 = 1 + (int) (Math.random()*num_sides);
//            int total = dice1 + dice2;
//            String totalStr;
//            if (total < 10){
//                totalStr = "0" + Integer.toString(total);
//            } else {
//                totalStr = Integer.toString(total);
//            }
//            rolls[i] = totalStr;
//        }
//        System.out.println();
//        FreqCounts.dist(rolls);

    }
}