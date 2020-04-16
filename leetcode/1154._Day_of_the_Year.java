class Solution {
    public int dayOfYear(String date) {
        String []d = date.split("-");
        int []days = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int month = Integer.parseInt(d[1]);
        int total = 0;
        
        //while(index < month) {
        total += days[month - 1] + Integer.parseInt(d[2]);
          //  index++;
        //}
        
        if(month > 2 && isLeapYear(Integer.parseInt(d[0])))
            total += 1;
        return total;
        //return (int)java.time.LocalDate.parse(date).getDayOfYear();
    }
    
    private boolean isLeapYear(int year) {
        return ((year & 3) == 0) && (year % 100) != 0 || (year % 400) == 0;
    }
}
