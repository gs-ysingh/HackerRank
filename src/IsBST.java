/**
 * Created by YSingh on 25/03/17.
 */

class Node {
    int data;
    Node left;
    Node right;
}

public class IsBST {
    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(checkBST(root));
    }

    public static boolean checkBST(Node root) {
        return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBSTUtil(Node root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }
        return root.data > minValue
                && root.data < maxValue
                && checkBSTUtil(root.left, minValue, root.data)
                && checkBSTUtil(root.right, root.data, maxValue);
    }
}
