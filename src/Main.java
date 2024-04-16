import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String file1 = "ANA_ARE_MERE.txt";
        String file2 = "ANA_ARE_PERE.txt";

        Map<String, Integer> file1WordCount = countWords(file1);
        Map<String, Integer> file2WordCount = countWords(file2);

        System.out.println("Numărul de apariții a fiecărui cuvânt în fișierul 'ANA ARE MERE':");
        printWordCount(file1WordCount);

        System.out.println("\nNumărul de apariții a fiecărui cuvânt în fișierul 'ANA ARE PERE':");
        printWordCount(file2WordCount);
    }

    private static Map<String, Integer> countWords(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    private static void printWordCount(Map<String, Integer> wordCount) {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
