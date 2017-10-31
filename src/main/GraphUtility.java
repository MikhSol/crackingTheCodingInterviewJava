package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

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

    ArrayList<LinkedList> listOfDepth(Node tree) {
        ArrayList<LinkedList> result = new ArrayList<>();
        ArrayDeque<Node> bfsList = bfs(tree);
        int level = 0;
        int len = bfsList.size();
        while (len > 0) {
            LinkedList<Node> listForLevel = new LinkedList<>();
            double levelLen = pow(2, level);
            while (levelLen > 0 && len > 0) {
                listForLevel.add(bfsList.removeFirst());
                len--;
                levelLen--;
            }
            level++;
            if (listForLevel.size() > 0) result.add(listForLevel);
        }
        return result;
    }

    private ArrayDeque<Node> bfs(Node tree) {
        ArrayDeque<Node> result = new ArrayDeque<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(tree);
        while (!q.isEmpty()) {
            Node current = q.removeFirst();
            result.add(current);
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
        return result;
    }

    boolean isBalanced(Node node) {
        if (node.left == null && node.right == null) return true;
        int leftLen = 1;
        int rightLen = 1;
        if (node.left != null) leftLen += treeHeight(node.left);
        if (node.right != null) rightLen += treeHeight(node.right);
        return abs(leftLen-rightLen)<2;
    }

    private int treeHeight(Node node) {
        return listOfDepth(node).size();
    }
}
