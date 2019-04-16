package treeApi;

import org.junit.Test;
import tree.BinaryTree;

import static org.junit.Assert.*;

public class TreeApiTest {

    private TreeApi<Integer> treeApi = new TreeApi<>();

    private BinaryTree<Integer> tree = new BinaryTree<>(5,
            new BinaryTree<>(1,
                    new BinaryTree<>(3),
                    new BinaryTree<>(9,
                            new BinaryTree<>(8),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(2)));

    private BinaryTree<Integer> tree2 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>())),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> tree3 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>(10))),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> tree1 = new BinaryTree<>(10,
            new BinaryTree<>(8,
                    new BinaryTree<>(3),
                    new BinaryTree<>(6,
                            new BinaryTree<>(5),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(3)));

    private BinaryTree<Integer> t = new BinaryTree<>();

    private BinaryTree<Integer> t1 = new BinaryTree<>(9,
            new BinaryTree<>(5),
            new BinaryTree<>(4));

    private BinaryTree<Integer> t2 = new BinaryTree<>(9,
            new BinaryTree<>(),
            new BinaryTree<>(4));

    @Test
    public void leaves(){
        assertEquals(2, treeApi.leaves(t1));
        assertEquals(4, treeApi.leaves(tree1));
    }

    @Test
    public void equals() {
        assertTrue(treeApi.equals(tree, tree));
        assertFalse(treeApi.equals(tree, tree1));
        assertTrue(treeApi.equals(t, t));
        assertFalse(treeApi.equals(t2, t1));
    }

    @Test
    public void isomorphic() {
        assertTrue(treeApi.isomorphic(tree, tree1));
        assertFalse(treeApi.isomorphic(t, tree1));
    }

    @Test
    public void similar() {
        assertFalse(treeApi.similar(tree, tree1));
        assertTrue(treeApi.similar(tree, tree2));
        assertFalse(treeApi.similar(tree, tree3));
    }

    @Test
    public void full() {
        assertFalse(treeApi.full(tree));
        assertFalse(treeApi.full(tree1));
        assertFalse(treeApi.full(tree2));
        assertFalse(treeApi.full(tree3));
        assertFalse(treeApi.full(t));
        assertTrue(treeApi.full(t1));
    }

    @Test
    public void complete() {
        assertTrue(treeApi.complete(tree3));
        assertFalse(treeApi.complete(tree));
    }

    @Test
    public void stable() {
        assertFalse(treeApi.stable(tree2));
        assertTrue(treeApi.stable(t));
        assertTrue(treeApi.stable(t1));
        assertTrue(treeApi.stable(tree1));
    }

    @Test
    public void frontier() {
        treeApi.showFrontier(tree);
    }

    @Test
    public void occursTree() {
        BinaryTree<Integer> g1 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>());
        BinaryTree<Integer> g2 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>(5));
        assertTrue(treeApi.occursTree(tree, g1));
        assertFalse(treeApi.occursTree(tree, g2));
    }

    @Test
    public void perLevel(){
        treeApi.perlevel(tree2);

    }

    @Test
    public void disk(){
        treeApi.saveOnDisk(tree);
        BinaryTree<Integer> j = treeApi.getFromDisk();
        assertTrue(treeApi.equals(tree, j));
        assertFalse(treeApi.equals(tree1, j));
    }

}