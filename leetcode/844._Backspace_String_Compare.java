

public class Solution {


    public boolean backspaceCompare(String S, String T) {
        ArrayDeque<Character> ch = new ArrayDeque<>();
        for(char c : S.toCharArray()) {
            if(c != '#') {
                ch.push(c);
            } else if(!ch.isEmpty()){
                ch.pop();
            }
        }
        
        char ar[] = T.toCharArray();
        int current = ar.length - 1;
        int count;
        while(current >= 0) {
            if(ar[current] == '#') {
                count = 1;
                //--current;
                while(current > 0 && count > 0) {
                    --current;
                    if(ar[current] == '#'){
                        count++;
                    } else {
                        count--;
                    }
                    //current--;
                }
            } else {
                System.out.println(ar[current]);
                if(ch.isEmpty() || ar[current] != ch.pop()) {
                    return false;
                }
            }
            --current;
        }
        return ch.isEmpty() && current <= -1;
    }
}
