package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_2531_회전초밥2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+k-1];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N;i<N+k-1;i++) {
			arr[i] = arr[i-N];				//끝에 처음부터 k-1개 붙여주기
		}
		//입력 끝
		
		int[] sort = new int[d+1];
		sort[c]=1;
		int max=1;
		for(int i=0;i<k;i++) {
			if(sort[arr[i]]==0) {
				max++;
			}
			sort[arr[i]]++;
		}
		
		int answer=0;
		for(int i=k,size=arr.length;i<size;i++) {
			if(sort[arr[i]]==0) {
				max++;
			}
			sort[arr[i]]++;
			sort[arr[i-k]]--;
			if(sort[arr[i-k]]==0) {
				max--;
			}
			if(answer<max) {
				answer=max;
			}
		}
		System.out.println(answer);
		

	}

}
