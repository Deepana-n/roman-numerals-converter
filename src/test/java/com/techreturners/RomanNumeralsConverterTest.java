package com.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
