package main;

import java.util.HashMap;
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
        if (first.length() != second.length()) return false;

        HashMap<Character, Integer> hf = countChars(first);
        HashMap<Character, Integer> hs = countChars(second);
        return hf.equals(hs);
    }

    private static HashMap<Character,Integer> countChars(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (res.containsKey(c)) {
                res.put(c, res.get(c) + 1);
            } else {
                res.put(c, 0);
            }
        }
        return res;
    }

    static String uRLifySpaces(String string, Integer trueLength) {
        return "";
    }
}
