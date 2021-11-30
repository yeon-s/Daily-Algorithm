package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2961_도영이가만든맛있는음식2 {

	static int N;
	static tasty[] arr;
	static int min;
	static boolean[] isSelected;
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
		isSelected = new boolean[N];
		 subset(0);
		
		 System.out.println(min);
	}
	
	static void subset(int cnt) {
		
		if(cnt==N) {
			
			int sin=1;
			int ssen=0;
			boolean flag=false;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sin *= arr[i].sin;
					ssen+=arr[i].ssen;
					flag=true;
				}
			}
			if(!flag) {
				return;
			}
			min = Math.min(min, Math.abs(sin-ssen));
			
			return;
		}
		isSelected[cnt] =true;
		subset(cnt+1);			
		isSelected[cnt] =false;
		subset(cnt+1);
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
