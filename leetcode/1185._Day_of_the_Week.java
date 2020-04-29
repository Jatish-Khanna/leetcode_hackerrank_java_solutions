class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int []diff = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        // {0,3,3,6,1,4,6,2,5,0,3,5}
        if(month < 3) {
            year -= 1;
        }
        int weekDay = (day + diff[month - 1] + year + year / 4 - year / 100 + year / 400) % 7;
        String []days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        return days[weekDay];
    }
}
