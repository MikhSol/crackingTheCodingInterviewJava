package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphUtilityTest {
    private GraphUtility utility;
    private Graph graph;
    private Node a;
    private Node b;
    private Node c;
    private Node d;
    private ArrayList<Node> path;

    @BeforeEach
    void setUp() {
        utility = new GraphUtility();
        graph = new Graph();
        a = new Node("A");
        b = new Node("B");
        c = new Node("C");
        d = new Node("D");
        path = new ArrayList<>();
    }

    @Test
    void testNewGraphUtility() {
        assertTrue(utility instanceof GraphUtility);
    }

    @Test
    void testFindRouteSimpleGraph() throws AbsentNodeException {
        graph.nodes.add(a);
        assertEquals(Arrays.asList(a), utility.findPathDS(graph, a, a));
        utility.clearVisited();

        a.childes.add(b);
        graph.nodes.add(b);
        assertEquals(Arrays.asList(a, b), utility.findPathDS(graph, a, b));
        utility.clearVisited();

        b.childes.add(c);
        graph.nodes.add(c);
        assertEquals(Arrays.asList(a, b, c), utility.findPathDS(graph, a, c));
        utility.clearVisited();

        c.childes.add(d);
        graph.nodes.add(d);
        assertEquals(Arrays.asList(a, b, c, d), utility.findPathDS(graph, a, d));
        utility.clearVisited();
    }

    @Test
    void testFindRouteTreeLikeGraph() throws AbsentNodeException {
        graph.nodes.addAll(Arrays.asList(a, b, c, d));
        a.childes.add(b);
        a.childes.add(c);
        c.childes.add(d);
        assertEquals(Arrays.asList(a, c, d), utility.findPathDS(graph, a, d));
    }

    @Test
    void testFindRouteTreeLikeDirectedGraph() throws AbsentNodeException {
        graph.nodes.addAll(Arrays.asList(a, b, c, d));
        a.childes.add(b);
        a.childes.add(c);
        c.childes.add(a);
        c.childes.add(d);
        assertEquals(Arrays.asList(a, c, d), utility.findPathDS(graph, a, d));
    }

    @Test
    void testFindRoute() throws AbsentNodeException {
        // Create nodes
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        Node q = new Node("Q");
        Node r = new Node("R");
        Node s = new Node("S");

        // Add childes to nodes
        a.childes.addAll(Arrays.asList(b, c, f, g));
        b.childes.addAll(Arrays.asList(a, e, d));
        f.childes.addAll(Arrays.asList(a, h, i));
        g.childes.addAll(Arrays.asList(a, j));
        i.childes.addAll(Arrays.asList(f, k, l, m));
        j.childes.addAll(Arrays.asList(j, m));
        k.childes.add(s);
        l.childes.addAll(Arrays.asList(i, o));
        n.childes.addAll(Arrays.asList(j, q));
        p.childes.add(s);
        o.childes.addAll(Arrays.asList(l, p, q, r));
        q.childes.addAll(Arrays.asList(n, o));

        // Create list of nodes
        ArrayList<Node> nodes = new ArrayList<>(
                Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s));

        // Create graph instance
        Graph graph = new Graph();
        // Add nodes to graph
        graph.nodes.addAll(nodes);

        // Define paths between A and O nodes
        ArrayList<Node> pathAO1 = new ArrayList<>(Arrays.asList(a, f, i, l, o));
//        ArrayList<Node> pathAO2 = new ArrayList<>(Arrays.asList(a, g, j, n, q, o));

        GraphUtility utility = new GraphUtility();
        // Assert deep first search
        assertEquals(pathAO1, utility.findPathDS(graph, a, o));
    }

    @Test
    void testBuildMinimalHeightBinarySearchTreeFromOrderedIntegerElementArray() {
        int[] t1 = {1};
        Node result =  utility.binTreeFromArray(t1);
        assertEquals(1, result.value);

        int[] t2 = {1, 2};
        result = utility.binTreeFromArray(t2);
        assertEquals(2, result.value);
        assertEquals(1, result.left.value);

        int[] t3 = {1, 2, 3};
        result = utility.binTreeFromArray(t3);
        assertEquals(2, result.value);
        assertEquals(1, result.left.value);
        assertEquals(3, result.right.value);

        int[] t4 = {1, 2, 3, 4};
        result = utility.binTreeFromArray(t4);
        assertEquals(3, result.value);
        assertEquals(2, result.left.value);
        assertEquals(1, result.left.left.value);
        assertEquals(4, result.right.value);

        int[] t5 = {1, 2, 3, 4, 5};
        result = utility.binTreeFromArray(t5);
        assertEquals(3, result.value);
        assertEquals(2, result.left.value);
        assertEquals(1, result.left.left.value);
        assertEquals(5, result.right.value);
        assertEquals(4, result.right.left.value);

        int[] t6 = {1, 2, 3, 4, 5, 6};
        result = utility.binTreeFromArray(t6);
        assertEquals(4, result.value);
        assertEquals(2, result.left.value);
        assertEquals(1, result.left.left.value);
        assertEquals(3, result.left.right.value);
        assertEquals(6, result.right.value);
        assertEquals(5, result.right.left.value);

        int[] t7 = {1, 2, 3, 4, 5, 6, 7};
        result = utility.binTreeFromArray(t7);
        assertEquals(4, result.value);
        assertEquals(2, result.left.value);
        assertEquals(1, result.left.left.value);
        assertEquals(3, result.left.right.value);
        assertEquals(6, result.right.value);
        assertEquals(5, result.right.left.value);
        assertEquals(7, result.right.right.value);
    }
}
