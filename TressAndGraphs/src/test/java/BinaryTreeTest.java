import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class BinaryTreeTest {

    BST tree = new BST();

    @Test
    public void testInsert() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(10);
        tree.insert(8);
        tree.leverOrderTraversal(tree.root);
        //tree.inOrderTraversal(tree.root);

        BinaryNode temp = tree.root.left.right.right;

        System.out.println("Successor");
        System.out.println(tree.inOrderSuccessor(tree.root, temp));
    }

    @Test
    public void testIsBalanced() {
        System.out.println(tree.isBalanced(tree.root));
    }

    @Test
    public void testcommonAncestor() {
        System.out.println(tree.commonAncestor(1,6,tree.root));

        HashMap<Integer,LinkedList> map = tree.nodesAtDepth(tree.root);

        LinkedList D1 = map.get(0);
        LinkedList D2 = map.get(1);
        LinkedList D3 = map.get(2);

            System.out.println();
            System.out.print(D1.toString());
            System.out.println();
            System.out.print(D2.toString());
            System.out.println();
            System.out.print(D3.toString());

        System.out.println();
        //System.out.println("Zigzag");
        tree.inOrderTraversal(tree.root);

        }

    @Test
    public void testissubTree(){
        BST tree = new BST();

        tree.root = new BinaryNode<Integer>(10,null);
        tree.root.left = new BinaryNode<Integer>(11,null);;
        tree.root.left.left = new BinaryNode<Integer>(7,null);
        tree.root.right = new BinaryNode<Integer>(9,null);;
        tree.root.right.left = new BinaryNode<Integer>(15,null);
        tree.root.right.right = new BinaryNode<Integer>(8,null);

        BST tree2 = new BST();

        tree2.insert(11);
        tree2.insert(7);
        tree2.insert(12);

        System.out.println(tree.isSubTree(tree.root, tree2.root));
    }

    @Test
    public void testRandomNode(){
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(10);
        tree.insert(8);
        System.out.println(tree.getRandomNode().item);
    }

}