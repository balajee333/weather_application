package com.example.weatherapplication.utils;

public class StringUtils {

    public static String capitalizeWords(final String line) {
        String[] words = line.split(" ");
        StringBuffer capitalizedWords = new StringBuffer();
        for(String word : words) {
            capitalizedWords.append(Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ");
        }
        return capitalizedWords.toString().trim();
    }
}
