import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Arrays to hold the split data
        BufferedReader reader;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int totalDistance = 0;
        try {
            reader = new BufferedReader(new FileReader("./data.txt"));
                String line = reader.readLine();

                while (line != null) {
                    String[] arr = line.split("   ");
                    list1.add(Integer.parseInt(arr[0]));
                    list2.add(Integer.parseInt(arr[1]));
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(totalDistance);
    }
}