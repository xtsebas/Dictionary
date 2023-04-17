package Model;

public class Node<K, V> {
    Association<K, V> association;
    boolean isRed;
    Node left;
    Node right;
    Node parent;

    public Node(Association<K, V> association, boolean color) {
        this.association = association;
        this.isRed=color;
    }

}
