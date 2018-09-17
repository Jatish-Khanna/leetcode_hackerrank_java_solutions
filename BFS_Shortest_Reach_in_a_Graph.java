import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. PrInteger output to
         * STDOUT. Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        Integer noOfTestCases = in.nextInt();
        for (Integer nextTest = 0; nextTest < noOfTestCases; nextTest++) {

            Integer nodes = in.nextInt();
            Integer edges = in.nextInt();

            LinkedList<Integer>[] graph = new LinkedList[nodes + 1];
            for (Integer node = 0; node <= nodes; node++) {
                graph[node] = new LinkedList<>();
            }
            int[] distance = new int[nodes + 1];

            for (Integer edge = 0; edge < edges; edge++) {
                Integer st1 = in.nextInt();
                Integer st2 = in.nextInt();
                graph[st1].add(st2);
                graph[st2].add(st1);
            }
            Integer start = in.nextInt();
            Arrays.fill(distance, -1);
            distance[start] = 0;
            calculateDistance(graph, distance, start, nodes);

            Arrays.stream(distance).skip(1).filter(element -> element != 0)
                    // .map(element -> element == 10000 ? -1 : element)
                    .forEach(element -> System.out.print(element + " "));
            System.out.println();
        }

        in.close();

    }

    private static void calculateDistance(LinkedList<Integer>[] graph, int[] distance, Integer start, Integer nodes) {

        // boolean helper[] = new boolean[nodes + 1];
        HashSet<Integer> seen = new HashSet<>();
        Queue<Integer> neighbour = new LinkedList<Integer>();

        neighbour.add(start);
        seen.add(start);
        while (!neighbour.isEmpty()) {
            Integer current = neighbour.poll();
            for (Integer next : graph[current])
                if (!seen.contains(next)) {
                    distance[next] = distance[current] + 6;
                    neighbour.add(next);
                    seen.add(next);
                }
        }

    }
}
