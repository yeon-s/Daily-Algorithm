package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1427_소트인사이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int size = str.length();
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = (int)(str.charAt(i)-'0');
		}
		Arrays.sort(arr);
		
		String answer="";
		for(int i=size-1;i>=0;i--) {
			answer+=arr[i];
		}

		System.out.println(answer);
	}

}
