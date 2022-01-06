package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12100_2048 {

	static int N;
	static Point[][] map;
	static Queue<Point> queue;
//	static Point[][] temp;
	static long answer;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new Point[N][N];
//		temp = new Point[N][N];
		long max=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= new Point(Integer.parseInt(st.nextToken()), false);
				max = Math.max(max, map[i][j].num);
			}
		}
		//입력 끝
		queue = new LinkedList<>();
		answer=0;
		
		
		Point[][] temp = new Point[N][N];
		for(int d=1;d<5;d++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					temp[i][j] = new Point(map[i][j].num, false);
				}
			}
			move(temp,d,0,max);
		}
		System.out.println(answer);
	}
	
	static void move(Point[][] copy,int d,int depth,long max) {
		if(depth==5) {
			answer = Math.max(answer, max);
			return;
		}
		
		if(answer>max*(5-depth)*2) {
			return;
		}
		
		
		switch(d) {
		case 1:
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copy[i][j].num==0) {
						continue;
					}
					queue.offer(new Point(copy[i][j].num, false));
					copy[i][j] = new Point(0, false);
				}
				if(queue.isEmpty()) {
					continue;
				}
				copy[i][0] = queue.poll();
				
				int index = 1;
				while(!queue.isEmpty()) {
					Point current = queue.poll();
					if(current.num==copy[i][index-1].num && !copy[i][index-1].comb) {
						copy[i][index-1].num *=2;
						if(copy[i][index-1].num>max) {
							max = copy[i][index-1].num;
						}
						copy[i][index-1].comb=true;
					}else {
						copy[i][index] = current;
						index++;
					}
				}
				
			}
			
			break;
		case 2:
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copy[j][i].num==0) {
						continue;
					}
					queue.offer(new Point(copy[j][i].num, false));
					copy[j][i] = new Point(0, false);
				}
				if(queue.isEmpty()) {
					continue;
				}
				copy[0][i] = queue.poll();
				
				int index = 1;
				while(!queue.isEmpty()) {
					Point current = queue.poll();
					if(current.num==copy[index-1][i].num && !copy[index-1][i].comb) {
						copy[index-1][i].num *=2;
						if(copy[index-1][i].num>max) {
							max = copy[index-1][i].num;
						}
						copy[index-1][i].comb=true;
					}else {
						copy[index][i] = current;
						index++;
					}
				}
				
			}
			break;
		case 3:
			
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(copy[i][j].num==0) {
						continue;
					}
					queue.offer(new Point(copy[i][j].num, false));
					copy[i][j] = new Point(0, false);
				}
				if(queue.isEmpty()) {
					continue;
				}
				copy[i][N-1] = queue.poll();
				
				int index = N-2;
				while(!queue.isEmpty()) {
					Point current = queue.poll();
					if(current.num==copy[i][index+1].num && !copy[i][index+1].comb) {
						copy[i][index+1].num *=2;
						if(copy[i][index+1].num>max) {
							max = copy[i][index+1].num;
						}
						copy[i][index+1].comb=true;
					}else {
						copy[i][index] = current;
						index--;
					}
				}
				
			}
			break;
		case 4:
			
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(copy[j][i].num==0) {
						continue;
					}
					queue.offer(new Point(copy[j][i].num, false));
					copy[j][i] = new Point(0, false);
				}
				if(queue.isEmpty()) {
					continue;
				}
				copy[N-1][i] = queue.poll();
				
				int index = N-2;
				while(!queue.isEmpty()) {
					Point current = queue.poll();
					if(current.num==copy[index+1][i].num && !copy[index+1][i].comb) {
						copy[index+1][i].num *=2;
						if(copy[index+1][i].num>max) {
							max = copy[index+1][i].num;
						}
						copy[index+1][i].comb=true;
					}else {
						copy[index][i] = current;
						index--;
					}
				}
				
			}
			break;
		}
		
		Point[][] temp = new Point[N][N];
		for(int di=1;di<5;di++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					temp[i][j] = new Point(copy[i][j].num, false);
				}
			}
			move(temp,di,depth+1,max);
		}
		
	}
	
	static class Point{
		long num;
		boolean comb;
		public Point(long num, boolean comb) {
			super();
			this.num = num;
			this.comb = comb;
		}
		
	}

}
