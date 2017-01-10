package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.internal.collections.Pair;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAnalyserTest {
    private List<Map.Entry<String, Boolean>> isUniqueTestCases;
    private List<Pair<Pair<String, String>, Boolean>> isPermutationTestCases;

    @BeforeEach
    void setUp() {
        isUniqueTestCases = new ArrayList<>();
        Collections.addAll(isUniqueTestCases,
                new AbstractMap.SimpleEntry<>("ABCDEFG", true),
                new AbstractMap.SimpleEntry<>("ABCDEFGG", false),
                new AbstractMap.SimpleEntry<>("AA", false));
        isPermutationTestCases = new ArrayList<>();
        isPermutationTestCases.add(new Pair<>(new Pair<>("qwerty", "ytrewq"), true));
        isPermutationTestCases.add(new Pair<>(new Pair<>("abcd", "abcc"), false));
    }

    @Test
    void isUnique() {
        for (Map.Entry<String, Boolean> t : isUniqueTestCases)
            assertEquals(t.getValue(), StringAnalyser.isUnique(t.getKey()));
    }

    @Test
    void isUniqueAscii(){
        for (Map.Entry<String, Boolean> t : isUniqueTestCases)
            assertEquals(t.getValue(), StringAnalyser.isUniqueAscii(t.getKey()));
    }

    @Test
    void isPermutation() {
        for (Pair<Pair<String, String>, Boolean> t : isPermutationTestCases) {
            assertEquals(t.second(), StringAnalyser.isPermutation(t.first().first(),
                    t.first().second()));
        }
    }

}