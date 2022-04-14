package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[N-1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			arr[i][1]= Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long min = Long.MAX_VALUE;
		int index=0;
		for(int i=0;i<N-1;i++) {
			arr[i][0] = Long.parseLong(st.nextToken());
			
		}
		for(int i=0;i<N-2;i++) {
			if(arr[i][0]<arr[i+1][0]) {
				arr[i+1][0]=arr[i][0];
			}
		}
		
		long sum=0;
		for(int i=0;i<N-1;i++) {
			sum+=arr[i][0]*arr[i][1];
		}
		
		System.out.println(sum);
	}

}
