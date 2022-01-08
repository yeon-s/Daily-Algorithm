package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj_19238_스타트택시 {

	static int N;
	static int[][] map;
	static Point current;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		current = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		
		int PersonNumber=2;
		String[]arr = new String[2+M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = PersonNumber;
			arr[PersonNumber] = st.nextToken()+" "+st.nextToken();
			PersonNumber++;
		}
		//입력 끝
		
		boolean flag = true;
		
		while(true) {
			if(checkPerson()) {		//더이상 손님 안남아있으면 끝내기
				break;
			}
			
			//현재 위치에서 최단거리 손님 찾기
			int num = bfs(1,0,0);				//num은 현재에서 손님까지 간거리
			if(num==-1 || L-num<0) {		//손님이 있는데 손님한테 갈 수가 없거나 연료가 모자랐던 경우
				flag=false;
				break;
			}
			
			L-=num;
			
			//목적지 찾기
			st = new StringTokenizer(arr[map[current.i][current.j]]);
			int destI = Integer.parseInt(st.nextToken())-1;
			int destJ = Integer.parseInt(st.nextToken())-1;
			
			map[current.i][current.j]=0;
			
			//현재위치에서 목적지 가기
			int num2 = bfs(2,destI,destJ);		//num2는 손님에서 목적지까지 간 거리
			
			if(num2==-1 || L-num2<0) {			//목적지 못가거나 연료 모자랐던 경우
				flag=false;
				break;
			}
			
			L+=num2;
//			map[current.i][current.j]=0;
		}
		
		if(flag) {
			System.out.println(L);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static int bfs(int check,int destI,int destJ) {			//check가 1이면손님찾기    2면 목적지 찾기
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		pq.offer(new Point(current.i, current.j,0));
		visited[current.i][current.j] = true;
		
		int distance=0;
		
		while(!pq.isEmpty()) {
			int size = pq.size();
			while(size-->0) {
				Point cur = pq.poll();
				int nowi = cur.i;
				int nowj = cur.j;
				if(check==1 && map[nowi][nowj]>1 ) {
					current = new Point(nowi, nowj);
					return distance;
				}
				
				if(check==2 && destI==nowi && destJ==nowj) {
					current = new Point(nowi, nowj);
					return distance;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || map[nexti][nextj]==1) {
						continue;
					}
					pq.offer(new Point(nexti, nextj,distance+1));
					visited[nexti][nextj] = true;
				}
				
			}
			distance++;
		}
		
		return -1;	
	}
	
	static boolean checkPerson() {			//남은 손님 있는지 확인
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int d;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		public Point(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.d!=o.d) {
				return this.d-o.d;
			}else {
				if(this.i==o.i) {
					return this.j-o.j;
				}else {
					return this.i-o.i;
				}				
			}		
		}	
	}
}
