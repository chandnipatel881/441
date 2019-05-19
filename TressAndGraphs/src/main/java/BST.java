import java.util.*;

public class BST<T extends Comparable<T>> {

    BinaryNode<T> root;
    HashMap<BinaryNode, BinaryNode> parentMap = new HashMap<BinaryNode, BinaryNode>();
    int size;

    public void insert(T item) {
        root = insertImpl(root, item, null);
    }

    private BinaryNode insertImpl(BinaryNode root, T item, BinaryNode parentNode) {
        if (root == null) {
            root = new BinaryNode<T>(item, parentNode);
            size++;
        }
        if (item.compareTo((T) root.item) < 0) {
            root.left = insertImpl(root.left, item, root);
        } else if (item.compareTo((T) root.item) > 0) {
            root.right = insertImpl(root.right, item, root);
        }
        return root;
    }

    private T minInTree(BinaryNode root) {
        if (root == null) {
            return null;
        }
        BinaryNode currentNode = root;
        T min = (T) currentNode.item;
        while (currentNode.left != null) {
            min = (T) currentNode.item;
            currentNode = currentNode.left;
        }
        return min;
    }

    public T inOrderSuccessor(BinaryNode root, BinaryNode node) {
        if (find(root, (T) node.item) == null) {
            return null;
        }
        if (node.right != null) {
            return minInTree(node.right);
        } else {
            BinaryNode p = node.parent;
            while (p != null && p.right == node) {
                node = p;
                p = p.parent;
            }
            return (T) p.item;
        }
    }

    public boolean isBalanced(BinaryNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.right) && isBalanced(root.left)) {
            return true;
        }
        return false;
    }

    public T find(BinaryNode root, T item) {
        BinaryNode temp = findImpl(root, item);
        if (temp != null) {
            return (T) temp.item;
        }
        return null;
    }

    private BinaryNode findImpl(BinaryNode root, T item) {
        if (root == null) {
            return null;
        }
        if (root.item.compareTo(item) > 0) {
            return findImpl(root.right, item);
        } else if (root.item.compareTo(item) < 0) {
            return findImpl(root.left, item);
        } else {
            return root;
        }
    }

    public T commonAncestor(T node1, T node2, BinaryNode root) {
        if (root == null) {
            return null;
        }
        if (root.item.compareTo(node1) < 0 && root.item.compareTo(node2) < 0) {
            return commonAncestor(node1, node2, root.right);
        } else if (root.item.compareTo(node1) > 0 && root.item.compareTo(node2) > 0) {
            return commonAncestor(node1, node2, root.left);
        } else {
            if (find(root, node1) == null || find(root, node2) == null) {
                return null;
            }
            return (T) root.item;
        }
    }

    public void zigzagTraversal(BinaryNode root) {
        HashMap<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
        nodesAtDepthImpl(root, 0, map);
        for (int i = 0; i < map.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(map.get(i).toString());
            } else {
                Collections.reverse(map.get(i));
                System.out.println(map.get(i).toString());
            }
        }
    }

    public void nodesAtDepthImpl(BinaryNode root, int depth, HashMap<Integer, LinkedList> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, new LinkedList());
        }
        map.get(depth).add(root.item);
        depth++;
        nodesAtDepthImpl(root.left, depth, map);
        nodesAtDepthImpl(root.right, depth, map);
    }

    public HashMap<Integer, LinkedList> nodesAtDepth(BinaryNode root) {
        HashMap<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
        nodesAtDepthImpl(root, 0, map);
        return map;
    }

    public int height(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.right), height(root.left));
    }

    public void inOrderTraversal(BinaryNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.item);
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.item);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void postOrderTraversal(BinaryNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.item);
    }

    public void leverOrderTraversal(BinaryNode root) {
        Queue<BinaryNode> myqueue = new LinkedList<BinaryNode>();
        if (root == null) {
            return;
        }
        myqueue.add(root);
        while (!myqueue.isEmpty()) {
            BinaryNode tempNode = myqueue.poll();
            System.out.print(tempNode.item);
            if (tempNode.left != null) {
                myqueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                myqueue.add(tempNode.right);
            }
            System.out.println();
        }
    }

    public boolean isSubTreeImpl(BinaryNode root1, BinaryNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.item.compareTo(root2.item) == 0) {
            return isSubTreeImpl(root1.left, root2.left) && isSubTreeImpl(root1.right, root2.right);
        }
        return false;
    }

    public boolean isSubTree(BinaryNode root1, BinaryNode root2) {
        if (root2 == null) {
            return false;
        }
        BinaryNode foundSubTreeNode = findImpl(root1, (T) root2.item);
        if (foundSubTreeNode != null) {
            return isSubTreeImpl(foundSubTreeNode, root2);
        }
        return false;
    }

    private int size(BinaryNode root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    private BinaryNode getithNode(int i, BinaryNode root){
        if(root == null){
            return null;
        }
        int leftTreeSize = size(root.left);
        if (i == leftTreeSize + 1) {
            return root;
        }
        if(i <= leftTreeSize){
            return getithNode(i, root.left);
        }
        else{
            return getithNode(i - leftTreeSize - 1, root.right);
        }
    }

    public BinaryNode getRandomNode(){
        Random rand = new Random();
        int sizeOfRoot = size(root);
        int i = rand.nextInt(sizeOfRoot - 1) + 1;
        System.out.println("Random : " + i);
        return getithNode(i, root);
    }
}