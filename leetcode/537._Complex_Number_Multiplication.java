class Solution {
    public String complexNumberMultiply(String a, String b) {
       int index = a.indexOf("+");
       int f1 = Integer.parseInt(a.substring(0, index));
        int f2 = Integer.parseInt(a.substring(index + 1, a.length() - 1));
        index = b.indexOf("+");
        int s1 = Integer.parseInt(b.substring(0, index));
        int s2 = Integer.parseInt(b.substring(index + 1, b.length() - 1));
        
        return  ((f1 * s1) + (f2 * s2 * -1)) + "+" + ((f1 * s2) + (s1 * f2)) + "i";
    }
}
