package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13549_숨바꼭질3 {

	static int N;
	static Queue<Integer> queue;
	static int[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		D = new int[100001];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		queue = new LinkedList<Integer>();
		queue.offer(N);
		D[N]=0;
		telepote(N,0);
		
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				if(current==K) {
					//끝내기
					flag=true;
					break;
				}
				
				if(D[current]!=0) {
					telepote(current,D[current]);					
				}
				
				if(current+1<=100000 && D[current+1]>D[current]+1) {
					queue.offer(current+1);
					D[current+1]=D[current]+1;
				}
				if(current-1>=0 && D[current-1]>D[current]+1) {
					queue.offer(current-1);
					D[current-1]=D[current]+1;
				}
				
			}
			if(flag) {
				break;
			}
		}
		
		System.out.println(D[K]);
		
	}
	
	static void telepote(int num,int time) {
		int temp = num;
		if(temp==0) {
			return;
		}
		while(true) {
			temp*=2;
			if(temp<=100000) {
				if(D[temp]>time) {
					queue.offer(temp);
					D[temp]=time;					
				}
			}else {
				break;
			}
		}
	}

}
