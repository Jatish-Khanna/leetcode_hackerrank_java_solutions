import java.util.List;
import java.util.ArrayList;

public class Solution {

  	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> list = new ArrayList<>();
		list.add(0,1);
		list.add(0,1000);
		list.add(1,100);
		list.add(0,0);
		System.out.println(list);
	}
}

// Output
// 0, 1000, 100, 1
