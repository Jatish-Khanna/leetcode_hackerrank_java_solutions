class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
        
        int odd = 1;
        int even = 1;
        HashSet<String> set = new HashSet<>();
        for(String word : A) {
            char []ch = word.toCharArray();
            odd = 1;
            even = 1;
            
        for(int index = 0; index < ch.length; index++) {
            if(index % 2 == 0) {
                even *= (int)ch[index];
            } else {
                odd *= (int)ch[index];
            }
        }
        set.add(even+""+odd);
        }
        return set.size();
        
    }
}
