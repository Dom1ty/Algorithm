package class018;

import java.util.Stack;

public class BinaryTreeTraversalIteration {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    // 先序打印所有节点，非递归版
    public static void preOrder(TreeNode head) {
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                System.out.println(cur.val);
                if(cur.right!= null){
                    stack.push(cur.right);
                }
                if(cur.left!= null){
                    stack.push(cur.left);
                }


            }
        }
    }

    // 中序打印所有节点，非递归版
    public static  void inOrder(TreeNode head){
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();

            while(!stack.isEmpty() || head != null){
                if(head.left != null){
                    stack.push(head);
                    head = head.left;
                }
                else{
                    head = stack.pop();
                    System.out.println(head.val);
                    head =  head.right;
                }
            }

        }
    }

    // 后序打印所有节点，非递归版
    // 这是用两个栈的方法
    public static void posOrderTwoStacks(TreeNode head) {
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect =new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                collect.push(cur);
                if(cur.left!= null){
                    stack.push(cur.left);
                }
                if(cur.right!= null){
                    stack.push(cur.right);
                }
            }
            //这里打印反转的
            while (!collect.isEmpty()){
                System.out.println(collect.pop().val + " ");
            }

        }
    }


    public static void posOrderOneStack(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            // 如果始终没有打印过节点，h就一直是头节点
            // 一旦打印过节点，h就变成打印节点
            // 之后h的含义 : 上一次打印的节点
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    // 有左树且左树没处理过
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    // 有右树且右树没处理过
                    stack.push(cur.right);
                } else {
                    // 左树、右树 没有 或者 都处理过了
                    System.out.print(cur.val + " ");
                    h = stack.pop();
                }
            }
            System.out.println();
        }
    }
}
