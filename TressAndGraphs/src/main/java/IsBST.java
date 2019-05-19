
public class IsBST {

    public static boolean isBstImpl(BinaryNode root, int min, int max){
        if (root == null) {
            return true;
        }
        if(root.item.compareTo(min) < 0 || root.item.compareTo(max) > 0){
            return false;
        }
        else{
            return isBstImpl(root.left,min,(Integer)root.item) && isBstImpl(root.right,(Integer)root.item, max);
        }
    }

    public static boolean isBst(BinaryNode root) {
        return isBstImpl(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
