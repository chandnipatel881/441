public class BSTWithMinimalHeightFromArray {

    public static void addToTree(int[] arr, int first, int last, BST tree){
        if(last < first){
            return;
        }
        int middle = (first + last)/2;
        tree.insert(arr[middle]);
        addToTree(arr, first,middle - 1, tree);
        addToTree(arr,middle + 1, last, tree);
    }

    public static BST bstWithMinimalHeight(int[] arr){
        BST tree = new BST();
        addToTree(arr, 0, arr.length-1, tree);
        return tree;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};

        BST tree = bstWithMinimalHeight(arr);

        tree.inOrderTraversal(tree.root);
    }
}
