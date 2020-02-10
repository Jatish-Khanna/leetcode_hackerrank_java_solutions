

public class Solution {

  // Not using additional references - equal space and memory utilization
    public String addStrings(String num1, String num2) {
        //char []first = num1.toCharArray();
        //char []second = num2.toCharArray();
        int fI = num1.length() - 1;
        int sI = num2.length() - 1;
        
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int carry = 0;
        while(fI >= 0 && sI >= 0) {
            sum = carry + num1.charAt(fI) - 48 + num2.charAt(sI) - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            fI--;
            sI--;
        }
        while(fI >= 0 ) {
            sum = carry + num1.charAt(fI) - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            fI--;
        }
        
        while(sI >= 0 ) {
            sum = carry + num2.charAt(sI) - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            sI--;
        }
        if(carry > 0) {
            result.append(carry);
        }
        
        return result.length() == 0 ? "0" : result.reverse().toString();
    }
  
  // Additional references
      public String addStrings(String num1, String num2) {
        char []first = num1.toCharArray();
        char []second = num2.toCharArray();
        int fI = first.length - 1;
        int sI = second.length - 1;
        
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int carry = 0;
        while(fI >= 0 && sI >= 0) {
            sum = carry + first[fI] - 48 + second[sI] - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            fI--;
            sI--;
        }
        while(fI >= 0 ) {
            sum = carry + first[fI] - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            fI--;
        }
        
        while(sI >= 0 ) {
            sum = carry + second[sI] - 48;
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
            sI--;
        }
        if(carry > 0) {
            result.append(carry);
        }
        
        return result.length() == 0 ? "0" : result.reverse().toString();
    }
}
