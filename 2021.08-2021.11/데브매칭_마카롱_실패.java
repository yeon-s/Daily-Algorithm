package practice;

import java.util.ArrayList;
import java.util.List;


public class 데브매칭_마카롱_실패 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static List<Point> list2;
	static boolean[][] visited;
	public static void main(String[] args) {
		int[][] macaron = new int[50][2];
		macaron[0][0]=1;
		macaron[0][1]=1;
		macaron[1][0]=2;
		macaron[1][1]=1;
		macaron[2][0]=1;
		macaron[2][1]=2;
		//문제시작
		
		ArrayList<Integer>[] list = new ArrayList[7];
		
		for(int i=1;i<7;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int cnt=0;cnt<macaron.length;cnt++) {
			int posi = macaron[cnt][0];
			int color = macaron[cnt][1];
			
			list[posi].add(color);
			map = new int[7][7];
			for(int i=1;i<7;i++) {
				for(int j=1;j<list[i].size();j++) {
					map[j][i]=list[i].get(j);
				}
			}
			//2차원 배열 마카롱 채우기
			
			visited = new boolean[7][7];
			list2 = new ArrayList<>();
			for(int i=1;i<7;i++) {
				for(int j=1;j<7;j++) {
					if(!visited[i][j] && map[i][j] !=0) {
						list2.clear();
						dfs(i,j,map[i][j]);
						if(list2.size()>=3) {
							for(int k=0;k<list2.size();k++) {
								map[list2.get(k).i][list2.get(k).j]=0;
							}
						}
					}
				}
			}
			//dfs돌면서 3개이상이면 터지기
			for(int i=1;i<7;i++) {
				list[i].clear();
			}
			
			
			for(int i=1;i<7;i++) {
				for(int j=1;j<7;j++) {
					if(map[j][i] !=0) {
						list[i].add(map[j][i]);
					}
				}
			}
			
		}
		//다 끝났다.
		
		map = new int[7][7];
		for(int i=1;i<7;i++) {
			for(int j=1;j<list[i].size();j++) {
				map[j][i]=list[i].get(j);
			}
		}
		
		String[] answer = new String[6];
		for(int i=6;i>0;i--) {
			StringBuilder sb = new StringBuilder();
			for(int j=1;j<7;j++) {
				sb.append(map[i][j]);
			}
			answer[6-i]=(sb+"");
		}
		for(int i=0;i<6;i++) {
			System.out.println(answer[i]);
		}

	}
	
	static void dfs(int nowi,int nowj,int color) {
		visited[nowi][nowj] = true;
		list2.add(new Point(nowi, nowj));
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<1 || nextj<1 || nexti>6 || nextj>6 || map[nexti][nextj] !=color) {
				continue;
			}
			
			if(!visited[nexti][nextj]) {
				dfs(nexti,nextj,color);
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
