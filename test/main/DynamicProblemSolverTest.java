package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicProblemSolverTest {

    @Test
    void testNewSolver() {
        DynamicProblemSolver s = new DynamicProblemSolver();
        assertTrue(s instanceof DynamicProblemSolver);
    }

    @Test
    void testTripleStepSolverTest(){
        int w = DynamicProblemSolver.tripleStep(0);
        assertEquals(1, w);
        w = DynamicProblemSolver.tripleStep(1);
        assertEquals(1, w);
        w = DynamicProblemSolver.tripleStep(2);
        assertEquals(2, w);
        w = DynamicProblemSolver.tripleStep(3);
        assertEquals(4, w);
        w = DynamicProblemSolver.tripleStep(4);
        assertEquals(7, w);
        w = DynamicProblemSolver.tripleStep(5);
        assertEquals(13  , w);
        w = DynamicProblemSolver.tripleStep(6);
        assertEquals(24  , w);
    }

    @Test
    void testTripleStepSolverWithMemorization() {
        int s = DynamicProblemSolver.tripleStepMemo(0);
        assertEquals(1, s);
        s = DynamicProblemSolver.tripleStepMemo(1);
        assertEquals(1, s);
        s = DynamicProblemSolver.tripleStepMemo(2);
        assertEquals(2, s);
        s = DynamicProblemSolver.tripleStepMemo(3);
        assertEquals(4, s);
        s = DynamicProblemSolver.tripleStepMemo(4);
        assertEquals(7, s);
        s = DynamicProblemSolver.tripleStepMemo(5);
        assertEquals(13, s);
        s = DynamicProblemSolver.tripleStepMemo(6);
        assertEquals(24, s);
    }
}
