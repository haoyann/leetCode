package jianzhioffer.step30;

import java.util.Stack;

/**
 * 使用辅助栈存放元素小的值
 */
public class MinStack {

    private Stack<Integer> normal;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);

        if(min.empty() || x <= min.peek()){
            min.push(x);
        }

    }

    public void pop() {
        int n = normal.pop();
        if(!min.empty() && n == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        if(min.empty()){
            return normal.peek();
        }
        return min.peek();
    }
}
