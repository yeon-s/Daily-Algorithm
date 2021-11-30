package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0;i<TC;i++) {
			String str = br.readLine();
			int sum = 0;
			int count=0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					count++;
					sum += count;
				}else {
					count=0;
				}
			}
			System.out.println(sum);
		}

	}

}
