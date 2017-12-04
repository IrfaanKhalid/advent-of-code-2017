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
    }cd 
}