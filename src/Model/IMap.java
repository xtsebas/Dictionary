package Model;

public interface IMap<K extends Comparable<K>, V> {

    public void create(String fpath);

    public Node insertNode(Node node, Association<K,V> association);

    void fixInsert(Node node);

    int balanceFactor(Node node);

    int Height(Node node);

    Node leftRotate(Node node);

    Node rightRotate(Node node);

    public void show (Node root);

    public Node getRoot();
}
