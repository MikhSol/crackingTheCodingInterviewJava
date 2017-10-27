package main;

import java.util.ArrayList;

class Node {
    ArrayList<Node> childes;
    String name;

    Node(String n) {
        name = n;
        childes = new ArrayList<>();
    }
}
