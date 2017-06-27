

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int V = scanner.nextInt();
		int[] c = new int[N];
		int[] v = new int[N];
		for(int i = 0; i < N; i++) {
			c[i] = scanner.nextInt();
			v[i] = scanner.nextInt();
		}
		
		int[] f = new int[V+1];
		for(int i =0 ; i < N; i++) {
			for(int j = V; j >= c[i]; j--) {
				f[j] = Math.max(f[j], f[j-c[i]] + v[i]);
			}
		}
		System.out.println(f[V]);
	}
}
