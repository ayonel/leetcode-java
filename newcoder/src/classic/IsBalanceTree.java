package classic;

import org.hamcrest.core.Is;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author ayonel
 * @create 2017-06-18 14:27
 * @blog https://ayonel.me
 * 解题思路：下面第一种解法，对每个左右子树计算高度差，这样造成了两遍递归，复杂度有些高
 *
 * 解法二只用一次后序遍历，在过程中更改类变量，只需要一次递归
 **/
public class IsBalanceTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
            return false;
        return IsBalanced_Solution(root.left) & IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        return Math.max(TreeDepth(pRoot.left), TreeDepth(pRoot.right)) + 1;
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

//        node1.right = node7;
//        node7.left = node6;



        System.out.println(new IsBalanceTree().IsBalanced_Solution(node1));
    }



    private boolean isBalanced=true;
    public boolean IsBalanced_Solution2(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;
    }
}
