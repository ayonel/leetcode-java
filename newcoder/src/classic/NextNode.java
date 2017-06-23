package classic;

import java.util.ArrayList;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-19 13:35
 * @blog https://ayonel_113_PathSumII.me
 *
 * 没必要完整的遍历树
 *
 **/
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        //先找出父节点
        TreeLinkNode root = pNode;
        while(root.next != null) {
            root = root.next;
        }

        //中序遍历数
        ArrayList<TreeLinkNode> res = new ArrayList<>();
        inTraval(root, res, pNode);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).val == pNode.val){
                if (i < res.size()-1)
                    return res.get(i+1);
            }
        }
        return null;


    }

    public void inTraval(TreeLinkNode root, ArrayList<TreeLinkNode> res, TreeLinkNode node) {

        if (root.left != null)
            inTraval(root.left, res, node);
        if (res.size() > 0 && res.get(res.size()-1) == node) {
            res.add(root);
        } else {
            res.add(root);
        }
        if (root.right != null)
            inTraval(root.right, res, node);

    }

    TreeLinkNode GetNextStandard(TreeLinkNode node)
    {
        if(node==null) return null;
        if(node.right!=null){//如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;//退到了根节点仍没找到，则返回null
    }

    public static void main(String[] args) {
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node11= new TreeLinkNode(11);

        node8.left = node6;
        node6.next = node8;
        node8.right = node10;
        node10.next = node8;
        node6.left = node5;
        node5.next = node6;
        node6.right = node7;
        node7.next = node6;
        node10.left = node9;
        node9.next = node10;
        node10.right = node11;
        node11.next = node10;

        System.out.println(new NextNode().GetNext(node8).val);

    }
}
