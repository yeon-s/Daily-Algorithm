package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int start=1;
		int end = arr[N-1];
		int answer=0;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			int num=arr[0];
			int index=0;
			boolean check=true;
			for(int i=0;i<C-1;i++) {
				num+=mid;
				boolean flag=false;
				for(int j=index;j<N;j++) {
					if(arr[j]>=num) {
						num=arr[j];
						index=j;
						flag=true;
						break;
					}
				}
				if(!flag){
					check=false;
					break;
				}
			}
			if(check) {
				start=mid+1;
				answer=mid;
			}else {
				end=mid-1;
			}
			
		}
		
		System.out.println(answer);	
	}

}
