package jianzhioffer.step9;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 *
 */
public class CQueue {

    /**
     * 入队栈
     */
    private Stack<Integer> stackIn;

    /**
     * 出队栈
     */
    private Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public Integer deleteHead() {

        if (stackOut.isEmpty()){
            popIntoOut();
        }

        return stackOut.isEmpty()?-1:stackOut.pop();

    }

    private void popIntoOut(){
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

}
