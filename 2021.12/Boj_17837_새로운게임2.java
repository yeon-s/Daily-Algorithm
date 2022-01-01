package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17837_새로운게임2 {

	static int[] di = {0,0,0,-1,1};
	static int[] dj = {0,1,-1,0,0};
	static int N;
	static int[][] map;
	static List<Integer>[][] map2;
	static horse[] horses;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		map2 = new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[i][j] = new ArrayList<>();
			}
		}
		
		horses = new horse[K];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			horses[i] = new horse(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			map2[horses[i].i][horses[i].j].add(i);
		}
		//입력 끝
		
		int tern=0;
		while(true) {
			tern++;
			if(tern>1000) {
				break;
			}
			for(int i=0;i<K;i++) {
				//말 하나씩 이동
				move(horses[i],i);
				//4개 쌓이면 종료
				if(flag) {
					break;
				}
				
			}
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			System.out.println(tern);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static void move(horse mal,int num) {		
		int nexti = mal.i+di[mal.d];
		int nextj = mal.j+dj[mal.d];
		
		if(!out(nexti,nextj) || map[nexti][nextj]==2) {		//벗어나거나 파란색
			change(mal,num,2);
		}else if(map[nexti][nextj]==1) {
			change(mal,num,1);
			
		}else if(map[nexti][nextj]==0) {
			change(mal,num,0);
		}
		
	}
	
	static void change(horse mal,int num,int color) {
		List<Integer> list = map2[mal.i][mal.j];
		
		int index = list.indexOf(num);
		int nexti,nextj;
		if(color==2) {
			//방향 반대로 하고 한칸 이동
			mal.d+=1;
			if(mal.d==3) {
				mal.d=1;
			}else if(mal.d==5) {
				mal.d=3;
			}
			nexti = mal.i+di[mal.d];
			nextj = mal.j+dj[mal.d];
			if(!out(nexti,nextj) || map[nexti][nextj]==2) {		//if 이동하려는 곳이 파랑 또는 벗어나면 그자리 
				return;
			}else {
				move(mal,num);
			}
		}else {
			nexti = mal.i+di[mal.d];
			nextj = mal.j+dj[mal.d];			
		}
		
		if(color==1) {
			for(int i=list.size()-1;i>=index;i--) {			//이동한 칸에 거꾸로 추가
				map2[nexti][nextj].add(list.get(i));
				if(map2[nexti][nextj].size()>=4) {
					flag=true;
				}
			}
		}else {
			for(int i=index;i<list.size();i++) {
				map2[nexti][nextj].add(list.get(i));		//이동한 칸에 추가
				if(map2[nexti][nextj].size()>=4) {
					flag=true;
				}
			}
		}
		
		for(int i=index;i<list.size();i++) {			//정보 바꿔주기
			horses[list.get(i)].i=nexti;
			horses[list.get(i)].j=nextj;
		}
		
		for(int i=list.size()-1;i>=index;i--) {			//원래 리스트에서 제거
			list.remove(i);
		}
	}
	
	static boolean out(int i,int j) {
		if(i<0 || j<0 || i>=N || j>=N) {
			return false;
		}
		return true;
	}
	
	static class horse{
		int i;
		int j;
		int d;
		public horse(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}

}
