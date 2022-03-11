package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2607_비슷한단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = (br.readLine());
		int[] arr = new int[26];
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			arr[c-'A']++;
		}

		int answer=0;
		for(int i=0;i<N-1;i++) {
			String tmp = br.readLine();
			
			int[] temp = new int[26];
			for(int j=0;j<tmp.length();j++) {
				char c = tmp.charAt(j);
				
				temp[c-'A']++;
			}
			
			int cnt=0;
			if(Math.abs(tmp.length()-str.length())>=2) {
				continue;
			}
			boolean flag=false;
			for(int j=0;j<26;j++) {
				if(temp[j]!=arr[j]) {
					if(cnt>=2) {
						flag=true;
						break;
					}
					if(Math.abs(temp[j]-arr[j])==1) {
						cnt++;
					}else {
						flag=true;
						break;
					}
				}
			}
			if(!flag) {
				answer++;
			}
		}
		System.out.println(answer);

	}

}
