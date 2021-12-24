package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1194_달이차오른다가자2 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static String[] arr = {"a","b","c","d","e","f"};
	static String[] result;
	static boolean[] isSelected;
	static int index;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		Queue<Point> queue = new LinkedList<>();
		result = new String[64];
		for(int i=0;i<64;i++) {
			result[i]="";
		}
		isSelected = new boolean[6];
		index=0;
		
		String key = "abcdef";
		String door = "ABCDEF";
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='0') {
					queue.offer(new Point(i, j,""));
				}
			}
		}
		//입력 끝
			
		boolean[][][] visited = new boolean[N][M][64];
		boolean flag = false;		//도착여부
		int answer = 0;
		int depth=0;
		subset(0);
		for(int i=0;i<64;i++) {
			String str = result[i];
			char[] sort = str.toCharArray();
			Arrays.sort(sort);
			result[i] = new String(sort);
		}
//		System.out.println(Arrays.toString(result));
		
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				String haveKeys = current.keyList;
				char[] sort = haveKeys.toCharArray();
				Arrays.sort(sort);
				haveKeys = new String(sort);
//				System.out.println(nowi+" "+nowj+" "+haveKeys);
				
				if(map[nowi][nowj]=='1') {
					flag=true;
					answer = depth;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || map[nexti][nextj]=='#') {
						continue;
					}
					
					int num=findIndex(haveKeys);
					
					
					if(!visited[nexti][nextj][num]) {
						if (key.contains(map[nexti][nextj] + "")) {
							if(haveKeys.contains(map[nexti][nextj]+"")) {
								queue.offer(new Point(nexti, nextj, haveKeys));
								visited[nexti][nextj][num]=true;
							}else {
								String changeHaveKeys = haveKeys + (map[nexti][nextj] + "");
								sort = changeHaveKeys.toCharArray();
								Arrays.sort(sort);
								changeHaveKeys = new String(sort);
								queue.offer(new Point(nexti, nextj, changeHaveKeys));	
								
								int num2=findIndex(changeHaveKeys);
								visited[nexti][nextj][num2]=true;
							}
							
						} else if (door.contains(map[nexti][nextj] + "")) {
							char doorNum = map[nexti][nextj];
							if (check(doorNum, haveKeys)) {			//열쇠 있다면
								queue.offer(new Point(nexti, nextj, haveKeys));
								visited[nexti][nextj][num]=true;
							} else {			//없다면
								continue;
							}
						} else {
							queue.offer(new Point(nexti, nextj, haveKeys));
							visited[nexti][nextj][num]=true;
						}
						
					}


				}
			}
			if(flag) {
				break;
			}
			depth++;
		}
		
//		System.out.println(Arrays.deepToString(visited));
		
		if(flag) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static int findIndex(String haveKeys) {
		for(int i=0;i<64;i++) {
			if(haveKeys.equals(result[i])) {
				return i;
			}
		}
		return -1;
	}
	
	static void subset(int cnt) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				if(isSelected[i]) {
					result[index] += arr[i]; 
				}
			}
			index++;
			return;
		}
		
		isSelected[cnt]=false;
		subset(cnt+1);
		isSelected[cnt]=true;
		subset(cnt+1);
	}
	
	static boolean check(char doorNum,String haveKeys) {
		haveKeys = haveKeys.toUpperCase();
		if(haveKeys.contains(doorNum+"")) {
			return true;
		}
		return false;
	}
	
	static class Point {
		int i;
		int j;
		String keyList;
		public Point(int i, int j,String keyList) {
			super();
			this.i = i;
			this.j = j;
			this.keyList = keyList;
		}
		
	}

}
