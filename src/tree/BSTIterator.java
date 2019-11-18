package tree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> treeList;

    public BSTIterator(TreeNode root) {
        this.treeList = inOrder(root);
    }

    private List<Integer> inOrder(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) return list;
        if (node.left != null) {
            list.addAll(inOrder(node.left));
        }
        list.add(node.val);
        if (node.right != null) {
            list.addAll(inOrder(node.right));
        }
        return list;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return treeList.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !treeList.isEmpty();
    }


    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator obj = new BSTIterator(root);
        for (int i = 0; i < 5; i++) {
            int param_1 = obj.next();
            boolean param_2 = obj.hasNext();
            System.out.println(param_1 + "/" + param_2);
        }

    }
}
