package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.internal.collections.Pair;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAnalyserTest {
    private List<Map.Entry<String, Boolean>> isUniqueTestCases;
    private List<Pair<Pair<String, String>, Boolean>> isPermutationTestCases;
    private List<Map.Entry<Map.Entry<char[] , Integer>, String>> uRLifySpacesTestCases;

    @BeforeEach
    void setUp() {
        isUniqueTestCases = new ArrayList<>();
        isPermutationTestCases = new ArrayList<>();
        uRLifySpacesTestCases = new ArrayList<>();

        Collections.addAll(isUniqueTestCases,
                new AbstractMap.SimpleEntry<>("ABCDEFG", true),
                new AbstractMap.SimpleEntry<>("ABCDEFGG", false),
                new AbstractMap.SimpleEntry<>("AA", false));

        isPermutationTestCases.add(new Pair<>(new Pair<>("qwerty", "ytrewq"), true));
        isPermutationTestCases.add(new Pair<>(new Pair<>("abcd", "abcc"), false));

        Collections.addAll(uRLifySpacesTestCases,
                new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>("   ".toCharArray(), 1), "%20"),
                new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>("Mr John Smith    ".toCharArray(), 13),
                        "Mr%20John%20Smith")
        );


    }

    @Test
    void isUnique() throws Exception {
        for (Map.Entry<String, Boolean> t : isUniqueTestCases)
            assertEquals(t.getValue(), StringAnalyser.isUnique(t.getKey()));
    }

    @Test
    void isUniqueAscii() throws Exception {
        for (Map.Entry<String, Boolean> t : isUniqueTestCases)
            assertEquals(t.getValue(), StringAnalyser.isUniqueAscii(t.getKey()));
    }

    @Test
    void isPermutation() throws Exception {
        for (Pair<Pair<String, String>, Boolean> t : isPermutationTestCases) {
            assertEquals(t.second(), StringAnalyser.isPermutation(t.first().first(),
                    t.first().second()));
        }
    }

    @Test
    void uRLifySpaces() throws Exception {
        for (Map.Entry<Map.Entry<char[], Integer>, String> t : uRLifySpacesTestCases) {
            assertEquals(t.getValue(), StringAnalyser.uRLifySpaces(t.getKey().getKey(), t.getKey().getValue()));
        }
    }

}