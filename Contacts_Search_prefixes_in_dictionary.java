import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ADD = "add";
    private static final String FIND = "find";
    static Map<String, Integer> dictionary = new HashMap<>();

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        scanner.nextLine();
        String queryInformation[];
        for (int query = 0; query < queries; query++) {
            queryInformation = scanner.nextLine().split(" ");
            switch (queryInformation[0]) {
            case ADD:
                appendAllPrefixes(queryInformation[1]);
                break;
            case FIND:
                System.out.println(findContacts(queryInformation[1]));
                break;
            }
        }
        scanner.close();
    }

    private static int findContacts(String contact) {

        return dictionary.getOrDefault(contact, 0);
    }

    private static void appendAllPrefixes(String contact) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int index = 0; index < contact.length(); index++) {
            sb.append(contact.charAt(index));
            count = dictionary.getOrDefault(sb.toString(), 0) + 1;
            dictionary.put(sb.toString(), count);
        }
    }
}
