package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1543_문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String find = br.readLine();
		
		int size= find.length();
		int index=0;
		int cnt=0;
		while(true) {
			
			if(index+size>str.length()) {
				break;
			}
			
			String check = str.substring(index,index+size);
			if(find.equals(check)) {
				cnt++;
				index+=size;
			}else {
				index++;
			}
		}
		
		System.out.println(cnt);

	}

}
