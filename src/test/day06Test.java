/*
 * Irfaan Khalid
 * 12/6/2017
 *
 * Description: JUnit tests for Day 06's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/6
 */

package test;

import main.day06;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class day06Test {
    private static final int[] TEST_1 = {0, 2, 7, 0};

    @Test
    void getSizeOfLoop() {
        ArrayList<Integer> list = getList(TEST_1);
        Assertions.assertEquals(4, day06.getSizeOfLoop(list));
    }

    @Test
    void getNumRedistributionCycles() {
        ArrayList<Integer> list = getList(TEST_1);
        assertEquals(5, day06.getNumRedistributionCycles(list));
    }

    private ArrayList<Integer> getList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i);
        }

        return list;
    }
}