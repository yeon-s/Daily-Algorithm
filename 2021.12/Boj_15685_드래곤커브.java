package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15685_드래곤커브 {

	static List<Integer> list;
	static int[] di = {0,-1,0,1};
	static int[] dj = {1,0,-1,0};
	static boolean[][] map;
	static int[] di2 = {0,0,1,1};
	static int[] dj2 = {0,1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		map = new boolean[101][101];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			getDList(g,d);		//드래곤 커브 하나당 방향정보
			simul(sj,si);		//방향정보대로 움직이기
		}
		
		int answer=0;
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(check(i,j)) {		//4개 꼭지점 true인지 확인
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int si,int sj) {
		
		for(int d=0;d<4;d++) {
			int nexti = si+di2[d];
			int nextj = sj+dj2[d];
			
			if(!map[nexti][nextj]) {
				return false;
			}
		}
		
		return true;
	}
	
	static void simul(int sj,int si) {
		int nowi = si;
		int nowj = sj;
		map[nowi][nowj]= true;
		
		int num = list.size();
		
		for(int i=0;i<num;i++) {
			int d = list.get(i);
			
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			map[nexti][nextj]=true;
			nowi=nexti;
			nowj=nextj;
		}
		
	}
	
	static List<Integer> getDList(int g, int d){
		if(g==0) {
			list.add(d);
			return list;
		}
		
		list = getDList(g-1,d);
		
		int num=list.size();
		for(int i=num-1;i>=0;i--) {
			int curD = list.get(i);
			curD = curD+1;
			if(curD>3) {
				curD=0;
			}
			list.add(curD);
		}
		
		return list;
	}

}
