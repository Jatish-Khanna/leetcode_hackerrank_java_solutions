

public class Solution {

  
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> dcCount = new HashMap<>();
        for(String domain : cpdomains) {
            String []count = domain.split(" ");
            int value = Integer.parseInt(count[0]);
            int index = 0;
            String sd = count[1];
            while(index >= 0) {
                sd = sd.substring(index);
                //System.out.println(sd);
                dcCount.put(sd, dcCount.getOrDefault(sd, 0) + value);
                index = sd.indexOf(".");
                index = index == -1 ? -1 : index + 1;
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> set : dcCount.entrySet()) {
            result.add(set.getValue()+ " "+set.getKey());
        }
        return result;
    }
}
