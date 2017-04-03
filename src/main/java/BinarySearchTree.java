import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
        BstNode<K> node = find(key);
        if (node == null) {
            return null;
        }

        if (node.leftChild != null) {
            return getMaximum(node.leftChild);
        }

        BstNode<K> predecessor = node.parent;
        while (predecessor != null && predecessor.rightChild != node) {
            node = predecessor;
            predecessor = predecessor.parent;
        }
        return predecessor;
    }

    @Override
    public BstNode<K> getMinimum() {
        return getMinimum(root);
    }

    private BstNode<K> getMinimum(BstNode<K> node) {
        BstNode<K> min = node;
        while (min != null) {
            min = min.leftChild;
        }
        return min;
    }

    @Override
    public BstNode<K> getMaximum() {
        return getMaximum(root);
    }

    private BstNode<K> getMaximum(BstNode<K> node) {
        BstNode<K> max = node;
        while (max != null) {
            max = max.rightChild;
        }
        return max;
    }

    public int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(BstNode<K> node) {
        if (node == null) return 0;
        return Math.max(getHeightRecursive(node.leftChild), getHeightRecursive(node.rightChild)) + 1;
    }

    private int getHeightIterative(BstNode<K> node) {
        if (node == null) {
            return 0;
        }

        int height = 0;
        Queue<BstNode<K>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            height++;
            for (int i = 0; i < queue.size(); i++) {
                BstNode<K> n = queue.poll();
                if (n.leftChild != null) queue.offer(n.leftChild);
                if (n.rightChild != null) queue.offer(n.rightChild);
            }
        }
        return height;
    }

    private int getDepth(BstNode<K> node) {
        if (node == null) {
            return 0;
        }

        int depth = 1;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
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
