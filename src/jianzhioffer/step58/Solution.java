package jianzhioffer.step58;


public class Solution {

    public String reverseWords(String s) {
        String res = "";
        int end = s.length() - 1;
        int start = s.length() - 1;

        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(start) == ' '|| start == 0){
                String substring = s.substring(start==0?start:start+1, end + 1);

                if (!"".equals(substring)&&!" ".equals(substring)){
                    res += substring+" ";
                }
                start--;
                end = start;
            }else {
                start--;
            }
        }

        return res.trim();
    }

}
