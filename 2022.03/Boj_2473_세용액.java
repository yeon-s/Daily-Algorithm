package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2473_세용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long[] answer = new long[3];
		
		for(int i=0;i<N-2;i++) {
			long target = arr[i];
			
			int left = i+1;
			int right = N-1;
			
			while(left<right) {
				long sum = arr[left]+arr[right]+target;
				
				if(min>Math.abs(sum)) {
					min=Math.abs(sum);
					answer[0]=arr[right];
					answer[1]=arr[left];
					answer[2]=target;
				}
				if(sum>0) {
					right--;
				}else if(sum<0){
					left++;
				}else {
					break;
				}
			}
			
		}
		
		Arrays.sort(answer);
		for(int i=0;i<3;i++) {
			System.out.print(answer[i]+" ");			
		}
		

	}

}
