package class013;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackAndCirculaQueue {

    public class Queue1{
        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty(){
            return queue.isEmpty();
        }
        //向队列尾巴加入 num
        public void offer(int num){
            queue.offer(num);
        }

        //拿数 从头拿
        public int poll(){
            return queue.poll();
        }
        // 返回头部元素但是不弹出
        public int peek(){
            return queue.peek();
        }


    }

    public class Queue2{
        int[] queue;
        int l;
        int r;

        public Queue2(int N){
            queue = new int[N];
            l = 0;
            r = 0;
        }

        public boolean isEmpty(){
            return l == r;
        }

        public void offer(int num){
            queue[r++] = num;
        }

        public int poll(){
            return queue[l++];
        }

        public int head(){
            return queue[l];
        }

        public int tail(){
            return queue[r - 1];
        }

        public int size(){
            return r - l;
        }

    }

    public class Stack2{
        public int[] stack;
        public  int size;

        public Stack2(int n){
            stack = new int[n];
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void push(int num){
            stack[size++] = num;
        }

        public int pop(){
            return stack[--size];
        }

        public int peek(){
            return stack[size-  1];
        }
    }


    // https://leetcode.cn/problems/design-circular-queue/
    class MyCircularQueue {
        int[] queue ;
        int l ,  r ,size, limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }


        // 向循环队列插入一个元素。如果成功插入则返回真。  尾巴
        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            queue[r++] = value;
            size += 1;
            r = r % limit == 0? 0 : r;
            return true;
        }
        // 从循环队列中删除一个元素。如果成功删除则返回真。 头
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            size -= 1;
            l += 1;
            l = l % limit == 0 ? 0 : l;
            return true;
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if(isEmpty()){
                return  -1;
            }
            return queue[(r - 1 + limit) % limit];

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return  size == limit;
        }
    }

}
