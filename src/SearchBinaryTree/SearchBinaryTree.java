package SearchBinaryTree;

import SearchBinaryTreeApi.Tree;

public class SearchBinaryTree<T> implements Tree<T> {

    DoubleNode<T> root;

    public SearchBinaryTree(){
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

    public boolean exist(Comparable<T> x){
        return exist(root, x);
    }

    public T getMin(){
        return getMin(root).elem;
    }

    public T getMax(){
        return getMax(root).elem;
    }

    public T search(Comparable<T> x){
        return search(root, x).elem;
    }

    public void insert(Comparable<T> x){
        root = insert(root, x);
    }

    public void remove(Comparable<T> x){
        root = remove(root, x);
    }

    private boolean exist(DoubleNode<T> t, Comparable<T> x){
        if(t == null){
            return false;
        }
        if(x.compareTo(t.elem) == 0){
            return true;
        } else if(x.compareTo(t.elem) < 0){
            return exist(root.left, x);
        } else{
            return exist(root.right, x);
        }
    }

    private DoubleNode<T> getMin(DoubleNode<T> t){
        if(t.left == null){
            return t;
        }
        return getMin(t.left);
    }

    private DoubleNode<T> getMax(DoubleNode<T> t){
        if(t.right == null){
            return t;
        }
        return getMax(t.right);
    }

    private DoubleNode<T> search(DoubleNode<T> t, Comparable<T> x){
        if (t == null)
            throw new RuntimeException("Not found");
        if(x.compareTo(t.elem) == 0){
            return t;
        }else if(x.compareTo(t.elem) < 0){
            return search(t.left, x);
        } else {
            return search(t.right, x);
        }
    }

    private DoubleNode<T> insert(DoubleNode<T> t, Comparable<T> x){
        if (x.compareTo(t.elem) == 0)
            throw new RuntimeException("The element is already in the tree");
        if(t == null){
            t = new DoubleNode<T>();
            t.elem = (T) x;
        } else if(x.compareTo(t.elem) < 0){
            t.left = insert(t.left, x);
        } else {
            t.right = insert(t.right, x);
        }
        return t;
    }

    private DoubleNode<T> remove(DoubleNode<T> t, Comparable<T> x){
        if (t == null)
            throw new RuntimeException("Not found");
        if(x.compareTo(t.elem) < 0){
            t.left = remove(t.left, x);
        } else if(x.compareTo(t.elem) > 0){
            t.right = remove(t.right, x);
        } else {
            if(t.left != null && t.right != null){
                t.elem = getMin(t.right).elem;
                t.right = removeMin(t.right);
            }else if(t.left != null){
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return t;
    }

    private DoubleNode<T> removeMin(DoubleNode<T> t){
        if(t.left != null){
            t.left = removeMin(t.left);
        } else{
            t = t.right;
        }
        return t;
    }
}
