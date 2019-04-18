package BinaryTreeApi;

import org.junit.Test;
import BinaryTree.BinaryTree;

import static org.junit.Assert.*;

public class TreeApiTest {

    private TreeApi<Integer> treeApi = new TreeApi<>();

    private BinaryTree<Integer> longTree = new BinaryTree<>(5,
            new BinaryTree<>(1,
                    new BinaryTree<>(3),
                    new BinaryTree<>(9,
                            new BinaryTree<>(8),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(2)));

    private BinaryTree<Integer> longTree1 = new BinaryTree<>(10,
            new BinaryTree<>(8,
                    new BinaryTree<>(3),
                    new BinaryTree<>(6,
                            new BinaryTree<>(5),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(3)));

    private BinaryTree<Integer> longTree2 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>())),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> longTree3 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>(10))),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> longTree4 = new BinaryTree<>(10,
            new BinaryTree<>(5,
                    new BinaryTree<>(2,
                            new BinaryTree<>(1),
                            new BinaryTree<>()),
                    new BinaryTree<>()),
            new BinaryTree<>(4,
                    new BinaryTree<>(2),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> longTree5 = new BinaryTree<>(10,
            new BinaryTree<>(5,
                    new BinaryTree<>(2,
                            new BinaryTree<>(1),
                            new BinaryTree<>()),
                    new BinaryTree<>()),
            new BinaryTree<>(4,
                    new BinaryTree<>(2),
                    new BinaryTree<>(11)));


    private BinaryTree<Integer> shortTree1 = new BinaryTree<>(9,
            new BinaryTree<>(5),
            new BinaryTree<>(4));

    private BinaryTree<Integer> shortTree2 = new BinaryTree<>(9,
            new BinaryTree<>(),
            new BinaryTree<>(4));

    private BinaryTree<Integer> emptyTree = new BinaryTree<Integer>();

    @Test
    public void size(){
        assertEquals(0, treeApi.size(emptyTree));
        assertEquals(3, treeApi.size(shortTree1));
        assertEquals(7, treeApi.size(longTree4));
    }

    @Test
    public void occurrences(){
        assertEquals(0, treeApi.occurrences(shortTree1, 6));
        assertEquals(2, treeApi.occurrences(longTree4, 2));
        assertEquals(0, treeApi.occurrences(emptyTree, 0));
    }

    @Test
    public void elementsAtLevel(){
        assertEquals(2, treeApi.elementsAtLevel(shortTree1, 1));
        assertEquals(0, treeApi.elementsAtLevel(emptyTree, 0));
    }

    @Test
    public void leaves(){
        assertEquals(2, treeApi.leaves(shortTree1));
        assertEquals(4, treeApi.leaves(longTree1));
    }

    @Test
    public void height(){
        assertEquals(1, treeApi.height(shortTree1));
        assertEquals(3, treeApi.height(longTree2));
        assertEquals(-1, treeApi.height(emptyTree));
    }

    @Test
    public void sum(){
        assertEquals(18, treeApi.sum(shortTree1));
        assertEquals(48, treeApi.sum(longTree1));
    }

    @Test
    public void sumMultipleOf3(){
        assertEquals(9, treeApi.sumMultiplesOf3(shortTree1));
        assertEquals(18, treeApi.sumMultiplesOf3(longTree1));
    }

    @Test
    public void equals() {
        assertTrue(treeApi.equals(longTree, longTree));
        assertFalse(treeApi.equals(longTree, longTree1));
        assertTrue(treeApi.equals(emptyTree, emptyTree));
        assertFalse(treeApi.equals(shortTree2, shortTree1));
    }

    @Test
    public void isomorphic() {
        assertTrue(treeApi.isomorphic(longTree, longTree1));
        assertFalse(treeApi.isomorphic(emptyTree, longTree1));
    }

    @Test
    public void similar() {
        assertFalse(treeApi.similar(longTree, longTree1));
        assertTrue(treeApi.similar(longTree, longTree2));
        assertFalse(treeApi.similar(longTree, longTree3));
    }

    @Test
    public void full() {
        assertFalse(treeApi.full(longTree));
        assertFalse(treeApi.full(longTree1));
        assertFalse(treeApi.full(longTree2));
        assertFalse(treeApi.full(longTree3));
        assertFalse(treeApi.full(emptyTree));
        assertTrue(treeApi.full(shortTree1));
    }

    @Test
    public void complete() {
        assertTrue(treeApi.complete(longTree3));
        assertFalse(treeApi.complete(longTree));
    }

    @Test
    public void stable() {
        assertFalse(treeApi.stable(longTree2));
        assertTrue(treeApi.stable(emptyTree));
        assertTrue(treeApi.stable(shortTree1));
        assertTrue(treeApi.stable(longTree4));
        assertFalse(treeApi.stable(longTree5));
    }

    @Test
    public void frontier() {
        System.out.print("Frontier: ");
        treeApi.showFrontier(longTree);
        System.out.println();
    }

    @Test
    public void occursTree() {
        BinaryTree<Integer> g1 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>());
        BinaryTree<Integer> g2 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>(5));
        assertTrue(treeApi.occursTree(longTree, g1));
        assertFalse(treeApi.occursTree(longTree, g2));
    }

    @Test
    public void preOrder(){
        System.out.print("preOrder: ");
        treeApi.preorder(longTree2);
        System.out.println();

    }

    @Test
    public void inOrder(){
        System.out.print("inOrder: ");
        treeApi.inorder(longTree2);
        System.out.println();

    }

    @Test
    public void postOrder(){
        System.out.print("postOrder: ");
        treeApi.postorder(longTree2);
        System.out.println();

    }

    @Test
    public void perLevel(){
        System.out.print("perLevels: ");
        treeApi.perlevel(longTree2);
        System.out.println();

    }

    @Test
    public void saveOnDisk(){
        treeApi.saveOnDisk(longTree);
        BinaryTree<Integer> j = treeApi.getFromDisk();
        assertTrue(treeApi.equals(longTree, j));
        assertFalse(treeApi.equals(longTree1, j));
    }

}