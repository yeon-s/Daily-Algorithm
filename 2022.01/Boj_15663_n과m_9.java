package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15663_n과m_9 {

	static int[] result;
	static boolean[] isSelected;
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		isSelected = new boolean[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt==M) {
			for(int i:result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			if(i>0 && arr[i]==arr[i-1] && !isSelected[i-1]) {
				continue;
			}
			
			isSelected[i] = true;
			result[cnt]=arr[i];
			perm(cnt+1);
			isSelected[i]=false;
		}
	}

}
