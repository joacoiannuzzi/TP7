package BinaryTree;

public interface Tree<T> {

    boolean isEmpty();
    Tree getLeft();
    Tree getRight();
    T getRoot();

}
