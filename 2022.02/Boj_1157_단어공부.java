package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] arr = new int[26];
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(c-'A'>=0 && c-'Z'<=0) {
				c = (c+"").toLowerCase().charAt(0);
			}
			
			arr[c-'a']++;
		}
		
		int max=0;
		
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		int cnt=0;
		int answer=0;
		for(int i=0;i<26;i++) {
			if(arr[i]==max) {
				cnt++;
				answer=i;
			}
		}
		
		if(cnt>1) {
			System.out.println("?");
		}else {
			System.out.println((char)(answer+'A'));
		}
	}

}
