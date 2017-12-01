/*
 * Irfaan Khalid
 * 12/1/2017
 *
 * Description: Solution to Day 01's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/1
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day01 {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner("input/day01.txt");
        String inputString = inputScanner.nextLine();

        int originalSum = getOriginalSum(inputString);
        System.out.println("The original solution to the captcha is: " + originalSum);

        int circularSum = getCircularSum(inputString);
        System.out.println("The circular solution to the captcha is: " + circularSum);
    }

    /**
     * getCircularSum - returns the circular sum of a list of numbers
     *
     * @param input - String representing the list of numbers
     * @return the sum of all digits that match the digit halfway around the list
     */
    public static int getCircularSum(String input) {
        int sum = 0;

        // Compare every character to the one halfway around the list
        for (int i = 0; i < input.length(); ++i) {
            sum += input.charAt(i) == input.charAt((i + (input.length() / 2)) % input.length()) ?
                    Character.getNumericValue(input.charAt(i)) : 0;
        }

        return sum;
    }

    /**
     * getOriginalSum - returns the original sum of a list of numbers
     *
     * @param input - String representing the list of numbers
     * @return the sum of all digits that match the next digit in the list
     */
    public static int getOriginalSum(String input) {
        int sum = 0;

        // Compare every character to the one immediately following it
        for (int i = 0; i < input.length(); ++i) {
            sum += input.charAt(i) == input.charAt((i + 1) % input.length()) ?
                    Character.getNumericValue(input.charAt(i)) : 0;
        }

        return sum;
    }

    private static Scanner getInputScanner(String inputFileName) {
        try {
            return new Scanner(new File(inputFileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }
}