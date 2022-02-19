package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2512_예산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		int max=0;
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			total +=arr[i];
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		int M = Integer.parseInt(br.readLine());
		//입력 끝
		
		if(total<=M) {
			System.out.println(max);
			return;
		}
		
		int start = 1;
		int end = M;
		
		int answer=1;
		while(start<=end) {
			int mid = (start+end)/2;
			
			int sum=0;
			for(int i=0;i<N;i++) {
				if(arr[i]<=mid) {
					sum+=arr[i];
				}else {
					sum+=mid;
				}
			}
			
			if(sum>M) {
				end=mid-1;
			}else {
				start=mid+1;
				answer=mid;
			}
		}
		System.out.println(answer);
	}

}
