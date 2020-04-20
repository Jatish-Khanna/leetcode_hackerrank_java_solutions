class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letLogs = new ArrayList<>();
        ArrayList<String> digiLogs = new ArrayList<>();

        String []split;
        for(String log : logs) {
            split = log.split(" ", 2);
            if(Character.isLetter(split[1].charAt(0))) {
                letLogs.add(log);
            } else {
                digiLogs.add(log);
            }
        }
        
        Collections.sort(letLogs, (s1, s2) -> {
            String []s1s = s1.split(" ", 2);
            String []s2s = s2.split(" ", 2);
           if(s1s[1].compareTo(s2s[1]) == 0) {
               return s1s[0].compareTo(s2s[0]);
           }
            return s1s[1].compareTo(s2s[1]);
        });
        
        String []result = new String[logs.length];
        int index = 0;
        for(String log : letLogs) {
            result[index++] = log;
        }
        for(String log : digiLogs) {
            result[index++] = log;
        }
        return result;
    }
}
