package Model;

import Controller.ReadFile;

import java.util.*;

public class RedBlack<K extends Comparable<K>,V> implements IMap<K,V>{
    private Association<K, V> association;
    Scanner in= new Scanner(System.in);
    public Node root;
    private Node flag;
    private boolean isRed=true;

    @Override
    public void create(String fpath){
        ArrayList<ArrayList<String>> array = ReadFile.text(fpath);
        for (ArrayList word: array){
            Association ass= new Association<>(word.get(0), word.get(1));
            root = insertNode(root, ass);
        }
    }

    @Override
    public Node insertNode(Node n, Association<K, V> association) {
        Node node = new Node(association, isRed);
        if (root == null) {
            root = node;
            node.isRed = false;
            return root;
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
        return root;
    }

    @Override
    public void fixInsert(Node node) {
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
                        leftRotate(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rightRotate(node.parent.parent);
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
                        rightRotate(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    @Override
    public int balanceFactor(Node node) {
        return 0;
    }

    @Override
    public int Height(Node node) {
        return 0;
    }

    @Override
    public Node leftRotate(Node node) {
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
        return flag;
    }

    @Override
    public Node rightRotate(Node node) {
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
        return flag;
    }

    @Override
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

    @Override
    public Node getRoot() {
        return root;
    }
}
