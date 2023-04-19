package Model;

public class Node<K, V> {
    public Association<K, V> association;
    boolean isRed;
    public Node left;
    public Node right;
    public Node parent;
    public int height;

    public Node(Association<K, V> association, boolean color) {
        this.association = association;
        this.isRed=color;
        this.height=1;
    }

}
