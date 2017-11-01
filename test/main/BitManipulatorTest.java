package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitManipulatorTest {

    @Test
    void testSetBitsToPosition() {
        int N = 0b1000000000;
        int M = 0b10011;
        int i = 2;
        int j = 6;
        int Output = 0b1000100110;
        assertEquals(Output, BitManipulator.insertBitsToPosition(N, M, i, j));
    }

    @Test
    void testBinaryRepresentationOfDoubleFromZeroToOne() {
        assertEquals("Error", BitManipulator.doubleAsBinString(1.5));

        assertEquals("Error", BitManipulator.doubleAsBinString(-0.2));

        // In = 0.75
        assertEquals(".11", BitManipulator.doubleAsBinString(.5*1 + .5*.5 *1));

        assertEquals(".1101", BitManipulator.doubleAsBinString(.5*1 + .5*.5*1 + .5*.5*.5*0 + .5*.5*.5*.5*1));
    }
}
