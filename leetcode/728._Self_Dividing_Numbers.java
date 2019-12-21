

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
       List<Integer> list = new ArrayList<>();
        for(int index = left; index <= right; index++) {
            if(isSelfDividing(index)) {
                list.add(index);
            }
        }
        return list;
    }
    
    public boolean isSelfDividing(int number) {
        int current;
        int num = number;
        while(num > 0) {
            current = num % 10;
            if(current == 0 || number % current != 0) {return false;}
            num /= 10;
        }
        return true;
    }
}
