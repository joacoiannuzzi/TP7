package tree;

public class BinaryTree<T> {

    private DoubleNode<T> root;

    public BinaryTree() {
        root = null;
    }
    public BinaryTree(T o) {
        root = new DoubleNode(o);
    }

    public BinaryTree(T o, BinaryTree<T> left, BinaryTree<T> right) {
        root = new DoubleNode<T>(o, left.root, right.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.elem;
    }

    public BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.left;
        return t;
    }

    public BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.right;
        return t;

    }

    private class DoubleNode <T> {

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
