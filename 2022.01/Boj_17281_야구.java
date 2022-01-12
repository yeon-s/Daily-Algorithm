package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17281_야구 {

	static int[] result;
	static boolean[] isSelected;
	static int[][] behavior;
	static int N;
	static int max;
	static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[10];
		result[4]=1;
		isSelected = new boolean[10];
		behavior = new int[N+1][10];
		max=0;
		list = new int[3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<10;j++) {
				behavior[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(1);
		System.out.println(max);
	}
	
	static void perm(int cnt) {
		if(cnt==4) {
			perm(cnt+1);
			return;
		}
		if(cnt==10) {
			simul();
			return;
		}
		
		for(int i=2;i<=9;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			result[cnt] = i;
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
	
	static void simul() {			//이부분부터
		int out=0;
		int ining = 1;
		int what=0;
		int current =1;
		int score = 0;
		list[0]=0;
		list[1]=0;
		list[2]=0;
		
		while(true) {
			what = behavior[ining][result[current]];
			
			if(what==0) {
				out++;
			}else if(what==1) {
				score+=list[0];
				list[0]=list[1];
				list[1]=list[2];
				list[2]=1;
			}else if(what==2) {
				score+=list[0];
				score+=list[1];
				list[0]=list[2];
				list[1]=1;
				list[2]=0;
			}else if(what==3) {
				for(int num:list) {
					score+=num;
				}
				list[0]=1;
				list[1]=0;
				list[2]=0;
			}else if(what==4) {
				for(int num:list) {
					score+=num;
				}
				score+=1;
				list[0]=0;
				list[1]=0;
				list[2]=0;
			}
			
			current++;
			if(current>9) {
				current=1;
			}
			
			if(out==3) {
				out=0;
				ining++;
				list[0]=0;
				list[1]=0;
				list[2]=0;
				if(ining>N) {
					max = Math.max(score, max);
					return;
				}
			}
		}	
	}

}
