package main;

import java.util.HashSet;

class StringAnalyser {

    static Boolean isUnique(String s) {
        HashSet<Character> dict = new HashSet<>();
        for (int i=0; i < s.length(); i++) {
            if (dict.contains(s.charAt(i))) return false;
            dict.add(s.charAt(i));
        }
        return true;
    }
}
