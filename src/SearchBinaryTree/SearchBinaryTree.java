package SearchBinaryTree;

import java.io.Serializable;

public class SearchBinaryTree<T> {
    private DoubleNode<T> root;

    private SearchBinaryTree(){
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.elem;
    }

    public SearchBinaryTree<T> getLeft() {
        SearchBinaryTree<T> t = new SearchBinaryTree<T>();
        t.root = root.left;
        return t;
    }

    public SearchBinaryTree<T> getRight() {
        SearchBinaryTree<T> t = new SearchBinaryTree<T>();
        t.root = root.right;
        return t;

    }

    public boolean exist(Comparable x){
        return true;
    }

    public T getMin(){
        return null;
    }

    public T getMax(){
        return null;
    }

    public T search(Comparable x){
        return null;
    }

    private class DoubleNode <T> implements Serializable {

        T elem;
        DoubleNode<T> right, left;

        public DoubleNode(T o) {
            elem = o;
        }

        public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
            elem = o;
            this.right = right;
            this.left = left;
        }
    }
}
