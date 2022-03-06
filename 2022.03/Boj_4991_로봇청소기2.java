package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4991_로봇청소기2 {

	static boolean[] isSelected;
	static int R;
	static List<Point> list;
	static int min;
	static int si;
	static int sj;
	static char[][] map;
	static int w;
	static int h;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) {
				break;
			}
			
			map = new char[h][w];
			list = new ArrayList<>();
			for(int i=0;i<h;i++) {
				String str= br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='o') {
						si=i;
						sj=j;
					}else if(map[i][j]=='*') {
						list.add(new Point(i, j,list.size()));
					}
				}
			}
			
			R=list.size();
			isSelected= new boolean[R];
			min = Integer.MAX_VALUE;
			D= new int[R+1][R+1];
			
			boolean flag=false;
			loop : for(int i=0;i<R;i++) {
				D[i][R]=D[R][i] = bfs(list.get(i).i,list.get(i).j,si,sj);
				if(D[i][R]==-1) {
					flag=true;
					break;
				}
				for(int j=0;j<R;j++) {
					if(D[i][j]!=0 || i==j) {
						continue;
					}
					D[i][j]=D[j][i] = bfs(list.get(i).i,list.get(i).j,list.get(j).i,list.get(j).j);
					if(D[i][j]==-1) {
						flag=true;
						break loop;
					}
				}
			}
			if(flag) {
				sb.append(-1+"\n");
				continue;
			}
			perm(0,0,R);
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int starti,int startj,int endi,int endj) {
		boolean[][] visited= new boolean[h][w];
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(starti, startj));
		visited[starti][startj]=true;
		
		int time=0;
		while(!queue.isEmpty()) {
			int size= queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				if(cur.i==endi && cur.j==endj) {
					return time;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=h || nextj>=w || visited[nexti][nextj] || map[nexti][nextj]=='x') {
						continue;
					}
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;
				}
			}
			time++;
		}
		return -1;
	}
	
	static void perm(int cnt,int sum,int index) {
		if(cnt==R) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<R;i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i]=true;
			perm(cnt+1,sum+D[index][i],i);
			isSelected[i]=false;
		}
	}
	
	static class Point{
		int i;
		int j;
		int index;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		public Point(int i, int j, int index) {
			super();
			this.i = i;
			this.j = j;
			this.index = index;
		}
		
		
	}
}

