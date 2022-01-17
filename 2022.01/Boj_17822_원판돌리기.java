package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17822_원판돌리기 {

	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] arr = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		boolean[][] visited = new boolean[N+1][M];
		List<Point> list = new ArrayList<>();
		int sum=0;
		
		while(T-->0) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(k>M/2) {
				k=M-k;
				if(d==0) {
					d=1;
				}else {
					d=0;
				}
			}
			int num=1;
			int temp=x;
			
			while(temp<=N) {
				int count=k;
				while(count-->0) {
					if(d==0) {	//시계방향
						arr[temp].addFirst(arr[temp].removeLast());
					}else {		//반시계방향
						arr[temp].addLast(arr[temp].removeFirst());
					}
				}
				num++;
				temp=x*num;
			}
			
			//인접하면서 같은 수 찾기
			boolean flag = false;		//인접한 애들 중 같은 수 없음
			sum=0;
			int cnt=0;
			list.clear();
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					visited[i][j]=false;
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					int number = arr[i].get(j);
					sum+=number;
					visited[i][j]=true;
					
					if(number!=0) {
						cnt++;
						boolean check=false;
						
						for(int c=0;c<4;c++) {
							int nexti = i+di[c];
							int nextj = j+dj[c];
							if(nextj<0) {
								nextj=M-1;
							}else if(nextj>=M) {
								nextj=0;
							}
							
							if(nexti<1 || nexti>N || arr[nexti].get(nextj) !=number || visited[nexti][nextj]) {
								continue;
							}
							//인접한 애들 중 같은 수 있으면 일로옴
							flag = true;
							check=true;
							list.add(new Point(nexti, nextj));
						}
						if(check) {
							list.add(new Point(i, j));
						}
					}
				}
			}
			if(sum==0) {
				break;
			}
			
			if(flag) {
				//담아둔 애들 다 0으로 만들기
				for(Point p:list) {
					arr[p.i].set(p.j, 0);
				}
			}else {
				//원판 평균 구해서 작업
				double avg = (float)sum/(float)cnt;
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						int s = arr[i].get(j);
						if(s!=0) {
							if(s>avg) {
								arr[i].set(j, s-1);
							}else if(s<avg){
								arr[i].set(j, s+1);
							}							
						}
					}
				}
			}
			
		}
		
		int answer=0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				answer+=arr[i].get(j);
			}
		}
		System.out.println(answer);

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
