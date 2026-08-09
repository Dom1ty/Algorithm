package class014;

import java.util.*;

public class StacksQueue {
    // https://leetcode.cn/problems/implement-queue-using-stacks/
    class MyQueue {
        public Stack<Integer> in;
        public Stack<Integer> out;
        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        // inToOut
        private  void inToOut(){
            // out空 才能倒        如果倒 in 必须倒完
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }


    //https://leetcode.cn/problems/implement-stack-using-queues/
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue= new LinkedList<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x); //执行size 次 出队入队
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


}
