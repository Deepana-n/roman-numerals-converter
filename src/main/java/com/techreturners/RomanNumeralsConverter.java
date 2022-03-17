package com.techreturners;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumeralsConverter {

    public static void main(String[] args) {
        RomanNumeralsConverter rnc = new RomanNumeralsConverter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter roman numeral: ");
        String romanNumeral = sc.nextLine();
        int number = rnc.convertRomanNumerals(romanNumeral);
        System.out.println("You converted the Roman Numeral " + romanNumeral + " to the number " + number);
    }

    public HashMap<Character, Integer> mapOfRomanNumerals() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public int convertRomanNumerals(String roman) {
        int value = 0;
        char last = roman.charAt(roman.length() - 1);
        for (int i = 0; i < roman.length() - 1; i++) {
            char cur = roman.charAt(i);
            char next = roman.charAt(i + 1);
            if (mapOfRomanNumerals().get(cur) < mapOfRomanNumerals().get(next))
                value -= mapOfRomanNumerals().get(cur);
            else
                value += mapOfRomanNumerals().get(cur);
        }
        return value + mapOfRomanNumerals().get(last);
    }
}
