
public abstract class Node<K> {
    protected K key;

    protected Node() {
    }

    protected Node(K key) {
        this.key = key;
    }

    public abstract int getHeight();
    public abstract int getDepth();
}
