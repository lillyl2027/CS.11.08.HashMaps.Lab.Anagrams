import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {}

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     *
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        File file = new File(filename);
        Scanner scanner;
        try { // The code in the try block is executed first, and if it throws an exception, the code in the catch block will be executed
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                char[] chars = word.toCharArray(); // Converting the word into an array of characters
                Arrays.sort(chars); // Sort the array alphabetically
                String key = new String(chars);
                if (!result.containsKey(key)) { // Check if key is in HashMap - if not
                    result.put(key, new ArrayList<>()); // A new ArrayList is created and added to the HashMap with the key
                    result.get(key).add(word); // Adding the word to the ArrayList associated with the key in the HashMap

                }
                else {
                    result.get(key).add(word); // Adding the word to the existing ArrayList associated with the key in the HashMap

                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
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
            ArrayList<String> arr = anagrams.get(i); // Retrieves the value
            System.out.println(i + ": " + arr);
            }
        }
    }

