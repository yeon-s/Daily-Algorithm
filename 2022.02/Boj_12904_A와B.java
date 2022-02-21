package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12904_A와B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
	
		int size = T.length();
		
		while(size>0) {
			
			if(T.equals(S)) {
				System.out.println(1);
				return;
			}
			
			if(T.charAt(size-1)=='A') {
				T=T.substring(0,size-1);
			}else {
				T=T.substring(0,size-1);
				StringBuilder sb = new StringBuilder();
				sb.append(T).reverse();
				T=(sb+"");
			}
			size--;
			if(size<S.length()) {
				break;
			}
		}
		System.out.println(0);
	}

}
