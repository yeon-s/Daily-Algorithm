package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1969_DNA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		String answer = "";
		int sum=0;
		for(int i=0;i<M;i++) {
			
			int[] list = new int[26];
			int max = 0;
			for(int j=0;j<arr.length;j++) {
				char c = arr[j].charAt(i);
				list[c-'A']++;
				if(list[c-'A']>max) {
					max = list[c-'A'];
				}
			}
			
			for(int j=0;j<26;j++) {
				if(list[j]==max) {
					answer+=((char)(j+'A')+"");
					break;
				}
			}
			sum+=N-max;
		}
		System.out.println(answer+"\n"+sum);
	}

}
