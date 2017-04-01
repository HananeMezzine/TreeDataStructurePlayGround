
public interface Tree<K, N> {

    void insert(K key);
    void delete(K key);
    N find(K key);

    N getSuccessor(K key);
    N getPredecessor(K key);
    N getMinimum();
    N getMaximum();

    int getHeight(N node);
    int getDepth(N node);
}
