package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

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
                res.put(c, 1);
            }
        }
        return res;
    }

    static String uRLifySpaces(char[] arr, int trueLength) {
        int spaces = countSpaces(arr, trueLength);
        int id = trueLength + 2 * spaces;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[id-1] = '0'; arr[id-2] = '2'; arr[id-3] = '%';
                id -= 3;
            } else {
                arr[id - 1] = arr[i];
                id--;
            }
        }
        return new String(arr);
    }

    private static int countSpaces(char[] arr, int length) {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ')
                counter += 1;
        }
        return counter;
    }

    static Boolean isPalindromeOfPermutation(String string) {
        string = string.toLowerCase().replaceAll("\\s+", "");
        Iterator it = countChars(string).entrySet().iterator();
        int numbOfOdd = 0;
        while (it.hasNext() && numbOfOdd < 2){
            if ((int)((Map.Entry) it.next()).getValue() % 2 == 1) numbOfOdd += 1;
        }
        return numbOfOdd < 2;
    }

    static Boolean isPermittedEditOperation(String s1, String s2) {
        return false;
    }
}
