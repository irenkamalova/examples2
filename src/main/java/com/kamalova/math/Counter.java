package com.kamalova.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter {

    private List<Integer> array;
    private Integer number;
    private Integer solution = 0;

    public Integer getSolution() {
        return solution;
    }

    public Counter(Integer number, List<Integer> array) {
        this.number = number;
        this.array = array;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2);
        Integer number = 4;
        Counter counter = new Counter(number, list);
        counter.countChange(number, list);
        System.out.println(counter.solution);
    }

    private void countChange(Integer number, List<Integer> list) {
        Node root = new Node(number, number);

        for (Integer l : list) {
            Node node = new Node(l, l);
            root.getChilds().add(node);
            exploreNode(node);
        }

        printTree(root);

    }

    private void printTree(Node root) {
        System.out.println("Node is " + root.node);
        System.out.print("Childs is [");
        for(Node node : root.getChilds()) {
            System.out.print(node.node + " ");
        }
        System.out.println("]");
        for(Node node : root.getChilds()) {
            printTree(node);
        }

    }

    private void exploreNode(Node node) {
        for (Integer a : array) {
            if (node.node == number) {
                solution += 1;
                return;
            }
            if (node.node >= a) {
                if (node.parent + a < number) {
                    node.getChilds().add(new Node(node.parent + a, a));
                }
                if (node.parent + a == number) {
                    solution += 1;
                    // не обязательно, можно для проверки оставить:
                    node.getChilds().add(new Node(node.parent + a, a));
                }
            }
        }

        for (Node child : node.getChilds()) {
            exploreNode(child);
        }
    }

    private class Node {
        private Integer parent;
        private Integer node;
        private List<Node> childs;

        public Node(Integer parent, Integer node) {
            this.parent = parent;
            this.node = node;
            this.childs = new ArrayList<>();
        }

        public Integer getParent() {
            return parent;
        }

        public void setParent(Integer parent) {
            this.parent = parent;
        }

        public Integer getNode() {
            return node;
        }

        public void setNode(Integer node) {
            this.node = node;
        }

        public List<Node> getChilds() {
            return childs;
        }

        public void setChilds(List<Node> childs) {
            this.childs = childs;
        }
    }
}
