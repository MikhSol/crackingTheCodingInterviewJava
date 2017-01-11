package main;

import java.util.*;

import static java.lang.Math.abs;

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
        if (abs(s1.length() - s2.length()) > 1) return false;
        int changeCounter = 0;
        changeCounter += calculateStringsDifferences(s1, s2);
        return changeCounter < 2;
    }

    private static int calculateStringsDifferences(String s1, String s2) {
        int changeCounter = 0;
        Set<Map.Entry<Character, Integer>> s1Count = countChars(s1).entrySet();
        HashMap<Character, Integer> s2Count = countChars(s2);
        for (Map.Entry<Character, Integer> el : s1Count) {
            changeCounter += calculateElementDifferences(s2Count, el);
        }
        return changeCounter;
    }

    private static int calculateElementDifferences(HashMap<Character, Integer> stringElements, Map.Entry<Character, Integer> toCompare) {
        int changeCounter = 0;
        if (stringElements.containsKey(toCompare.getKey())) {
            changeCounter += abs(toCompare.getValue() - stringElements.get(toCompare.getKey()));
        } else {
            changeCounter++;
        }
        return changeCounter;
    }

    static String compressString(String s) {
        return "";
    }
}
