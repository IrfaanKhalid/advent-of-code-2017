/*
 * Irfaan Khalid
 * 12/6/2017
 *
 * Description: Solution to Day 06's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/6
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class day06 {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();
        ArrayList<Integer> list = getInputArray(inputScanner);

        System.out.println("Redistribution cycles: " + getNumRedistributionCycles(list));
        System.out.println("Size of loop: " + getSizeOfLoop(list));
    }

    /**
     * Determines the number of cycles between identical patterns.
     *
     * @param list - list to redistribute
     * @return size of loop
     */
    public static int getSizeOfLoop(ArrayList<Integer> list) {
        // Store unique configurations
        HashSet<ArrayList<Integer>> configurations = new HashSet<>();

        // Count redistributions between identical patterns
        int count = 0;

        // Initial redistribution to get a unique starting point
        list = redistribute(list);

        // Keep redistributing until the starting point is found again
        while (!configurations.contains(list)) {
            configurations.add(list);
            list = redistribute(list);
            ++count;
        }

        return count;
    }

    /**
     * Determines the number of redistribution cycles from the original list required to
     * reach an infinite loop.
     *
     * @param list - list to redistribute
     * @return number of redistribution cycles
     */
    public static int getNumRedistributionCycles(ArrayList<Integer> list) {
        // Store and count unique configurations
        HashSet<ArrayList<Integer>> configurations = new HashSet<>();
        int count = 0;

        // Keep redistributing until an already seen distribution is met
        while (!configurations.contains(list)) {
            configurations.add(list);
            list = redistribute(list);
            ++count;
        }

        return count;
    }

    private static ArrayList<Integer> redistribute(ArrayList<Integer> list) {
        // Determine where to start distributing
        int maxIndex = list.indexOf(Collections.max(list));
        int distributionIndex = (maxIndex + 1) % list.size(); // Mod to wrap around the list

        // Get number of blocks to distribute and set the original max index to 0
        int blocksToDistribute = list.get(maxIndex);
        list.set(maxIndex, 0);

        while (blocksToDistribute > 0) {
            // Add a block at distributionIndex from the blocks available
            int curVal = list.get(distributionIndex);
            list.set(distributionIndex, ++curVal);
            --blocksToDistribute;

            // Update the distributionIndex, accounting for wrap-around
            ++distributionIndex;
            distributionIndex %= list.size();
        }

        return list;
    }

    private static ArrayList<Integer> getInputArray(Scanner inputScanner) {
        ArrayList<Integer> list = new ArrayList<>();

        // Store input values in an ArrayList for dynamic sizing
        while (inputScanner.hasNextInt()) {
            list.add(inputScanner.nextInt());
        }

        return list;
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day06.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }
}
