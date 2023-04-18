package Model;

import Controller.ReadFile;

import java.util.ArrayList;

public class RedBlack<K extends Comparable<K>,V> {
    private Association<K, V> association;
    public Node root;
    private boolean isRed=true;

    public void createRB(String fpath){
        ArrayList<ArrayList<String>> array = ReadFile.text(fpath);
        for (ArrayList word: array){
            Association ass= new Association<>(word.get(0), word.get(1));
            insert(ass);
        }
    }
    public void insert(Association<K, V> association) {
        Node node = new Node(association, isRed);
        if (root == null) {
            root = node;
            node.isRed = false;
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (association.getKey().compareTo((K) parent.association.getKey()) < 0 ) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        node.parent = parent;
        if (association.getKey().compareTo((K) parent.association.getKey()) < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        fixInsert(node);
    }
    private void fixInsert(Node node) {
        while (node != root && node.parent.isRed) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.isRed = false;
    }
    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }
    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }
    public void show(Node root){
        if (root != null){
            if (root.left != null) {
                show(root.left);
            }
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println(root.association.getKey() + " || " + root.association.getValue());
            if (root.right != null) {
                show(root.right);
            }
        }
    }
}
