/*
 * Irfaan Khalid
 * 12/5/2017
 *
 * Description: JUnit tests for Day 05's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/5
 */

package test;

import main.day05;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day05Test {
    @Test
    void getNumStepsModified() {
        int[] test = {0, 3, 0, 1, -3};
        Assertions.assertEquals(10, day05.getNumStepsModified(test));
    }

    @Test
    void getNumSteps() {
        int[] test = {0, 3, 0, 1, -3};
        assertEquals(5, day05.getNumSteps(test));
    }
}