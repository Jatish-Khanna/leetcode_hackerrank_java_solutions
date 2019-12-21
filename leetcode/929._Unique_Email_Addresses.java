

public class Solution {

     public int numUniqueEmails(String[] emails) {
        Set<String> setOfEmails = new HashSet<>();
        for(String email : emails) {
            int indexOfAt = email.indexOf('@');
            String localName = email.substring(0, indexOfAt);
            int indexOfPlus = localName.indexOf("+");
            if(indexOfPlus != -1) {
                localName = localName.substring(0, indexOfPlus);
            }
            localName = localName.replaceAll("\\.", "");
            setOfEmails.add(localName+email.substring(indexOfAt));
        }
        System.out.println(setOfEmails);
        return setOfEmails.size();
    }
}
