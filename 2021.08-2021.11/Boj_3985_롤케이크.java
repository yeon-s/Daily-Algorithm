package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L+1];
		Audi[] arr = new Audi[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new Audi(sc.nextInt(), sc.nextInt());
		}
		//입력 끝
		int max =0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, arr[i].k-arr[i].p);
		}
		
		int guess=0;
		for(int i=1;i<=N;i++) {
			if(arr[i].k-arr[i].p==max) {
				guess=i;
				break;
			}
		}
		
		for(int i=1;i<=N;i++) {
			int p = arr[i].p;
			int k = arr[i].k;
			for(int j=p;j<=k;j++) {
				if(cake[j]==0) {
					cake[j] = i;										
				}
			}
		}
		
		int[] audis = new int[N+1];
		for(int i=1;i<=L;i++) {
			audis[cake[i]]++;
		}
		max=0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, audis[i]);
		}
		int trust =0;
		for(int i=1;i<=N;i++) {
			if(audis[i]==max) {
				trust = i;
				break;
			}
		}
		
		System.out.println(guess);
		System.out.println(trust);
	}
	
	static class Audi{
		int p;
		int k;
		public Audi(int p, int k) {
			super();
			this.p = p;
			this.k = k;
		}
		
	}
}
