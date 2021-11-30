package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2851_슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//입력 끝
		
		int sum=0;
		int index=0;
		for(int i=0;i<10;i++) {
			if(sum+arr[i]>=100) {
				index=i;
				break;
			}
			sum+=arr[i];
		}
		int before = 100-sum;
		int after = sum+arr[index]-100;
		if(arr[0]==100) {
			System.out.println(100);
		}else if(index==0) {
			System.out.println(sum);
		}else if(after<=before) {
			System.out.println(after+100);
		}else if(before<after){
			System.out.println(sum);
		}
	}

}
