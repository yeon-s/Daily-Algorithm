package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1100_하얀칸 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[8][8];
		
		for(int i=0;i<8;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int sum=0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(map[i][j]=='F') {
					if(i%2==0 && j%2==0) {
						sum++;
					}else if(i%2==1 && j%2==1) {
						sum++;
					}
						
				}
			}
		}
		
		System.out.println(sum);

	}

}
