package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10025_게으른백곰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1000001];
		int all=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int g= Integer.parseInt(st.nextToken());
			int x= Integer.parseInt(st.nextToken());
			arr[x]=g;
			all+=g;
		}
		//입력 끝
		
		if(K>=500000) {
			System.out.println(all);
			return;
		}
		int sum=0;
		int answer=sum;
		for(int i=0;i<=2*K;i++) {
			sum+=arr[i];
		}
		
		for(int i=1;i<=1000000-(2*K);i++) {
			sum-=arr[i-1];
			sum+=arr[i+(2*K)];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);

	}

}
