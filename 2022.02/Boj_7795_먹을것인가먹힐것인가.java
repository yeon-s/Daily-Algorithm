package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr1 = new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr1);
			
			int[] arr2 = new int[M];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				arr2[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr2);
			
			int index=0;
			int[] answer = new int[N];
			
			for(int i=0;i<N;i++) {
				int num=arr1[i];
				int sum=0;
				if(i>=1) {
					sum=answer[i-1];
				}
				if(num>arr2[M-1]) {
					answer[i]=M;
					continue;
				}
				
				for(int j=index;j<M;j++) {
					if(arr2[j]>=num) {
						index=j;
						break;
					}
					sum++;
				}
				answer[i]=sum;
			}
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				cnt+=answer[i];
			}
			
			sb.append(cnt+"\n");
		}
		System.out.println(sb);

	}

}
