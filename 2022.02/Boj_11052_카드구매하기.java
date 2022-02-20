package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		int[] D = new int[N+1];
		D[0]=0;
		for(int i=1;i<=N;i++) {
			int max = 0;
			for(int j=1;j<=i;j++) {
				if(max<D[i-j]+arr[j]) {
					max=D[i-j]+arr[j];
				}
			}
			D[i]=max;
		}
		
		System.out.println(D[N]);
	}

}
