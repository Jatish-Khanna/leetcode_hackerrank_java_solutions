import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

	static class Entry {
		char key;
		int freq;

		Entry(char key, int freq) {
			this.key = key;
			this.freq = freq;
		}

	}
	private static void rearrangeStringNoSameAlternateCharacter(String str) {
		PriorityQueue<Entry> freqQueue = new PriorityQueue<Entry>(new Comparator<Entry>() {

			@Override
			public int compare(Entry e1, Entry e2) {
				return e2.freq - e1.freq;
			}

		});

		int[] freqMap = new int[256];
		for (int index = 0; index < str.length(); index++) {
			freqMap[str.charAt(index)]++;
		}

		for (int index = 0; index < 256; index++) {
			if (freqMap[index] > 0)
				freqQueue.offer(new Entry((char) index, freqMap[index]));
		}

		StringBuilder sb = new StringBuilder();
		Entry prev = new Entry('#', -1);
		while (!freqQueue.isEmpty()) {
			Entry entry = freqQueue.poll();
			sb.append(entry.key);
			if (prev.freq > 0)
				freqQueue.offer(prev);
			entry.freq--;
			prev = entry;
		}
		System.out.println(sb.length() == str.length() ? sb.toString() : "Not possible");
	}

	// Driver program to test above function
	public static void main(String[] args) {
		String str = "bbba";
		rearrangeStringNoSameAlternateCharacter(str);
	}

}
