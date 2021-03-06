package com.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsConverterTest {

   private RomanNumeralsConverter rnc;

    @BeforeEach
    public void setup(){
        rnc = new RomanNumeralsConverter();
    }

    @Test
    public void checkRomanNumeralI(){
        assertEquals(1, rnc.convertRomanNumerals("I"));
    }

    @Test
    public void checkRomanNumeralWhereSmallBeforeLargeIX(){
        assertEquals(9, rnc.convertRomanNumerals("IX"));
    }

    @Test
    public void checkRomanNumeralWhereLargeBeforeSmallXIII(){
        assertEquals(13, rnc.convertRomanNumerals("XIII"));
    }

    @Test
    public void checkRomanNumeralSingleD(){
        assertEquals(500, rnc.convertRomanNumerals("D"));
    }

    @Test
    public void checkRomanNumeralLargeMMMMDCCLXXXII(){
        assertEquals(4782, rnc.convertRomanNumerals("MMMMDCCLXXXII"));
    }

    @Test
    public void checkRomanNumeralLowerCaseVI(){
        assertEquals(6, rnc.convertRomanNumerals("vi"));
    }

    @Test
    public void checkRomanNumeralMixtureOfUpperAndLowerCaseCCLXX(){
        assertEquals(270, rnc.convertRomanNumerals("ccLxX"));
    }

    @Test
    public void checkRegexWhenRomanNumeralRepeatedMoreThanThreeTimesInvalid(){
        String repeatedRomanNumeral = "IIII";
        assertFalse(rnc.checkUserWithRegex(repeatedRomanNumeral));
    }

    @Test
    public void checkRegexWhenRomanNumeralValid(){
        String validRomanNumeral = "IV";
        assertTrue(rnc.checkUserWithRegex(validRomanNumeral));
    }

    @Test
    public void checkRegexWhenNonRomanNumeralInvalid(){
        String nonRomanNumeralLetter = "P";
        assertFalse(rnc.checkUserWithRegex(nonRomanNumeralLetter));
    }

    @Test
    public void checkRegexWhenMixOfNonAndRomanNumeralInvalid(){
        String nonAndValidRomanNumeral = "PX";
        assertFalse(rnc.checkUserWithRegex(nonAndValidRomanNumeral));
    }

    @Test
    public void checkRegexWhenLowercaseRomanNumeralValid(){
        String lowercaseValidRomanNumeral = "ix";
        assertTrue(rnc.checkUserWithRegex(lowercaseValidRomanNumeral));
    }

    @Test
    public void checkRegexWhenLowerUppercaseRomanNumeralValid(){
        String lowerUpperCaseValidRomanNumeral = "Di";
        assertTrue(rnc.checkUserWithRegex(lowerUpperCaseValidRomanNumeral));
    }

    @Test
    public void checkRegexWhenLowercaseRomanNumeralInvalid(){
        String lowerInvalidRomanNumeral = "k";
        assertFalse(rnc.checkUserWithRegex(lowerInvalidRomanNumeral));
    }
}
