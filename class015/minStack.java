package class015;

import java.util.Stack;

public class minStack {


    class MinStack {
        public Stack<Integer> data;
        public Stack<Integer> min;
        public MinStack() {
            data  = new Stack<Integer>();
            min  = new Stack<Integer>();
        }

        public void push(int value) {
//            if(data.isEmpty() && min.isEmpty()) {
//                data.push(value);
//                min.push(value);
//                return;
//            }
//            if(min.peek() > value){
//                min.push(value);
//                data.push(value);
//            }
//            else{
//                min.push(min.peek());
//                data.push(value);
//            }
            data.push(value);
            if(min.isEmpty() || value <= min.peek()){
                min.push(value);
            }
            else{
                min.push(min.peek());
            }

        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
