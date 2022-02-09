package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1072_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		
		long z = (100*y)/x;
		
		if(z>=99) {
			System.out.println(-1);
			return;
		}
		
		long start=1;
		long end=x;
		long answer=0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			
			long num = (100*(y+mid))/(x+mid);
			if(z<num) {
				end=mid-1;
				answer=mid;
			}else {
				start=mid+1;
			}
		}
		
		System.out.println(answer);
		

	}

}
