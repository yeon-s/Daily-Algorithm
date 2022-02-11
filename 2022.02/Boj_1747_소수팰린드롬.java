package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1747_소수팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[10000001];
		arr[1]=true;
		for(int i=2;(i*i)<=10000000;i++) {
			
			if(!arr[i]) {
				for(int j=i*i;j<=10000000;j+=i) {
					arr[j]=true;
				}
			}
		}
		
		for(int i=N;i<=10000000;i++) {
			if(arr[i] || !pelin(i)) {
				continue;
			}
			System.out.println(i);
			return;
		}

	}
	
	
	static boolean pelin(int num) {
		String str = (num+"");
		
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

}
