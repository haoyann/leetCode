package jianzhioffer.step59II;


import java.util.ArrayList;
import java.util.List;

public class MaxQueue {

    private List<Integer> queue;

    private List<Integer> helper;

    public MaxQueue() {
        queue = new ArrayList<>();
        helper = new ArrayList<>();
    }

    public int max_value() {


        if(helper.isEmpty()){
            return -1;
        }

        return helper.get(0);
    }

    public void push_back(int value) {
        if (helper.isEmpty()){
            helper.add(value);
            queue.add(value);
            return;
        }
        int last = helper.get(helper.size() - 1);
        if (value <= last){
            helper.add(value);
        }else {
            while (true) {
                if (helper.isEmpty()){
                    break;
                }
                last = helper.get(helper.size() - 1);
                if(last < value){
                    helper.remove(helper.size() - 1);
                }else {
                    break;
                }
            }
            helper.add(value);
        }
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int remove = queue.remove(0);
        if (!helper.isEmpty() &&  helper.get(0)==remove){
            helper.remove(0);
        }
        return remove;
    }
}
