package jianzhioffer.step37;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return new String[0];
        }
        Set<String> res = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        dfs(s,res,"",visited);
        String [] a = new String[res.size()];
        return res.toArray(a );
    }

    private void dfs(String s, Set<String> res,String path,boolean[] visited){

        if(s.length() == path.length()){
            res.add(path);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(s,res,path+s.charAt(i),visited);
                visited[i] = false;
            }

        }

    }
}
