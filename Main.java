import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) {
		int t = sc.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.close();
	}

	private static void solve() {

	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

	private static int[] prefixSum(int[] arr) {
		int n = arr.length;
		int[] prefix = new int[n];
		prefix[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		return prefix;
	}

	private static void reverseArray(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static int findGCDofArr(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = gcd(result, arr[i]);
			if (result == 1) break;
		}
		return result;
	}

	private static long findGCDofSet(Set<Long> set) {
		Iterator<Long> iterator = set.iterator();
		if (!iterator.hasNext()) return 0;
		long result = iterator.next();
		while (iterator.hasNext()) {
			result = gcd(result, iterator.next());
			if (result == 1) break;
		}
		return result;
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in), 32768);
		}

		private String nextToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public String next() { return nextToken(); }
		public int nextInt() { return Integer.parseInt(nextToken()); }
		public long nextLong() { return Long.parseLong(nextToken()); }
		public double nextDouble() { return Double.parseDouble(nextToken()); }
		public String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
