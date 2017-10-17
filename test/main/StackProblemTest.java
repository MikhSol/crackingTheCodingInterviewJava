package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StackProblemTest {

    @Test
    void test_new_triple_stack_class() throws Exception {
        TripleStack s = new TripleStack();
        assertTrue(s instanceof TripleStack);
    }
}
