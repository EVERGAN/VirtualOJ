

import java.util.Scanner;

public class Main {

	static int[] c;
	static int[] v;
	static int[] a;
	static int[] f;
	static int N;
	static int V;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		V = scanner.nextInt();
		c = new int[105];
		v = new int[105];
		a = new int[105];
		for(int i = 0; i < N; i++) {
			c[i] = scanner.nextInt();
			v[i] = scanner.nextInt();
			a[i] = scanner.nextInt();
		}
		
		f = new int[V+1];
		
		for(int i = 0; i < N; i++) {
			multiplePack(c[i], v[i], a[i]);
		}
		System.out.println(f[V]);
	}
	public static void multiplePack(int cost,int weight,int amount) {
		if(cost * amount >= V) {
			completePack(cost, weight);
			return;
		}
		int k = 1;
		while(k < amount) {
			zeroOnePack(k * cost, k * weight);
			amount -= k;
			k *= 2;
		}
		zeroOnePack(amount * cost, amount * weight);
	}
	
	public static void completePack(int cost,int weight) {
			for(int j = cost; j <= V; j++) {
				f[j] = Math.max(f[j], f[j-cost] + weight);
		}
	}
	
	public static void zeroOnePack(int cost,int weight) {
			for(int j = V; j >= cost; j--) {
				f[j] = Math.max(f[j], f[j-cost] + weight);
		}
	}
}
