/*
 * Irfaan Khalid
 * 12/8/2017
 *
 * Description: Solution to Day 08's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/8
 */

package main;

import exceptions.InvalidTestException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class day08 {
    private static HashMap<String, Integer> register = new HashMap<>();
    private static int overallMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner();

        while (inputScanner.hasNextLine()) {
            String instruction = inputScanner.nextLine();
            processInstruction(instruction);

            // This is a bit of a hack, but I'm feeling lazy
            overallMax = Math.max(overallMax, Collections.max(register.values()));
        }

        int maxVal = Collections.max(register.values());

        System.out.println("Max value of any register: " + maxVal);
        System.out.println("Max value at any time: " + overallMax);
    }

    private static void processInstruction(String instruction) {
        // Obtain individual tokens
        String[] splitString = instruction.split(" ");

        // Certainly in the indicated indices
        String modifyRegister = splitString[0];
        String command = splitString[1];
        String modifyVal = splitString[2];
        String testRegister = splitString[4];

        // Add the registers to in the instruction to the HashMap if they aren't in it yet
        register.putIfAbsent(modifyRegister, 0);
        register.putIfAbsent(testRegister, 0);

        // Obtain condition to test
        String conditionalString = getConditional(testRegister, splitString);
        boolean conditional = false;

        // Parse the conditional String
        conditional = parseConditional(conditionalString);

        // Only process the command if the conditional was true
        if (conditional) {
            processCommand(modifyRegister, command, modifyVal);
        }
    }

    private static void processCommand(String modifyRegister, String command, String modifyValStr) {
        // Get current register value and the value by which to inc/dec it
        int currentVal = register.get(modifyRegister), modifyVal = Integer.parseInt(modifyValStr);

        // Perform the modification
        switch (command) {
            case "inc":
                register.put(modifyRegister, currentVal + modifyVal);
                break;
            case "dec":
                register.put(modifyRegister, currentVal - modifyVal);
                break;
        }
    }

    private static String getConditional(String testRegister, String[] splitString) {
        // Obtain value to test in the conditional
        int testValue = register.get(testRegister);

        // Build the conditional
        StringBuilder conditionalBuilder = new StringBuilder();
        conditionalBuilder.append(testValue);
        conditionalBuilder.append(" ");

        for (int i = 5; i < splitString.length; ++i) {
            conditionalBuilder.append(splitString[i]);
            conditionalBuilder.append(" ");
        }

        return conditionalBuilder.toString().trim();
    }

    private static boolean parseConditional(String conditional) {
        String[] stringSplit = conditional.split(" ");

        // Get values
        int leftVal = Integer.parseInt(stringSplit[0]);
        int rightVal = Integer.parseInt(stringSplit[2]);

        // Evaluate the conditional and return its value
        boolean value = false;

        switch (stringSplit[1]) {
            case "==":
                value = leftVal == rightVal;
                break;
            case "!=":
                value = leftVal != rightVal;
                break;
            case "<":
                value = leftVal < rightVal;
                break;
            case "<=":
                value = leftVal <= rightVal;
                break;
            case ">":
                value = leftVal > rightVal;
                break;
            case ">=":
                value = leftVal >= rightVal;
                break;
        }

        return value;
    }

    private static Scanner getInputScanner() {
        try {
            return new Scanner(new File("input/day08.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        return null;
    }

}
