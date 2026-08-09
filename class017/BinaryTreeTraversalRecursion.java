package class017;

import java.util.*;

import static java.lang.Math.max;

//二叉树的遍历
public class BinaryTreeTraversalRecursion {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }


    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }


    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }


    public static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + " ");
    }

    // https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    // https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }

        preOrder(node.left, res);
        res.add(node.val);
        preOrder(node.right, res);
    }

    // https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }

        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }


    // 层序遍历 使用 队列进行  size 进行每一层数量多少记录
    // https://leetcode.cn/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> res1 = new ArrayList<>();
            while(size -- > 0){

                TreeNode temp = queue.poll();
                res1.add(temp.val);
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if( temp.right!= null){
                    queue.offer(temp.right);
                }

            }
            res.add(res1);
        }
        return res;
    }

    // https://leetcode.cn/problems/maximum-depth-of-binary-tree/ 最大深度 dfs 或者bfs bfs 直接套用层序遍历模板即可
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size -- > 0){

                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if( temp.right!= null){
                    queue.offer(temp.right);
                }

            }
            depth += 1;
        }
        return depth;
    }

}
