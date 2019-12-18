

public class Solution {
   public String[] findOcurrences(String text, String first, String second) {
      ArrayList<String> result = new ArrayList<>();
        String []split = text.split(" ");
        for(int index = 2; index < split.length; index++) {
            if(first.equals(split[index-2]) && second.equals(split[index - 1])) {
                result.add(split[index]);
            } 
        }
        return result.toArray(new String[0]);
    }
}
