package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2961_도영이가만든맛있는음식 {

	static int N;
	static tasty[] arr;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new tasty[N];
		
		
		 for(int i=0;i<N;i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 arr[i] = new tasty(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		 }
		 //입력 끝
		 min = Integer.MAX_VALUE;
		
		 subset(0,1,0);
		
		 System.out.println(min);
	}
	
	static void subset(int cnt,int sin,int ssen) {
		
		if(cnt==N) {
			if(ssen==0 && sin==1) {
				return;
			}
			min = Math.min(min, Math.abs(sin-ssen));
			return;
		}
		
		subset(cnt+1,sin*arr[cnt].sin,ssen+arr[cnt].ssen);			
		
		subset(cnt+1,sin,ssen);
	}
	
	static class tasty{
		int sin;
		int ssen;
		public tasty(int sin, int ssen) {
			super();
			this.sin = sin;
			this.ssen = ssen;
		}
		
	}

}
