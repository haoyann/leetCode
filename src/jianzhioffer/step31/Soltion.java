package jianzhioffer.step31;

import java.util.Stack;

/**
 * 使用一个辅助栈模拟入栈情况
 * 再按照出栈顺序看能否出栈完成
 */
public class Soltion {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0){
            return true;
        }
        Stack<Integer> helper = new Stack<>();

        int index = 0;
        for(int i = 0; i < pushed.length; i++){
            helper.push(pushed[i]);
            while(!helper.empty() &&
                    index < popped.length &&
                    helper.peek()==popped[index]){
                helper.pop();
                index++;
            }
        }
        for(int i = index; i <popped.length; i++){
            if(helper.peek()==popped[i]){
                helper.pop();
            }
        }

        return helper.empty();

    }
}
