package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class TripleStackTest {
    private final int capacity = 100;
    private TripleStack s;

    @BeforeEach
    void setUp() {
        s = new TripleStack(capacity);
    }

    @Test
    void testNewTripleStackClass() throws Exception {
        assertTrue(s instanceof TripleStack);
    }

    @Test
    void testTripleStackNumbersOfStack() throws Exception {
        assertEquals(3, s.getNumberOfStacks());
    }

    @Test
    void testTripleStackCapacity() throws Exception {
        assertEquals(capacity, s.getCapacity());
    }

    @Test
    void testStackIsEmpty() throws Exception {
        for (int stackNumber = 0; stackNumber < 3; stackNumber++) {
            assertTrue(s.isEmpty(stackNumber));
        }

    }

    @Test
    void testPopEmptyStack() throws Exception {
        for (int stackNumber = 0; stackNumber < 3; stackNumber++) {
            int finalStackNumber = stackNumber;
            assertThrows(EmptyStackException.class, () -> s.pop(finalStackNumber));
        }
    }

    @Test
    void testPushToStacks() throws Exception {
        int v = 1;

        for (int stackNumber = 0; stackNumber < 3; stackNumber++) {
            s.push(v, stackNumber);
            assertFalse(s.isEmpty(stackNumber));
        }
    }

    @Test
    void testPopNonEmptyStack() throws Exception {
        for (int stackNumber = 0; stackNumber < 3; stackNumber++) {
            s.push(stackNumber, stackNumber);
            assertEquals(stackNumber, s.pop(stackNumber));
        }
    }

    @Test
    void testStackIsFull() throws Exception {
        for (int i = 0; i < s.getCapacity(); i++) {
            s.push(i, 0);
        }
        assertTrue(s.isFull(0));
    }

    @Test
    void testOverflowStackCapacity() throws Exception {
        for (int i = 0; i < s.getCapacity(); i++) {
            s.push(i, 0);
        }
        assertThrows(StackOverflowError.class, () -> s.push(0,0));
    }

    @Test
    void testPeekOnEmptyStack() throws Exception {
        for (int i = 0; i < 3; i++) {
            int stackNumber = i;
            assertThrows(EmptyStackException.class, () -> s.peek(stackNumber));
        }
    }

    @Test
    void testPeekOnNonEmptyStack() throws Exception {
        for (int i = 0; i < 3; i++) {
            s.push(i, i);
            assertEquals(i, s.peek(i));
            assertFalse(s.isEmpty(i));
        }
    }
}
