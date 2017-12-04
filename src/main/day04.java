/*
 * Irfaan Khalid
 * 12/4/2017
 *
 * Description: Solution to Day 04's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/4
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class day04 {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();
        assert inputScanner != null;

        int validCount = 0;

        // Process every passphrase in the input file
        while (inputScanner.hasNextLine()) {
            String passphrase = inputScanner.nextLine();
            validCount += isValidPassphrase(passphrase) ? 1 : 0;
        }

        System.out.println("The number of valid passphrases is: " + validCount);
    }

    /**
     * isValidPassphrase - Assesses a given passphrase for redundancy or anagrams to determine
     *                     its validity
     * @param passphrase - the passphrase to assess
     * @return whether or not the given passphrase is valid
     */
    public static boolean isValidPassphrase(String passphrase) {
        Scanner lineScanner = new Scanner(passphrase);
        HashSet<String> words = new HashSet<>();

        // Process every word in the passphrase and assess redundancy
        while (lineScanner.hasNext()) {
            String currentWord = lineScanner.next();

            // Determine if the word has been seen before in the phrase
            if (words.contains(currentWord) || containsAnagram(words, currentWord)) {
                return false;
            } else {
                words.add(currentWord);
            }
        }

        return true;
    }

    private static boolean containsAnagram(HashSet<String> set, String word) {
        boolean containsAnagram = false;

        // Determine if any of the other
        for (String s : set) {
            containsAnagram |= isAnagram(s, word);
        }

        return containsAnagram;
    }

    private static boolean isAnagram(String first, String second) {
        // Map characters to counts in Strings
        HashMap<Character, Integer> firstCharacterCount = getCountMap(first);
        HashMap<Character, Integer> secondCharacterCount = getCountMap(second);

        // If both the maps are the same, the Strings are anagrams
        return firstCharacterCount.equals(secondCharacterCount);
    }

    private static HashMap<Character, Integer> getCountMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Obtain counts for every character in str
        for (int i = 0; i < str.length(); ++i) {
            Character key = str.charAt(i);

            if (map.containsKey(key)) {
                Integer val = map.get(key);
                map.replace(key, ++val);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day04.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }
}
