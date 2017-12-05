/*
 * Irfaan Khalid
 * 12/5/2017
 *
 * Description: Solution to Day 05's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/5
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day05 {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();

        int[] input = getInputArray(inputScanner);
        int[] inputForModified = input.clone();

        System.out.println("Required steps: " + getNumSteps(input));
        System.out.println("Required steps (modified): " + getNumStepsModified(inputForModified));
    }

    /**
     * Calculates the number of steps required for part two.
     *
     * @param instructions - the input array
     * @return required number of steps
     */
    public static int getNumStepsModified(int[] instructions) {
        int steps = 0, i = 0;

        // Keep taking steps until we exit the array
        while (i < instructions.length) {
            int val = instructions[i];
            instructions[i] += instructions[i] < 3 ? 1 : -1;
            i += val;
            ++steps;
        }

        return steps;
    }

    /**
     * Calculates the number of steps required for part one.
     *
     * @param instructions - the input array
     * @return required number of steps
     */
    public static int getNumSteps(int[] instructions) {
        int steps = 0, i = 0;

        // Keep taking steps until we exit the array
        while (i < instructions.length) {
            i += instructions[i]++;
            ++steps;
        }

        return steps;
    }

    private static int[] getInputArray(Scanner inputScanner) {
        ArrayList<Integer> list = new ArrayList<>();

        // Store input values in an ArrayList for dynamic sizing
        while (inputScanner.hasNextInt()) {
            list.add(inputScanner.nextInt());
        }

        // Convert List to a statically allocated array
        return Arrays.stream(list.toArray()).mapToInt(i -> (int) i).toArray();
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day05.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }
}
