

import java.util.Scanner;

public class Nod_1174 {

	static int N = 10000;
	static TNode[] q = new TNode[N*4];
	static int[] a = new int[N];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		build(0, 0, n-1);
		//查询的个数
		int m = scanner.nextInt();
		for(int i = 0; i < m; i++) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			int tmp = query(0,0,n-1, left, right);
			System.out.println(tmp);
		}
	}
	public static void build(int i,int left,int right) {
		q[i] = new TNode();
		q[i].mark = 0;
		if (left == right) {
			q[i].val = a[left];
		} else {
			int mid = (left + right) / 2;
			build(i*2+1, left, mid);
			build(i*2+2, mid+1, right);
			q[i].val = Math.max(q[i*2+1].val, q[i*2+2].val);
		}
	}
	public static void pushDown(int i) {
		if(q[i].mark != 0) {
			q[i*2+1].mark += q[i].mark;
			q[i*2+2].mark += q[i].mark;
			
			q[i*2+1].val += q[i].mark;
			q[i*2+2].val += q[i].mark;
			
			q[i].mark = 0;
		}
	}
	public static int query(int i,int nstart,int nend,int left,int right) {
		if(nend < left || right < nstart) {
			return -1;
		}
		//当前节点区间包含在查询区间内
		if(left <= nstart && right >= nend) {
			return q[i].val;
		}
		
		pushDown(i);
		int mid = (nstart + nend) / 2;
		return Math.max(query(i*2+1,nstart,mid, left, right), query(i*2+2,mid+1,nend, left, right));
	}
}
class TNode {
	int mark;
	int val;
}
