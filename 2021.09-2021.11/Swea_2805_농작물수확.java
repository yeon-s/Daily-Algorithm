package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_2805_농작물수확 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = br.readLine();
			}
			
			int sum=0;
			int a=N/2;
			int b=N/2;
			
			for(int i=0;i<N;i++) {
				if(i<=N/2) {
					for(int j=a;j<=b;j++) {
						sum += Integer.parseInt(arr[i].substring(j, j+1));
					}
					if(a>0 && b<N-1) {
						a--;
						b++;							
					}
				}else {
					if(a==0 && b==N-1) {
						a++;
						b--;
					}
					for (int j = a; j <= b; j++) {
						sum += Integer.parseInt(arr[i].substring(j, j+1));
					}
					a++;
					b--;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}

	}

}
