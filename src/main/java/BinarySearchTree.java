import java.util.Iterator;

import lombok.Getter;
import lombok.Setter;

public class BinarySearchTree<K extends Comparable<K>>
        implements Tree<K, Node<K>>, Iterable<Node<K>> {
    private BstNode<K> root;

    @Override
    public void insert(K key) {
    }

    @Override
    public void delete(K key) {
    }

    @Override
    public Node<K> find(K key) {
        BstNode<K> result = root;
        while (result != null && !key.equals(result.key)) {
            result = key.compareTo(result.key) < 0 ? result.leftChild : result.rightChild;
        }
        return result;
    }

    @Override
    public Node<K> getSuccessor(K key) {
        return null;
    }

    @Override
    public Node<K> getPredecessor(K key) {
        return null;
    }

    @Override
    public Node<K> getMinimum() {
        return null;
    }

    @Override
    public Node<K> getMaximum() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Iterator<Node<K>> iterator() {
        return new InOrderIterator();
    }

    public Iterator<Node<K>> getPreOrderIterator() {
        return null;
    }

    public Iterator<Node<K>> getPostOrderIterator() {
        return null;
    }


    @Getter
    @Setter
    private class BstNode<K> extends Node<K> {
        private BstNode<K> leftChild;
        private BstNode<K> rightChild;
        private BstNode<K> parent;

        public BstNode() {
        }

        public BstNode(K key) {
            super(key);
        }

        @Override
        public int getHeight() {
            return 0;
        }
        @Override
        public int getDepth() {
            return 0;
        }
    }

    private class InOrderIterator
            implements Iterator<Node<K>> {

        public boolean hasNext() {
            return false;
        }

        public Node<K> next() {
            return null;
        }
    }

    private class PreOrderIterator
            implements Iterator<Node<K>> {

        public boolean hasNext() {
            return false;
        }

        public Node<K> next() {
            return null;
        }

    }

    private class PostOrderIterator
            implements Iterator<Node<K>> {

        public boolean hasNext() {
            return false;
        }

        public Node<K> next() {
            return null;
        }

    }


}
