package test;

import main.StringAnalyser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsUniqueInStringTest {

    @Test
    public void testIsUniqueTrue() {
        StringAnalyser sa = new StringAnalyser();
        String testTrue = "ABCDEFG";
        assertEquals(true, sa.isUnique(testTrue));
    }
}
