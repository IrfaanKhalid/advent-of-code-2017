/*
 * Irfaan Khalid
 * 12/1/2017
 *
 * Description: JUnit tests for Day 01's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/1
 */

package test;

import main.day01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day01Test {
    @Test
    void testOriginalSum() {
        assertEquals(3, day01.getOriginalSum("1122"));
        assertEquals(4, day01.getOriginalSum("1111"));
        assertEquals(0, day01.getOriginalSum("1234"));
        assertEquals(9, day01.getOriginalSum("91212129"));
    }

    @Test
    void testCircularSum() {
        assertEquals(6, day01.getCircularSum("1212"));
        assertEquals(0, day01.getCircularSum("1221"));
        assertEquals(4, day01.getCircularSum("123425"));
        assertEquals(12, day01.getCircularSum("123123"));
        assertEquals(4, day01.getCircularSum("12131415"));
    }
}