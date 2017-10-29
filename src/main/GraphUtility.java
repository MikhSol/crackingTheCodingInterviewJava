package main;

import java.util.ArrayList;
import java.util.Arrays;

class GraphUtility {
    static private ArrayList<Node> visited;

    GraphUtility() {
        visited = new ArrayList<>();
    }

    static ArrayList<Node> findPathDS(Graph graph, Node startNode, Node endNode)
            throws AbsentNodeException {
        try {
            isElementOfGraph(graph, startNode, "Start node is not element of graph");
            isElementOfGraph(graph, endNode, "End node is not element of graph");
            ArrayList<Node> path = new ArrayList<>();
            path.add(startNode);
            visited.add(startNode);

            for (Node child : startNode.childes) {
                if (!visited.contains(child)) {
                    path.addAll(findPathDS(graph, child, endNode));
                    if (path.get(path.size() - 1) != endNode)
                        path.remove(path.size() - 1);
                }
            }

            return path;
        } catch (AbsentNodeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static void isElementOfGraph(Graph graph, Node startNode, String message) throws AbsentNodeException {
        if (!graph.nodes.contains(startNode)) {
            throw new AbsentNodeException(message);
        }
    }

    void clearVisited() {
        visited.clear();
    }

    Node binTreeFromArray(int[] arr) {
        Node result = null;
        int len = arr.length;
        if (isSingleElementArray(len)) return new Node(arr[0]);
        if (len < 3) {
            result = new Node(arr[1]);
            result.left = binTreeFromArray(new int[]{arr[0]});
        }
        if (len > 2) {
            int rootIdx = len/2;
            result = new Node(arr[rootIdx]);
            result.left = binTreeFromArray(Arrays.copyOfRange(arr, 0, rootIdx));
            result.right = binTreeFromArray(Arrays.copyOfRange(arr, rootIdx+1, len));
        }
        return result;
    }

    private boolean isSingleElementArray(int len) {
        return len < 2;
    }
}
