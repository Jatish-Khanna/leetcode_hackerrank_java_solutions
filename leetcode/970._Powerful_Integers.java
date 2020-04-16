class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int sum = 0;
        Set<Integer> list = new HashSet<>();
        for(int i = 0; Math.pow(x,i) <= bound; i++) {
            for(int j = 0; Math.pow(y,j) <= bound; j++) {
                sum = (int)(Math.pow(x,i) + Math.pow(y, j));
                if(sum <= bound) {
                    list.add(sum);
                } else if(sum > bound) {
                    break;
                }
                
                if(y == 1) {
                    break;
                }
            }
            if(x == 1) {
                break;
            }
        }
        return new ArrayList<>(list);
    }
}
