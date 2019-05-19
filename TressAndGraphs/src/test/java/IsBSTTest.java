import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IsBSTTest{

    @Test
    public void testIsBst() {
        BST tree = new BST();

        tree.root = new BinaryNode<Integer>(10,null);
        tree.root.left = new BinaryNode<Integer>(11,null);;
        tree.root.left.left = new BinaryNode<Integer>(7,null);
        tree.root.right = new BinaryNode<Integer>(9,null);;
        tree.root.right.left = new BinaryNode<Integer>(15,null);
        tree.root.right.right = new BinaryNode<Integer>(8,null);

        IsBST isbst = new IsBST();

        System.out.println(isbst.isBst(tree.root));

        BST tree2 = new BST();

        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(2);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(10);
        tree2.insert(8);
        //tree.leverOrderTraversal(tree.root);
        //tree.inOrderTraversal(tree.root);

        //BinaryNode temp = tree.root.left.right.right;

        //System.out.println("Successor");
        System.out.println(isbst.isBst(tree2.root));

    }
}