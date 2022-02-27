package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2116_주사위쌓기 {

	static int sum;
	static int N;
	static int[][] arr;
	static int answer;
	static int[] pair;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][6];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		pair = new int[]{5,3,4,1,2,0};
		answer=0;
		
		for(int i=0;i<6;i++) {
			sum=0;
			int max = 0;
			for(int j=0;j<6;j++) {
				if(j==i || j==pair[i]) {
					continue;
				}
				max = Math.max(max, arr[0][j]);
			}
			sum+=max;
			dfs(arr[0][i],1);
		}
		System.out.println(answer);
		
	}
	
	static void dfs(int num,int cnt) {
		if(cnt==N) {
			answer = Math.max(sum, answer);
			return;
		}
		
		int bottom = -1;
		for(int i=0;i<6;i++) {
			if(arr[cnt][i]==num) {
				bottom=i;
				break;
			}
		}
		int up = pair[bottom];
		
		int max= 0;
		for(int i=0;i<6;i++) {
			if(i==up || i==bottom) {
				continue;
			}
			max= Math.max(max, arr[cnt][i]);
		}
		sum+=max;
		dfs(arr[cnt][up],cnt+1);
		
	}

}
