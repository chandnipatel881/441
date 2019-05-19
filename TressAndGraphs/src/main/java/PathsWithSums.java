import java.util.ArrayList;

public class PathsWithSums {

    private static int addKAndCountT(ArrayList<Integer> list, int k, int t){

        int countT = 0;

        for(int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + k);
            if(list.get(i) == t){
                countT++;
            }
        }
        return countT;
    }

    private static void totalPathsWithSumImpl(ArrayList<Integer> list, int[] count, int targetSum, BinaryNode<Integer> root){
        if(root == null) {
            return;
        }
        count[0] += addKAndCountT(list, root.item, targetSum);
        list.add(root.item);
        totalPathsWithSumImpl(list,count,targetSum,root.left);
        totalPathsWithSumImpl(list,count,targetSum,root.right);
        addKAndCountT(list, root.item * -1, targetSum);
        list.remove(root.item);
    }

    public static int totalPathsWithSum(BinaryNode<Integer> root, int targetSum){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] count = new int[1];
        totalPathsWithSumImpl(list, count, targetSum, root);
        return count[0];
    }

    public static void main(String[] args){

        BST<Integer> tree = new BST<Integer>();
        tree.root = new BinaryNode<Integer>(10,null);
        tree.root.left = new BinaryNode<Integer>(5,null);;
        tree.root.left.left = new BinaryNode<Integer>(3,null);
        tree.root.left.left.left = new BinaryNode<Integer>(3,null);
        tree.root.left.left.right = new BinaryNode<Integer>(-2,null);
        tree.root.left.right = new BinaryNode<Integer>(2,null);
        tree.root.left.right.right = new BinaryNode<Integer>(1,null);
        tree.root.right = new BinaryNode<Integer>(-3,null);;
        tree.root.right.right = new BinaryNode<Integer>(11,null);

        System.out.println(totalPathsWithSum(tree.root, 3));
    }

}
