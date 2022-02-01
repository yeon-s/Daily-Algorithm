package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1062_가르침 {

	static int R;
	static int C;
	static int[] select;
	static String[] arr;
	static int K;
	static int N;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
		}
		//입력 끝
		
		select = new int[K];
		max=0;
		if(5>K) {
			System.out.println(0);
			return;
		}
		
		select[0]=0;
		select[1]='n'-'a';
		select[2]='t'-'a';
		select[3]='i'-'a';
		select[4]='c'-'a';
		
		R = 21;
		C = K-5;
		
		comb(5,1);
		System.out.println(max);
	}
	
	static void comb(int cnt,int start) {
		if(cnt==K) {
			int sum=0;
			
			for(int i=0;i<N;i++) {
				String str = arr[i];
				boolean flag2=false;
				for(int j=0;j<str.length();j++) {
					char c = str.charAt(j);
					boolean flag=false;
					for(int k=0;k<K;k++) {
						if(select[k]==c-'a') {
							flag=true;
							break;
						}
					}
					if(!flag) {		//점수 못얻음
						flag2=true;
						break;
					}
				}
				if(flag2) {
					continue;
				}
				sum++;
			}
			
			max= Math.max(max, sum);
			return;
		}
		
		for(int i=start;i<26;i++) {
			if(i==2 || i=='i'-'a' || i=='t'-'a' || i=='n'-'a') {
				continue;
			}
			
			select[cnt]=i;
			comb(cnt+1,i+1);
		}
	}

}
