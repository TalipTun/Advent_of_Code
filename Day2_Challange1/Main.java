import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        BufferedReader reader;
        int safeCount = 0;
        try {
            reader = new BufferedReader(new FileReader("./data.txt"));
                String line = reader.readLine();

                while (line != null) {
                    System.out.println("---");
                    String[] levels = line.split(" ");
                    boolean isSafe = true;
                    int decreasingSequence = 0;
                    int increasingSequence = 0;
                    System.out.println(line);
                    for (int i = 1; i < levels.length; i++) {
                        int secondNumber = Integer.parseInt(levels[i]);
                        int firstNumber = Integer.parseInt(levels[i - 1]);
                        // if dif is more than 3 or less than 1, it's not safe
                        if (Math.abs(secondNumber - firstNumber) > 3 || Math.abs(secondNumber - firstNumber) < 1) {
                            isSafe = false;
                            break;
                        }
                        if (secondNumber > firstNumber) {
                            increasingSequence++;
                        } else if (secondNumber < firstNumber) {
                            decreasingSequence++;
                        }
                    }
                    if (isSafe && (increasingSequence == levels.length - 1 || decreasingSequence == levels.length - 1)) {
                        safeCount++;
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
            System.out.println("Safe count: " + safeCount);
    }
}
