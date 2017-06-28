

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class P_2976 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			
			int N = scanner.nextInt();
			int k = scanner.nextInt();
			if(N == 0 && k ==0) continue;
			int[] a = new int[N];
			int[] b = new int[N];
			for(int i = 0; i < N; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < N; i++) {
				b[i] = scanner.nextInt();
			}
			double L = 0.0;
			double R = 1.0;
			double[] f = new double[N];
			double mid = 0.0;
			while(Math.abs(L-R) > Math.pow(10, -6)) {
				mid = (L+R)/2;
				for(int i = 0; i < N; i++) {
					f[i] = a[i] * 1.0 - mid * b[i] * 1.0;
				}
				Arrays.sort(f);
				double sum = 0.0;
				for(int i = k; i < N; i++) {
					sum += f[i];
				}
				//函数是递减的
				if(sum > 0) {
					L = mid;
				} else if(sum < 0) {
					R = mid;
				} else break;
			}
			mid *= 100;
			DecimalFormat format = new DecimalFormat("0");
			System.out.println(format.format(mid));
		}
	}
}
