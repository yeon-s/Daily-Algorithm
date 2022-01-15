package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17609_회문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			
			answer.append(check(str)+"\n");
		}
		
		System.out.println(answer);
	}
	
	static int check(String str) {		
		int start=0;
		int end=str.length()-1;
		int num=0;
		
		while(true) {
			
			if(str.charAt(start)!=str.charAt(end)) {
				if(!check2(start+1,end,str) && !check2(start,end-1,str)) {
					return 2;
				}else {
					return 1;
				}
			}
			start++;
			end--;
			if(start>=end) {
				break;
			}
		}
		
		return 0;
	}
	
	static boolean check2(int start,int end,String str) {
		while(true) {
			
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
			if(start>=end) {
				break;
			}
		}
		return true;
		
	}

}
