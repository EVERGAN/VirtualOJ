
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] dp = new int[n];
		dp[0] = a[0];
		int len = 0;
		for(int i = 1; i < n; i++){
			if(a[i] > dp[len]) {
				dp[++len] = a[i];
			} else {
				int tmp = binarySearch(dp,a[i],len);
				dp[tmp] = a[i];
			}
		}
		System.out.println(len+1);
	}
	public static int binarySearch(int[] dp,int k,int len) {
		int left = 0;
		int right = len;
		while(left < right) {
			int mid = left+(right - left) / 2;
			if(dp[mid] >= k) right = mid;
			else {
				left = mid + 1;
			}
		}
		return left;
	}
}
