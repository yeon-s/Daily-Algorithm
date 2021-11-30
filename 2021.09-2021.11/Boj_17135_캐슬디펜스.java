package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17135_캐슬디펜스 {

	static int[] result;
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] originalMap;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static List<Point> huboList;
	static int minD;
	static List<Point> finalList;
	static int num;		//잡은 적의 수
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		
		originalMap = new int[N+1][M];		//궁수포함 맵
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				originalMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		result = new int[3];		//궁수 위치 정한 배열
		comb(0,0);
		System.out.println(max);
	}
	
	static void comb(int target,int cnt) {
		if(cnt==3) {		//궁수 위치 정하면
			num=0;			//사냥 시작하기 위해 잡은 적 초기화
			map = new int[N+1][M];		//궁수 배치한 맵으로 사냥할 카피맵생성
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = originalMap[i][j];		//맵 복사
				}
			}
			gameStart(result[0],result[1],result[2]);	//게임시작
			max = Math.max(num, max);		//		최대로 잡은 적 갱신
			return;
		}
		
		if(target==M) {
			return;
		}
		
		result[cnt] = target;
		comb(target+1,cnt+1);
		comb(target+1,cnt);
	}
	
	static void gameStart(int one,int two,int three) {
		
		
		while(true) {
			boolean flag = false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						flag = true;		//잡을 적이 있다면
					}
				}
			}
			
			if(flag) {
				//궁수별로 최단거리인 적 구하기
				finalList = new ArrayList<>();		//최종 잡을 적 리스트(3개이하)
				for(int i=0;i<3;i++) {
					Point gungsu = new Point(N, result[i]);	
					minD= 1000;	//최단거리 구하기
					huboList = new ArrayList<>();		//공격범위 안에 있고 최단거리인 애들만 넣기
					bfs(gungsu);						//궁수 위치를 시작으로 bfs돌리기
					
					if(huboList.size()>0) {		//후보리스트가 비었다면 공격범위 안 닿아서 잡을 수 있는 적이 없음.
						Collections.sort(huboList);		//최단거리가 여러마리면 왼쪽에 있는순 정렬
						finalList.add(huboList.get(0));	//가장 왼쪽을 최종리스트에 추가
					}		
						
				}
				
				if(finalList.size()>0) {		//세 궁수 중 하나라도 잡을 적이 있다면
					for(int i=0;i<finalList.size();i++) {
						Point enemy = finalList.get(i);
						if(map[enemy.i][enemy.j]==1) {
							num++;				//잡은적++
							map[enemy.i][enemy.j]=0;	//잡은적 0으로 바꿔주기
						}
					}
				}
				
				List<Point> restEnemy = new ArrayList<>();
				
				//남은 적들 담기
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j]==1) {
							restEnemy.add(new Point(i, j));
						}
					}
				}
				//남은적들 아래로 한 칸 씩 이동
				for(int i=restEnemy.size()-1;i>=0;i--) {		//밑에서부터 이동해주기(겹치는거 방지)
					Point enemy = restEnemy.get(i);
					if(enemy.i+1<N) {
						map[enemy.i+1][enemy.j]=1;
					}
					map[enemy.i][enemy.j]=0;
				}
				
			}else {
				break;
			}
			
		}
	}
	
	static void bfs(Point start) {
		boolean[][] visited = new boolean[N+1][M];
		Queue<Point> queue = new LinkedList<>();
		
		int si = start.i;
		int sj = start.j;
		
		visited[si][sj] = true;
		queue.offer(new Point(si, sj));
		
		int distance = 0;
		
		while(!queue.isEmpty()) {
			if(distance>D || distance>minD) {		//공격범위 넘고 최단거리 넘으면 bfs탐색 종료
				break;
			}
			
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				
				if(map[nowi][nowj]==1) {			//적 발견하면 최단거리 갱신하고 후보에 추가(현재 사이즈까지만 돌고 끝남)
					minD = Math.min(minD, distance);
					huboList.add(new Point(nowi, nowj));
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj]) {
						continue;
					}
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;
					
				}
				
			}
			distance++;
		}
		
	}
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Point o) {
		
			return this.j-o.j;
		}
		
	}

}
