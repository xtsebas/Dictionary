package Model;

public class Node<K, V> {
    private Association<K, V> association;
    boolean color;
    Node left;
    Node right;
    Node parent;

    public Node(Association<K, V> association, boolean color) {
        this.association = association;
        this.color=color;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
