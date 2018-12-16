import java.util.ArrayList;

class Solution {


	static ArrayList<Integer>[] adjList;

	private static boolean possibleChainString(String[] arr, int length) {

		if (arr == null || length == 0)
			return true;

		int[] indegreeFreq = new int[26];
		int[] outdegreeFreq = new int[26];

		boolean[] mark = new boolean[26];
		int start;
		int end;

		for (int index = 0; index < length; index++) {
			start = arr[index].charAt(0) - 'a';
			end = arr[index].charAt(arr[index].length() - 1) - 'a';

			mark[start] = true;
			mark[end] = true;

			indegreeFreq[start]++;
			outdegreeFreq[end]++;

			adjList[start].add(end);
		}

		if (!checkInAndOutFreq(indegreeFreq, outdegreeFreq))
			return false;

		return checkConnectedGraph(mark, arr[0].charAt(0) - 'a');
	}

	private static boolean checkConnectedGraph(boolean[] mark, int startChar) {
		boolean[] visited = new boolean[26];

		depthFirstSearchUtil(visited, startChar);
		for (int index = 0; index < visited.length; index++) {
			if (mark[index] && !visited[index])
				return false;
		}
		return true;
	}

	private static void depthFirstSearchUtil(boolean[] visited, int startChar) {
		visited[startChar] = true;
		for (int adjNode : adjList[startChar]) {
			if (!visited[adjNode]) {
				depthFirstSearchUtil(visited, adjNode);
			}
		}
	}

	private static boolean checkInAndOutFreq(int[] indegreeFreq, int[] outdegreeFreq) {
		if (indegreeFreq == null && outdegreeFreq == null)
			return true;
		if (indegreeFreq == null || outdegreeFreq == null)
			return false;

		for (int index = 0; index < 26; index++) {
			if (indegreeFreq[index] != outdegreeFreq[index])
				return false;
		}
		return true;
	}

//  Driver code to test above methods 
	public static void main(String[] args) {
		String arr[] = { "abc", "ca", "ee" };
//		String arr[] = { "ab", "bc", "cd", "de", "ed", "da" };
		int N = arr.length;

		adjList = new ArrayList[26];
		for (int index = 0; index < 26; index++) {
			adjList[index] = new ArrayList<>();
		}

		if (possibleChainString(arr, N))
			System.out.println("Ordering is possible");
		else
			System.out.println("Ordering is not possible");
	}

}
