/*
 * Irfaan Khalid
 * 12/2/2017
 *
 * Description: Solution to Day 02's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/2
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day02 {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();
        assert inputScanner != null;

        int normalChecksum = 0, modifiedChecksum = 0;

        // Process each line and add its resultant values to the appropriate checksums
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            ArrayList<Integer> nums = getIntList(line);

            normalChecksum += getDifference(nums);
            modifiedChecksum += getQuotient(nums);
        }

        System.out.println("This file's normal checksum is: " + normalChecksum);
        System.out.println("This file's modified checksum is: " + modifiedChecksum);
    }

    /**
     * getDifference - Returns the appropriate value from each line of the spreadsheet
     * @param nums - list of numbers to assess
     * @return difference between min and max values in list
     */
    public static int getDifference(ArrayList<Integer> nums) {
        return Collections.max(nums) - Collections.min(nums);
    }

    /**
     * getQuotient - Returns the appropriate value from each line of the spreadsheet
     * @param nums - list of numbers to assess
     * @return - the quotient of the first evenly divisible pair of numbers
     */
    public static int getQuotient(ArrayList<Integer> nums) {
        // Compares every element in the list to every other element
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.size(); ++j) {
                // If a given pair of numbers is divisible either way, return the integral quotient
                if (i != j && nums.get(i) % nums.get(j) == 0) {
                    return nums.get(i) / nums.get(j);
                } else if (i != j && nums.get(j) % nums.get(i) == 0) {
                    return nums.get(j) / nums.get(i);
                }
            }
        }

        return 0;
    }

    private static ArrayList<Integer> getIntList(String line) {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner lineScanner = new Scanner(line);

        // Parses the line for all ints and adds them to the list
        while (lineScanner.hasNextInt()) {
            nums.add(lineScanner.nextInt());
        }

        // Housekeeping
        nums.trimToSize();

        return nums;
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day02.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }
}
