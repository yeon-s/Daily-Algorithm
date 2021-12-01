package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14499_주사위굴리기 {
	static int[] di = {0,0,0,-1,1};
	static int[] dj = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int[] roll = new int[7];		//주사위 바닥에 적혀있는 숫자정보 저장한 배열
		
		int nowi = x;
		int nowj = y;
		int bottom =6;		//주사위 바닥면
		
		int[] rollInfo = {6,3,4,2,5,1};	//주사위 상태 저장된 배열 0 1 2 3 4 5 바텀 동 서 북 남 탑
		
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int command = Integer.parseInt(st.nextToken());
			
			int nexti = nowi+di[command];
			int nextj = nowj+dj[command];
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
				continue;
			}
			nowi = nexti;
			nowj = nextj;
			
			bottom = rollInfo[command];
			int[] temp = new int[6];
			
			switch(command) {
			case 1:
				temp[0] = rollInfo[1];
				temp[1] = rollInfo[5];
				temp[2] = rollInfo[0];
				temp[3] = rollInfo[3];
				temp[4] = rollInfo[4];
				temp[5] = rollInfo[2];
				break;
			case 2:
				temp[0] = rollInfo[2];
				temp[1] = rollInfo[0];
				temp[2] = rollInfo[5];
				temp[3] = rollInfo[3];
				temp[4] = rollInfo[4];
				temp[5] = rollInfo[1];
				break;
			case 3:
				temp[0] = rollInfo[3];
				temp[1] = rollInfo[1];
				temp[2] = rollInfo[2];
				temp[3] = rollInfo[5];
				temp[4] = rollInfo[0];
				temp[5] = rollInfo[4];
				break;
			case 4:
				temp[0] = rollInfo[4];
				temp[1] = rollInfo[1];
				temp[2] = rollInfo[2];
				temp[3] = rollInfo[0];
				temp[4] = rollInfo[5];
				temp[5] = rollInfo[3];
				break;
			}
			
			for(int j=0;j<6;j++) {
				rollInfo[j] = temp[j];
			}
			
			if(map[nowi][nowj] !=0) {
				roll[bottom] = map[nowi][nowj];
				map[nowi][nowj] = 0;
			}else {
				map[nowi][nowj] = roll[bottom];
			}
			System.out.println(roll[7-bottom]);
		}
	}
	
}
