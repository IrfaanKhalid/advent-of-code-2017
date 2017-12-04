/*
 * Irfaan Khalid
 * 12/4/2017
 *
 * Description: JUnit tests for Day 04's challenge in Advent of Code 2017.
 *              http://adventofcode.com/2017/day/4
 */

package test;

import main.day04;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day04Test {
    @Test
    void isValidPassphrase() {
        // Part one
        assertEquals(true, day04.isValidPassphrase("aa bb cc dd ee"));
        assertEquals(false, day04.isValidPassphrase("aa bb cc dd aa"));
        assertEquals(true, day04.isValidPassphrase("aa bb cc dd aaa"));

        // Part two
        assertEquals(true, day04.isValidPassphrase("abcde fghij"));
        assertEquals(false, day04.isValidPassphrase("abcde xyz ecdab"));
        assertEquals(true, day04.isValidPassphrase("a ab abc abd abf abj"));
        assertEquals(true, day04.isValidPassphrase("iiii oiii ooii oooi oooo"));
        assertEquals(false, day04.isValidPassphrase("oiii ioii iioi iiio"));
    }
}