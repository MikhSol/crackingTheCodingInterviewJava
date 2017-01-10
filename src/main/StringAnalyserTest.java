package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAnalyserTest {
    private List<Map.Entry<String, Boolean>> testCases;

    @BeforeEach
    void setUp() {
        testCases = new ArrayList<>();
        testCases.add(new AbstractMap.SimpleEntry<>("ABCDEFG", true));
        testCases.add(new AbstractMap.SimpleEntry<>("ABCDEFGG", false));
        testCases.add(new AbstractMap.SimpleEntry<>("AA", false));
    }

    @Test
    void isUnique() {
        for (Map.Entry<String, Boolean> t : testCases)
            assertEquals(t.getValue(), StringAnalyser.isUnique(t.getKey()));
    }

    @Test
    void isUniqueAscii(){
        for (Map.Entry<String, Boolean> t : testCases)
            assertEquals(t.getValue(), StringAnalyser.isUniqueAscii(t.getKey()));
    }

}