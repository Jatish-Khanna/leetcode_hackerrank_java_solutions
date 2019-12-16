

public class Solution {

public String defangIPaddr(String address) {
        int first = address.indexOf(".");
        int second = address.indexOf(".", first + 1);
        int third = address.indexOf(".", second + 1);
        //System.out.println(first+""+second+""+third);
        StringBuilder sb = new StringBuilder(address.substring(0, first));
        sb.append("[.]").append(address.substring(first + 1, second))
                        .append("[.]")
                        .append(address.substring(second + 1, third))
                        .append("[.]")
                        .append(address.substring(third + 1));
        return sb.toString();
        
    }
}
