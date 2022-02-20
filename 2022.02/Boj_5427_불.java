package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427_불 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			Queue<Fire> fire = new LinkedList<>();
			Queue<Sang> sang = new LinkedList<>();
			boolean[][] visited = new boolean[h][w];
			boolean[][] fireVisited = new boolean[h][w];
			
			char[][] map = new char[h][w];
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='*') {
						fire.offer(new Fire(i, j));
						fireVisited[i][j]=true;
					}
					if(map[i][j]=='@') {
						sang.offer(new Sang(i, j));
						visited[i][j]=true;
					}
					
				}
			}
			
			int time=0;
			boolean flag=false;
			here : while(!sang.isEmpty()) {
				int size = sang.size();
				int fireSize = fire.size();
				
				while(fireSize-->0) {
					Fire curFire = fire.poll();
					
					for(int d=0;d<4;d++) {
						int nexti = curFire.i+di[d];
						int nextj = curFire.j+dj[d];
						
						if(nexti<0 || nextj<0 || nexti>=h || nextj>=w || fireVisited[nexti][nextj] || map[nexti][nextj]=='#') {
							continue;
						}
						fire.offer(new Fire(nexti, nextj));
						fireVisited[nexti][nextj]=true;
					}
					
				}
				
				while(size-->0) {					
					Sang curSang = sang.poll();
//					if(curSang.i<0 || curSang.i>=h || curSang.j<0 || curSang.j>=w) {		//탈출
//						flag=true;
//						break here;
//					}
					
					for(int d=0;d<4;d++) {
						int nexti = curSang.i+di[d];
						int nextj = curSang.j+dj[d];
						
						if(nexti<0 || nextj<0 || nexti>=h || nextj>=w) {
							flag=true;
							break here;
						}
						
						if(fireVisited[nexti][nextj] || visited[nexti][nextj] || map[nexti][nextj]=='#') {
							continue;
						}
						sang.offer(new Sang(nexti, nextj));
						visited[nexti][nextj]=true;
					}
				}
				time++;
			}
			
			if(flag) {
				sb.append((time+1)+"\n");
			}else {
				sb.append("IMPOSSIBLE"+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static class Fire{
		int i;
		int j;
		public Fire(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	static class Sang{
		int i;
		int j;
		public Sang(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}

}
