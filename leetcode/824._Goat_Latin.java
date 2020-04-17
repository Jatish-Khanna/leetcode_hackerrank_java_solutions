class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vov = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        String []words = S.split(" ");
        String suffix = "a";
        String gl = "ma";
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            if(vov.contains(word.charAt(0))) {
                sb.append(word).append(gl).append(suffix).append(" ");
            } else{
                sb.append(word.substring(1)).append(word.charAt(0)).append(gl).append(suffix).append(" ");
            }
               suffix += "a";
               
        }
        return sb.substring(0, sb.length() - 1);
    }
}
