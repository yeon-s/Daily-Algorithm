package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3190_뱀_실패 {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	static int nowi;
	static int nowj;
	static int d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		//사과 있는 곳은 4로 셋팅
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 4;
		}
		
		int L = Integer.parseInt(br.readLine());
		ChangeDirection[] arr = new ChangeDirection[L];
		for(int i=0;i<L;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr[i] = new ChangeDirection(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		//입력 끝
		
		nowi=0;
		nowj=0;
		int time=0;
		int index=0;
		d=1;
		List<Snake> snake = new ArrayList<>();
		snake.add(new Snake(nowi, nowj));
		Queue<Snake> move = new LinkedList<>();
		while(true) {
			map[nowi][nowj]=1;
			
			time++;
			
			
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti>=N || nexti<0 || nextj<0 || nextj>=N || map[nexti][nextj] ==1) {
				break;
			}
			
			for(int i=0;i<snake.size();i++) {
				Snake temp = new Snake(snake.get(i).y,snake.get(i).x);
				move.offer(temp);
			}
			//사과 먹었을 때
			if(map[nexti][nextj]==4) {
				map[nexti][nextj]=1;
				snake.add(new Snake(0, 0));
				for(int i=1;i<snake.size();i++) {
					Snake body = move.poll();
					snake.get(i).y = body.y;
					snake.get(i).x = body.x;
				}
			}else {
				map[nexti][nextj]=1;
				if(snake.size()>1) {
					for(int i=1;i<snake.size();i++) {
						Snake body = move.poll();
						snake.get(i).y = body.y;
						snake.get(i).x = body.x;
					}
				}
				Snake tail = move.poll();
				map[tail.y][tail.x]=0;
			}
			
			snake.get(0).y = nexti;
			snake.get(0).x = nextj;
			nowi=nexti;
			nowj= nextj;
			
			
			if(time == arr[index].x) {
				if(arr[index].c.equals("D")){
					d +=1;
					if(d==4) {
						d=0;
					}
				}else if(arr[index].c.equals("L")) {
					d -=1;
					if(d<0) {
						d=3;
					}
				}
				if(index+1<L) { 
					index++;					
				}
			}
		}
			System.out.println(time);	
	}

	
	static class ChangeDirection {
		int x;
		String c;
		
		public ChangeDirection(int x, String c) {
			super();
			this.x = x;
			this.c = c;
		}
		
		
	}
	
	static class Snake{
		int y;
		int x;
		public Snake(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
}
