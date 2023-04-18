package Model;

import Controller.ReadFile;

import java.util.ArrayList;

public class AVL<K extends Comparable<K>, V> {
    public Node root;

    public void create(String fpath) {
        ArrayList<ArrayList<String>> array = ReadFile.text(fpath);
        for (ArrayList word: array){
            Association association= new Association<>(word.get(0), word.get(1));
            root = insertNode(root, association);
        }
    }

    public Node insertNode(Node node, Association<K, V> association) {
        if (node == null) {
            return new Node(association, false);
        }
        if (association.getKey().compareTo((K) node.association.getKey()) < 0) {
            node.left = (insertNode(node.left, association));
        } else if (association.getKey().compareTo((K) node.association.getKey()) > 0) {
            node.right = (insertNode(node.right, association));
        } else {
            return node;
        }
        // Actualizar la altura del nodo
        if (node.left != null && node.right!=null){
            node.height = 1 + Math.max(node.left.height, node.right.height);
        } else if (node.left != null && node.right ==null) {
            node.height = 1 + Math.max(node.left.height, 0);
        } else if (node.left == null && node.right !=null){
            node.height = 1 + Math.max(0, node.right.height);
        }

        // Calcular el factor de balance del nodo
        int balanceFactor = balanceFactor(node);

        // Si el factor de balance es mayor que 1, el árbol está desequilibrado a la izquierda
        if (balanceFactor > 1) {
            // Si el factor de balance del subárbol izquierdo es menor que 0, se requiere una rotación doble a la derecha
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            node = rightRotate(node);
        }
        // Si el factor de balance es menor que -1, el árbol está desequilibrado a la derecha
        else if (balanceFactor < -1) {
            // Si el factor de balance del subárbol derecho es mayor que 0, se requiere una rotación doble a la izquierda
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            node = leftRotate(node);
        }
        return node;
    }

    private int balanceFactor(Node node) {
        if (node.left != null && node.right!=null){
            return node.left.height - node.right.height;
        } else if (node.left != null && node.right ==null) {
            return node.left.height - 0;
        } else if (node.left == null && node.right !=null){
            return 0 - node.right.height;
        }else {
            return 1;
        }
    }

    private int Height(Node node){
        if (node.left != null && node.right!=null){
            return node.height = 1 + Math.max(node.left.height, node.right.height);
        } else if (node.left != null && node.right ==null) {
            return node.height = 1 + Math.max(node.left.height, 0);
        } else if (node.left == null && node.right !=null){
            return node.height = 1 + Math.max(0, node.right.height);
        }else {
            return 0;
        }
    }
    private Node leftRotate(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        node.height = Height(node);
        newParent.height = Height(newParent);
        return newParent;
    }

    private Node rightRotate(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        node.height = Height(node);
        newParent.height = Height(newParent);
        return newParent;
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
