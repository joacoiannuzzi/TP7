package treeApi;

import org.junit.Test;
import tree.BinaryTree;

import static org.junit.Assert.*;

public class TreeApiTest {

    private TreeApi<Integer> tp7 = new TreeApi<Integer>();

    private BinaryTree<Integer> tree = new BinaryTree<>(5,
            new BinaryTree<>(1, new BinaryTree<>(3), new BinaryTree<>(9, new BinaryTree<>(8), new BinaryTree<>())),
            new BinaryTree<>(7, new BinaryTree<>(6), new BinaryTree<>(2)));

    private BinaryTree<Integer> tree2 = new BinaryTree<>(8,
            new BinaryTree<>(7, new BinaryTree<>(6), new BinaryTree<>(9, new BinaryTree<>(2), new BinaryTree<>())),
            new BinaryTree<>(3, new BinaryTree<>(5), new BinaryTree<>(1)));

    private BinaryTree<Integer> tree3 = new BinaryTree<>(8,
            new BinaryTree<>(7, new BinaryTree<>(6), new BinaryTree<>(9, new BinaryTree<>(2), new BinaryTree<>(10))),
            new BinaryTree<>(3, new BinaryTree<>(5), new BinaryTree<>(1)));

    private BinaryTree<Integer> tree1 = new BinaryTree<>(10,
            new BinaryTree<>(8, new BinaryTree<>(3), new BinaryTree<>(6, new BinaryTree<>(5), new BinaryTree<>())),
            new BinaryTree<>(7, new BinaryTree<>(6), new BinaryTree<>(3)));

    private BinaryTree<Integer> t = new BinaryTree<>();

    private BinaryTree<Integer> t1 = new BinaryTree<>(9, new BinaryTree<>(5), new BinaryTree<>(4));
    private BinaryTree<Integer> t2 = new BinaryTree<>(9, new BinaryTree<>(), new BinaryTree<>(4));

    @Test
    public void leaves(){
        assertEquals(2,tp7.leaves(t1));
        assertEquals(4,tp7.leaves(tree1));
    }

    @Test
    public void equals() {
        assertTrue(tp7.equals(tree, tree));
        assertFalse(tp7.equals(tree, tree1));
        assertTrue(tp7.equals(t, t));
        assertFalse(tp7.equals(t2, t1));
    }

    @Test
    public void isomorphic() {
        assertTrue(tp7.isomorphic(tree, tree1));
        assertFalse(tp7.isomorphic(t, tree1));
    }

    @Test
    public void similar() {
        assertFalse(tp7.similar(tree, tree1));
        assertTrue(tp7.similar(tree, tree2));
        assertFalse(tp7.similar(tree, tree3));
    }

    @Test
    public void full() {
        assertFalse(tp7.full(tree));
        assertFalse(tp7.full(tree1));
        assertFalse(tp7.full(tree2));
        assertFalse(tp7.full(tree3));
        assertFalse(tp7.full(t));
        assertTrue(tp7.full(t1));
    }

    @Test
    public void complete() {
        assertTrue(tp7.complete(tree3));
        assertFalse(tp7.complete(tree));
    }

    @Test
    public void stable() {
        assertFalse(tp7.stable(tree2));
        assertTrue(tp7.stable(t));
        assertTrue(tp7.stable(t1));
        assertTrue(tp7.stable(tree1));
    }

}