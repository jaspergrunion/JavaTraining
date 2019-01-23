import java.util.Map;
import java.util.TreeMap;

public interface FreqCounts {
    static void table(String[] inputArray){
        TreeMap<String, Integer> elementCountMap = new TreeMap<>();
        for (String i : inputArray)
        {
            if(elementCountMap.containsKey(i)) {
                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else {
                elementCountMap.put(i, 1);
            }
        }
        System.out.println("Dice roll distribution:");
        System.out.println(elementCountMap);
        System.out.println();

        for(Map.Entry<String,Integer> entry : elementCountMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
