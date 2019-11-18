package tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderSort {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = inOrder(root);
        return result;
    }

    private List<Integer> inOrder(TreeNode node) {
        List<Integer> valList = new ArrayList<>();
        if (node == null) return valList;
        if (node.left != null) {
            valList.addAll(inOrder(node.left));
        }
        valList.add(node.val);
        if (node.right != null) {
            valList.addAll(inOrder(node.right));
        }
        return valList;
    }

}
