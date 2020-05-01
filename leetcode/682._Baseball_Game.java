class Solution {
    public int calPoints(String[] ops) {
        ArrayDeque<Integer> values = new ArrayDeque<>();
        int result = 0;
        int cal;
        int last;
        for(String op : ops) {
            switch(op){
                case "C":
                    result -= values.pop();
                    break;
                case "D":
                    cal = values.peek() * 2;
                    // cal = cal * 2;
                    result += cal;
                    values.push(cal);
                    break;
                case "+":
                    last = values.pop();
                    cal = last + values.peek();
                    result += cal;
                    values.push(last);
                    values.push(cal);
                    break;
                default:
                    cal = Integer.parseInt(op);
                    result += cal;
                    values.push(cal);
            }
        }
        return result;
    }
}
