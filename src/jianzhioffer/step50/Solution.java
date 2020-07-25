package jianzhioffer.step50;

public class Solution {
    public char firstUniqChar(String s) {
        int[] dir = new int[26];
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            dir[c- 'a']++;
        }
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(dir[c - 'a'] == 1) return c;
        }

        return ' ';
    }
}
