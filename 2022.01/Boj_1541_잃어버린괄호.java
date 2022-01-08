package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] arr = str.split("-");
		
		int sum=0;
		
		String[] first = arr[0].split("\\+");
		
		for(String s:first) {
			sum+=Integer.parseInt(s);
		}

		for(int i=1;i<arr.length;i++) {
			String[] temp = arr[i].split("\\+");
			
			for(String s:temp) {
				sum-=Integer.parseInt(s);
			}
		}
		
		System.out.println(sum);
	}

}
