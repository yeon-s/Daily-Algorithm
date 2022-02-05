package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2294_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		int[] D = new int[k+1];
		Arrays.fill(D, 100000);
		D[0]=0;
		for(int i=1;i<=k;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]<=i) {
					D[i]= Math.min(D[i], D[i-arr[j]]+1);
				}
			}
		}
		
		if(D[k]>=100000) {
			System.out.println(-1);			
		}else {
			System.out.println(D[k]);
		}
		
		

	}

}
