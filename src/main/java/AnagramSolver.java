import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {
    }

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     *
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> hashie = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (hashie.containsKey(key)) {
                    hashie.get(key).add(word);
                } else {
                    hashie.put(key, new ArrayList<>());
                    hashie.get(key).add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return hashie;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     *
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> mostWordsList = new ArrayList<>();
        for (ArrayList<String> list : anagrams.values()) {
            if (list.size() > mostWordsList.size()) {
                mostWordsList = list;

            }
        }
        return mostWordsList;
    }

        /**
         * Input: hashmap of lists of words that are anagrams.
         * Output: prints all key value pairs in the hashmap.
         *
         * @param anagrams
         */
        public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
            for (String i : anagrams.keySet()) {
                ArrayList<String> arr = anagrams.get(i);
                System.out.println(i + ": " + arr);
            }
        }
}
