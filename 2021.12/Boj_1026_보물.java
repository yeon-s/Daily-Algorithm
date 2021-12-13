package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] b = new int[N];
		int[] bCopy = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			b[i] = Integer.parseInt(st.nextToken());
			bCopy[i] = b[i];
		}
		//입력 끝
		Arrays.sort(bCopy);
		Arrays.sort(a);
		int S = 0;
		for(int i=0;i<N;i++) {
			S+= bCopy[N-1-i]*a[i];
		}
		System.out.println(S);

	}

}
