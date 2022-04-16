package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14465_소가길을건너간이유5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		Arrays.fill(arr, 1);
		for(int i=0;i<B;i++) {
			arr[Integer.parseInt(br.readLine())-1]=0;
		}
		
		int sum=0;
		for(int i=0;i<K;i++) {
			sum+=arr[i];
		}
		int min=K-sum;
		
		for(int i=0;i<N-K;i++) {
			sum+=arr[i+K];
			sum-=arr[i];
			min=Math.min(min, K-sum);
		}
		System.out.println(min);

	}

}
