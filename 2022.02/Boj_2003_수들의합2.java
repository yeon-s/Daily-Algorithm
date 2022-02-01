package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] =Integer.parseInt(st.nextToken()); 
		}
		//입력 끝
		
		int start=0;
		int end=0;
		int sum=0;
		for(int i=start;i<=end;i++) {
			sum+=arr[i];
		}
		int answer=0;
		while(true) {
			if(sum==M) {
				answer++;
				end++;
				if(end>=N) {
					break;
				}
				sum+=arr[end];
				continue;
			}
			if(sum<M) {
				end++;
				if(end>=N) {
					break;
				}
				sum+=arr[end];
				continue;
			}else if(sum>M) {
				sum-=arr[start];
				start++;
				continue;
			}
			
		}

		System.out.println(answer);
	}

}
