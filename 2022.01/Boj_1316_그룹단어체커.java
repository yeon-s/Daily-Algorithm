package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num=N;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			String str2 = "";
			str2+=str.substring(0, 1);
	
			for(int j=1;j<str.length();j++) {
				if(str2.contains(str.substring(j, j+1)) && str.charAt(j) !=str.charAt(j-1)) {
					num--;
					break;
				}
				str2+=str.substring(j,j+1);
			}
		}

		System.out.println(num);
	}

}
