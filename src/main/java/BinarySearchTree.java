import java.util.Iterator;

import lombok.Getter;
import lombok.Setter;

public class BinarySearchTree<K extends Comparable<K>>
        implements Tree<K, BinarySearchTree<K>.BstNode<K>>, Iterable<BinarySearchTree<K>.BstNode<K>> {
    private BstNode<K> root;

    @Override
    public void insert(K key) {
    }

    @Override
    public void delete(K key) {
    }

    @Override
    public BstNode<K> find(K key) {
        BstNode<K> result = root;
        while (result != null && !key.equals(result.key)) {
            result = key.compareTo(result.key) < 0 ? result.leftChild : result.rightChild;
        }
        return result;
    }

    @Override
    public BstNode<K> getSuccessor(K key) {
        BstNode<K> node = find(key);
        if (node == null) {
            return null;
        }

        if (node.rightChild != null) {
            return getMinimum(node.rightChild);
        }

        BstNode<K> successor = node.parent;
        while (successor != null && successor.leftChild != node) {
            node = successor;
            successor = successor.parent;
        }

        return successor;
    }

    @Override
    public BstNode<K> getPredecessor(K key) {


        return null;
    }

    @Override
    public BstNode<K> getMinimum() {
        return getMinimum(root);
    }

    private BstNode<K> getMinimum(BstNode<K> node) {
        BstNode<K> min = root;
        while (min != null) {
            min = min.leftChild;
        }
        return min;
    }

    @Override
    public BstNode<K> getMaximum() {
        BstNode<K> max = root;
        while (max != null) {
            max = max.rightChild;
        }
        return max;
    }

    @Override
    public int getDepth(BstNode<K> node) {
        return 0;
    }

    @Override
    public int getHeight(BstNode<K> node) {
        return 0;
    }


    @Override
    public Iterator<BstNode<K>> iterator() {
        return new InOrderIterator();
    }

    public Iterator<BstNode<K>> getPreOrderIterator() {
        return new PreOrderIterator();
    }

    public Iterator<BstNode<K>> getPostOrderIterator() {
        return new PostOrderIterator();
    }


    @Getter
    @Setter
    class BstNode<K> extends Node<K> {
        private BstNode<K> leftChild;
        private BstNode<K> rightChild;
        private BstNode<K> parent;

        public BstNode() {
        }

        public BstNode(K key) {
            super(key);
        }
    }

    private class InOrderIterator
            implements Iterator<BstNode<K>> {

        public boolean hasNext() {
            return false;
        }

        public BstNode<K> next() {
            return null;
        }
    }

    private class PreOrderIterator
            implements Iterator<BstNode<K>> {

        public boolean hasNext() {
            return false;
        }

        public BstNode<K> next() {
            return null;
        }

    }

    private class PostOrderIterator
            implements Iterator<BstNode<K>> {

        public boolean hasNext() {
            return false;
        }

        public BstNode<K> next() {
            return null;
        }

    }


}
