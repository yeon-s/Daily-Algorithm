package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20057_마법사상어와토네이도 {

	static int N;
	static int[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0};
	static int d;
	static int nowi;
	static int nowj;
	static int answer;
	static int sum;
	static int sand;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int num=1;
		d=0;
		nowi=N/2;
		nowj=N/2;
		answer=0;
		while(num<N) {
			for(int k=0;k<2;k++) {
				for(int i=0;i<num;i++) {
					move();
					nowi = nowi+di[d];
					nowj = nowj+dj[d];
				}
				d++;
				if(d>3) {
					d=0;
				}
			}
			num++;
		}
		
		num=num-1;
		for(int i=0;i<num;i++) {
			move();
			nowi = nowi+di[d];
			nowj = nowj+dj[d];
		}
		
		System.out.println(answer);
	}
	
	static void move() {
		int tempi=nowi+di[d];
		int tempj=nowj+dj[d];
		
		sand = map[tempi][tempj];
		
		int right = d-1;
		if(right<0) {
			right=3;
		}
		
		int left = d+1;
		if(left>3) {
			left=0;
		}
		
		sum=0;
		int nexti = tempi+di[right];
		int nextj = tempj+dj[right];
		check(nexti,nextj,7);
		nexti = tempi+(di[right]*2);
		nextj = tempj+(dj[right]*2);
		check(nexti,nextj,2);
		
		check(tempi+(di[d]*2),tempj+(dj[d]*2),5);
		
		nexti = tempi+di[left];
		nextj = tempj+dj[left];
		check(nexti,nextj,7);
		nexti = tempi+(di[left]*2);
		nextj = tempj+(dj[left]*2);
		check(nexti,nextj,2);
		
		check(tempi+di[d]+di[right],tempj+dj[d]+dj[right],10);
		check(tempi+di[d]+di[left],tempj+dj[d]+dj[left],10);
		check(nowi+di[right],nowj+dj[right],1);
		check(nowi+di[left],nowj+dj[left],1);
		
		nexti = tempi+di[d];
		nextj = tempj+dj[d];
		
		if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
			answer+=sand-sum;
		}else {
			map[nexti][nextj]+=sand-sum;
		}
		
	}
	
	static void check(int curi,int curj,int percent) {
		int amount = sand*percent/100;
		if(curi<0 || curj<0 || curi>=N || curj>=N) {
			answer+= amount;
		}else {
			map[curi][curj]+=amount;
		}
		sum+=amount;			
	}

}
