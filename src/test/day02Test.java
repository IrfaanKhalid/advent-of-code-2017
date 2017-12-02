/*
 * Irfaan Khalid
 * 12/2/2017
 *
 * Description: JUnit tests for Day 02's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/2
 */

package test;

import main.day02;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class day02Test {
    @Test
    void getDifference() {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(5, 1, 9, 5));
        assertEquals(8, day02.getDifference(test));

        test = new ArrayList<>(Arrays.asList(7, 5, 3));
        assertEquals(4, day02.getDifference(test));

        test = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        assertEquals(6, day02.getDifference(test));
    }

    @Test
    void getQuotient() {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(5, 9, 2, 8));
        assertEquals(4, day02.getQuotient(test));

        test = new ArrayList<>(Arrays.asList(9, 4, 7, 3));
        assertEquals(3, day02.getQuotient(test));

        test = new ArrayList<>(Arrays.asList(3, 8, 6, 5));
        assertEquals(2, day02.getQuotient(test));
    }
}