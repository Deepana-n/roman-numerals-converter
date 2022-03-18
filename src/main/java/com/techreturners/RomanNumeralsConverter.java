package com.techreturners;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumeralsConverter {

   private static final RomanNumeralsConverter rnc = new RomanNumeralsConverter();//instantiate here so object created once
   private static final String REGEX_PATTERN = "^(?i)(?=[IVXLCDM])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
   private static final String USER_ERR_MSG = "Please re-enter valid Roman Numerals ----> [IVXLCDM] and Numerals should not repeat > 3x";
   private static final HashMap<Character, Integer> map = new HashMap<>(); //instantiate here so hashmap created only once

    public static void main(String[] args) {
        rnc.userRomanNumeralsToNumber();
    }

    public void userRomanNumeralsToNumber(){
        Scanner sc = new Scanner(System.in);
        String romanNumeral;
        while(true){
            System.out.println("**** To quit programme enter q or 0 ****");
            System.out.print("Please enter Roman Numeral: ");
            romanNumeral = sc.nextLine();
            if(romanNumeral.equalsIgnoreCase("q") || romanNumeral.equalsIgnoreCase("0")){
                break;
            }
            else if(!checkUserWithRegex(romanNumeral)){
                System.out.println(USER_ERR_MSG);
                System.out.println();
            }
            else{
                int number = rnc.convertRomanNumerals(romanNumeral);
                System.out.println("You converted the Roman Numeral " + romanNumeral.toUpperCase() + " to the number " + number);
                System.out.println();
            }
        }
    }

    private HashMap<Character, Integer> mapOfRomanNumerals() {
        //Store the fundamental roman numerals in a hashmap
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public boolean checkUserWithRegex(String roman){
        return roman.matches(REGEX_PATTERN);
    }

    public int convertRomanNumerals(String roman) {
        //compare the first numeral with the next, if first is smaller --> subtract else add to value
        roman = roman.toUpperCase();
        int value = 0;
        char last = roman.charAt(roman.length() - 1);
        for (int i = 0; i < roman.length() - 1; i++) {
            char cur = roman.charAt(i);
            char next = roman.charAt(i + 1);
            if (mapOfRomanNumerals().get(cur) < mapOfRomanNumerals().get(next)){
                value -= mapOfRomanNumerals().get(cur);
            }
            else{
                value += mapOfRomanNumerals().get(cur);
            }
        }
        return value + mapOfRomanNumerals().get(last);
    }
}
