package main;

import java.util.ArrayList;

class Node {
    ArrayList<Node> childes;
    Object value;
    Node left;
    Node right;

    Node(Object n) {
        value = n;
        childes = new ArrayList<>();
    }
}
