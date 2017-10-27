package main;

import java.util.ArrayList;

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
                if (visited.contains(child)) {
                    continue;
                }
                path.addAll(findPathDS(graph, child, endNode));
                if (path.get(path.size() - 1) != endNode) {
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
}
