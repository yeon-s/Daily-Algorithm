package practice;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_3649_로봇프로젝트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input=null;
		while(true) {
			
			input = br.readLine();
			if(input==null) {
				break;
			}
			int x = Integer.parseInt(input)*10000000;
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int left = 0;
			int right = n-1;
			int max = -1;
			int l1=0,l2=0;
			
			while(left<right) {
				
				int sum=arr[left]+arr[right];
				
				if(sum>x) {
					right--;
				}else if(sum<x) {
					left++;
				}else {
					if(arr[right]-arr[left]>max) {
						max = arr[right]-arr[left];
						l1=arr[left];
						l2=arr[right];
					}
					right--;
				}
			}
			
			if(max==-1) {
				System.out.println("danger");
				
			}else {
				System.out.println("yes "+l1+" "+l2);
				
			}
			input=null;
		}
	}

}
