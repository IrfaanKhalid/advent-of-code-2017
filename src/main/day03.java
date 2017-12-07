/*
 * Irfaan Khalid
 * 12/3/2017
 *
 * Description: Solution to Day 03's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/3
 */

package main;

import java.util.Arrays;

public class day03 {
    public static void main(String[] args) {
        int closestSquare = getClosestSquare(347991);

        System.out.println("Closest square to input: " + closestSquare);
        System.out.println("Square root of this value: " + (int) Math.sqrt(closestSquare));
    }


    private static int getClosestSquare(int input) {
        double squareRoot = Math.sqrt(input);

        int lowerSquare = (int) Math.pow(Math.floor(squareRoot), 2);
        int lowerDiff = input - lowerSquare;

        int upperSquare = (int) Math.pow(Math.ceil(squareRoot), 2);
        int upperDiff = upperSquare - input;

        int closest = Math.min(lowerDiff, upperDiff) == lowerDiff ? lowerSquare : upperSquare;
        int squareRootClosest = (int) Math.sqrt(closest);

        // idk
        return 0;

    }

    private static int[][] generateGrid(int inputVal) {
        // Get size of grid and instantiate it
        int size = (int) Math.round(Math.sqrt(inputVal));
        int[][] grid = new int[size][size];

        // Populate grid
        int center = size / 2; // index

        for (int x = 0; x < size; ++x) {
            for (int y = 0; y < size; ++y) {
                //grid[x][y] =
            }
        }

        return grid;
    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}
