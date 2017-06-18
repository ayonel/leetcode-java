package classic;

/**
 * @author ayonel
 * @create 2017-06-18 13:57
 * @blog https://ayonel.me
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 **/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class DeepOfTree {
    static int count = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        solve(root, 1);
        return count;
    }

    public void solve(TreeNode root, int tmpCount) {
        if (root.left == null && root.right == null){
            count = Math.max(tmpCount, count);
            return;
        }
        if (root.left != null)
            solve(root.left, tmpCount+1);
        if (root.right != null)
            solve(root.right, tmpCount+1);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node2.right = node4;

        node1.right = node7;
        node7.left = node6;



        System.out.println(new DeepOfTree().TreeDepth(node1));
    }
}
