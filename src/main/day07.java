/*
 * Irfaan Khalid
 * 12/7/2017
 *
 * Description: Solution to Day 07's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/7
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day07 {
    private static HashMap<String, Integer> discToWeight = new HashMap<>();
    private static HashMap<String, String[]> discToDependents = new HashMap<>();

    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();
        populateMaps(inputScanner);

        System.out.println("Bottom disc: " + getBottomDisc());


    }

//    private static int getWeightToBalance() {
//        for (String disc : discToWeight.keySet()) {
//            if (discToDependents.containsKey(disc)) {
//                String[] dependentDiscs = discToDependents.get(disc);
//                int totalWeight = 0;
//
//                for (String dependentDisc : dependentDiscs) {
//                    totalWeight += discToWeight.get(dependentDisc);
//                }
//
//                if (totalWeight - (dependentDiscs.length * discToWeight.get(disc)) != 0) {
//                    return Math.ab
//                }
//
//            }
//        }
//    }

    private static String getBottomDisc() {
        ArrayList<String> dependentDiscs = getDependentDiscs();

        for (String disc : discToWeight.keySet()) {
            if (!dependentDiscs.contains(disc)) {
                return disc;
            }
        }

        // Given valid input, this should never happen
        return null;
    }

    private static ArrayList<String> getDependentDiscs() {
        ArrayList<String> ret = new ArrayList<>();
        Collection<String[]> dependentDiscs = discToDependents.values();

        for (String[] arr : dependentDiscs) {
            ret.addAll(Arrays.asList(arr));
        }

        return ret;
    }

    private static void populateMaps(Scanner inputScanner) {
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();

            // If the disc has dependencies
            if (line.contains("->")) {
                String[] splitByArrow = line.split("-> "); // Includes the space after

                // Get name and weight
                String name = splitByArrow[0].split("\\(")[0].trim();
                int weight = Integer.parseInt(splitByArrow[0].split("\\(")[1].split("\\)")[0]);

                // Get dependencies
                String[] dependencies = splitByArrow[1].split(", ");

                // Populate maps
                discToWeight.put(name, weight);
                discToDependents.put(name, dependencies);
            } else {
                // Get name and weight
                String name = line.split("\\(")[0].trim();
                int weight = Integer.parseInt(line.split("\\(")[1].split("\\)")[0]);

                // Populate map
                discToWeight.put(name, weight);
            }
        }
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day07.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }

}
