package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9328_열쇠 {

	static int[][] visited;
	static int h;
	static int w;
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int key;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h= Integer.parseInt(st.nextToken());
			w= Integer.parseInt(st.nextToken());
			key=0;
			answer=0;
			map = new char[h+2][w+2];
			for(int i=1;i<=h;i++) {
				String str= br.readLine();
				for(int j=1;j<=w;j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			visited = new int[h+2][w+2];
			for(int i=0;i<h+2;i++) {
				for(int j=0;j<w+2;j++) {
					visited[i][j]=-1;
				}
			}
			String startKey = br.readLine();
			//입력 끝

			if(!startKey.equals("0")) {
				char[] keys = startKey.toCharArray();
				for(int i=0;i<keys.length;i++) {
					key |= (1<<keys[i]-'a');
				}
			}
			
			bfs();
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		visited[0][0]=key;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=h+2 || nextj>=w+2 || map[nexti][nextj]=='*' || visited[nexti][nextj]==key) {
					continue;
				}
				
				char c = map[nexti][nextj];
				visited[nexti][nextj]=key;
				
				if(c=='$') {
					answer++;
				}else if(c-'A'>=0 && c-'Z'<=0) {		//대문자면
					if((key & (1<<c-'A'))==0) {
						continue;
					}
				}else if(c-'a'>=0 && c-'z'<=0) {		//소문자면
					key |= (1<< c-'a');
					
				}
				
				map[nexti][nextj]='.';
				queue.offer(new Point(nexti, nextj));
			}
		}
		
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

}
