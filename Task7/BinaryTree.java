package AiSD.Task7;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = addNode(node.left, value);
        } else if (value > node.value) {
            node.right = addNode(node.right, value);
        }

        return node;
    }

    public void dfs(Node node) {
        if (node != null) {
            dfs(node.left);
            System.out.print(" " + node.value);
            dfs(node.right);
        }
    }

    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            Node tempNode = nodes.remove();
            System.out.print(" " + tempNode.value);

            if (tempNode.left != null) {
                nodes.add(tempNode.left);
            }
            if (tempNode.right != null) {
                nodes.add(tempNode.right);
            }
        }
    }


    private class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);

        binaryTree.dfs(binaryTree.root);
        System.out.println();
        binaryTree.bfs(binaryTree.root);


    }
}
