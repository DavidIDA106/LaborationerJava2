package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;

public class TestBinarySearch{
    private BinarySearchTree<Integer> tree;
    

    @BeforeEach
    public void setUp() throws Exception{
        tree = new BinarySearchTree<>();
    }
    @AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    void treeAdd(){
        assertTrue(tree.add(3), "Did not return true");
        assertTrue(tree.add(5), "couldnt add another");
        assertFalse(tree.add(3), "Managed to add the same number");
        
        
        assertEquals(2, tree.size(), "Wrong sizenumber");

    }

    @Test
    void treeHeight(){
        assertEquals(0, tree.height(), "Height was not zero");

        tree.add(3);
        tree.add(5);

        assertEquals(2, tree.height(), "Height was not 2");
    }

}
