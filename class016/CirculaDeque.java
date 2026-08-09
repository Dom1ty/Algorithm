package class016;

import java.util.Deque;
import java.util.LinkedList;

public class CirculaDeque {
    // https://leetcode.cn/problems/design-circular-deque/
    class MyCircularDeque1 {
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value){
            if(isFull()){
                return false;
            }
            size += 1;
            deque.offerFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            size += 1;
            deque.offerLast(value);
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            size -= 1;
            deque.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            size -= 1;
            deque.pollLast();
            return true;
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return deque.peekFirst();
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
    // 数组实现 更加高效
    class MyCircularDeque2 {
        int[] deque ;
        int l, r, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            l = r = size =  0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }else{
                if(isEmpty()){
                     l = r = 0;
                     deque[0] = value;
                }
                else{
                    l =  l == 0? limit -1 : l - 1;    // l = (l - 1 + limit) % limit;
                    deque[l] = value;
                }
                size += 1;
                return true;
            }

        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }else{
                if(isEmpty()){
                    l = r = 0;
                    deque[0] = value;
                }
                else{
                    r =  r == limit - 1 ? 0 : r + 1 ;    // r = (r + 1 + limit) % limit;
                    deque[r] = value;
                }
                size += 1;
                return true;
            }

        }


        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }else{
                int res = deque[l];
                l = l == limit - 1? 0 : l + 1;
                size -= 1;
                return true;
            }

        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }else{
                int res = deque[l];
                r = r == 0 ? limit - 1 : r - 1;
                size -= 1;
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return deque[l];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
