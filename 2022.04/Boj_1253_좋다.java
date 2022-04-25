package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1253_좋다 {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int answer =0;
		for(int i=0;i<N;i++) {
			int temp = arr[i];
			
			if(check(temp,i)) {
				answer++;
			}
		}
		
		System.out.println(answer);
		

	}
	
	static boolean check(int temp,int index) {
		
		int left =0;
		int right = N-1;
		
		while(left<right) {
			if(index==left) {
				left++;
				continue;
			}
			if(index==right) {
				right--; 
				continue;
			}
			int sum = arr[left]+arr[right];
			
			if(temp>sum) {
				left++;
			}else {
				if(temp==sum) {
					return true;
				}
				right--;
			}
		}
		return false;
	}

}
