package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_23291_어항정리 {

	static int[][] map;
	static int N;
	static int K;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		map = new int[10][N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int j=0;j<N;j++) {
			map[9][j] = Integer.parseInt(st.nextToken());
		}
		
		int answer=0;
		while(true) {
			//1. 물고기 가장 적은 곳에 +1
			int min = 11000;
			for(int j=0;j<N;j++) {
				if(map[9][j]==0) {
					break;
				}
				min = Math.min(min, map[9][j]);
			}
			
			for(int j=0;j<N;j++) {
				if(map[9][j]==min) {
					map[9][j]++;
				}
			}
			
			//2. 공중부양 후 회전
			rotate();
			//3. 물고기 수 조절
			control();		
			
			//4. 일렬로 놓기
			oneRow();
			//5.공중부양 두번
			twice();
			//6.물고기 조절 및 일렬로 놓기
			control();
			oneRow();
			
			answer++;
			
			int max = 0;
			min = 11000;
			for(int j=0;j<N;j++) {
				max= Math.max(max, map[9][j]);
				min = Math.min(min, map[9][j]);
			}
			if(max-min<=K) {	// 물고기 수 차이가 K이하이면
				break;
			}
		}
		
		System.out.println(answer);

	}
	
	static void twice() {
		Stack<Integer> stack = new Stack<>();
		for(int j=0;j<N/2;j++) {
			stack.push(map[9][j]);
			map[9][j]=0;
		}
		
		for(int j=N/2;j<N;j++) {
			map[8][j] = stack.pop();
		}
		
		stack.clear();
		for(int i=0;i<2;i++) {
			for(int j=0;j<N/4;j++) {
				stack.push(map[i+8][j+N/2]);
				map[i+8][j+N/2]=0;
			}
		}
		
		//오른쪽 위에 뿌려주자
		for(int i=0;i<2;i++) {
			for(int j=0;j<N/4;j++) {
				map[6+i][N/2+N/4+j]=stack.pop();
			}
		}
		
	}
	
	static void oneRow() {
		List<Integer> list = new ArrayList<>();
		for(int j=0;j<N;j++) {
			if(map[9][j]==0) {
				continue;
			}
			for(int i=9;i>=0;i--) {
				if(map[i][j]==0) {
					break;
				}
				list.add(map[i][j]);
				map[i][j]=0;
			}
		}
		
		for(int j=0;j<N;j++) {
			map[9][j] = list.get(j);
		}
	}
	
	static void control() {
		int[][] temp = new int[10][N];		//물고기 이동하는 숫자 저장해놓을 배열
		boolean[][] visited = new boolean[10][N];
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					
					for(int d=0;d<4;d++) {
						int nexti = i+di[d];
						int nextj = j+dj[d];
						
						if(nexti<0 || nextj<0 || nexti>=10 || nextj>=N || map[nexti][nextj]==0 || visited[nexti][nextj]) {
							continue;
						}
						
						int num = Math.abs(map[i][j]-map[nexti][nextj])/5;
						if(num>0) {
							if(map[i][j]>map[nexti][nextj]) {
								temp[i][j]-=num;
								temp[nexti][nextj]+=num;
							}else {
								temp[i][j]+=num;
								temp[nexti][nextj]-=num;
							}
						}
					}
					visited[i][j]=true;
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=temp[i][j];
			}
		}
	}
	
	static void rotate() {
		int index=0;
		int height = 1;
		int width=1;
		int cnt=0;
		Queue<Integer> queue = new LinkedList<>();
		
		while(true) {
			//넣어주기
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					queue.offer(map[9-j][index+i]);
					map[9-j][index+i]=0;
				}
			}
			
			//width만큼 이동하고
			index+=width;	
			
			//빼주기
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {	
					map[9-width+i][index+j]=queue.poll();
				}
			}
			
			cnt++;
			if(cnt%2==0) {
				width++;
			}else {
				height++;
			}
			
			if(N-width-index<height) {
				break;
			}
		}
			
	}

}
