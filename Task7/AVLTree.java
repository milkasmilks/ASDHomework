package AiSD.Task7;

public class AVLTree {
    private Node root;

    public AVLTree () {
        root = null;
    }

    private Node balance(Node node) {
        correctHeight(node);
        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        } else if (balanceFactor(node) == -2) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        } else {
            return node;
        }
    }

    public void addNode(int value) {
        root = putNode(root, value);
    }

    private Node putNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value > value) {
            node.left = putNode(node.left, value);
        } else if (node.value < value) {
            node.right = putNode(node.right, value);
        }
        node.height = 1 + getSize(node.left) + getSize(node.right);
        return balance(node);
    }

    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value > value) {
            node.left = deleteNode(node.left, value);
        } else if (node.value < value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                Node tempNode = node;
                node = getMin(tempNode.right);
                node.right = deleteMin(tempNode.right);
                node.left = tempNode.left;
                return balance(node);
            }
        }
        return balance(node);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.height = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    private Node rotateRight(Node node) {
        Node tempNode = node.left;
        node.left = tempNode.right;
        tempNode.right = node;

        correctHeight(node);
        correctHeight(tempNode);

        return tempNode;
    }

    private Node rotateLeft(Node node) {
        Node tempNode = node.right;
        tempNode.right = node.left;
        node.left = node;

        correctHeight(node);
        correctHeight(tempNode);

        return tempNode;
    }

    private int balanceFactor(Node node) {
        return getSize(node.right) - getSize(node.left);
    }

    private int getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    private void correctHeight(Node node) {
        if (getSize(node.left) > getSize(node.right)) {
            node.height = getSize(node.left) + 1;
        } else {
            node.height = getSize(node.right) + 1;
        }
    }


    public void print(Node node) {
        if (node != null) {
            print(node.left);
            node.printNode();
            print(node.right);
        }
    }


    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        private Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            height = 0;
        }

        public void printNode () {
            System.out.println(this.value);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.addNode(20);
        avlTree.addNode(15);
        avlTree.addNode(0);
        avlTree.addNode(25);
        avlTree.addNode(23);
        avlTree.addNode(28);
        avlTree.print(avlTree.root);
        avlTree.deleteNode(avlTree.root, 25);
        avlTree.print(avlTree.root);
    }
}
