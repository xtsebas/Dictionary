package Model;

public class Node<K, V> {
    Association<K, V> association;
    boolean isRed;
    Node left;
    Node right;
    Node parent;
    int height;

    public Node(Association<K, V> association, boolean color) {
        this.association = association;
        this.isRed=color;
        this.height=1;
    }

}
