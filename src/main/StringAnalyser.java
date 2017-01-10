package main;

import java.util.HashSet;

class StringAnalyser {

    static Boolean isUnique(String s) {
        HashSet<Character> dict = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.charAt(i))) return false;
            dict.add(s.charAt(i));
        }
        return true;
    }

    static Boolean isUniqueAscii(String s) {
        if (s.length() > 128) return false;
        boolean[] asciiMask = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (asciiMask[val]) return false;
            asciiMask[val] = true;
        }
        return true;
    }

    static Boolean isPermutation(String first, String second) {
        return false;
    }
}
