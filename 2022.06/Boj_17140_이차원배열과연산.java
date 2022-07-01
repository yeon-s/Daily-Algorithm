package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_17140_이차원배열과연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rCnt =3,cCnt=3,time=0;
		Map<Integer,Integer> set = new HashMap<>();
		PriorityQueue<Num> pq = new PriorityQueue<>();
		
		while(true) {
			if(map[r-1][c-1]==k) break;
			
			if(rCnt>=cCnt) {
				cCnt=0;
				for(int i=0;i<100;i++) {
					set.clear();
					pq.clear();
					
					for(int j=0;j<100;j++) {
						if(map[i][j]==0) continue;
						set.put(map[i][j], set.getOrDefault(map[i][j],0)+1);
					}
					//배열 초기화
					for(int j=0;j<100;j++) {
						map[i][j]=0;
					}
					//맵에 있는거 우선순위큐에 넣기
					for(int number:set.keySet()) {
						pq.add(new Num(number,set.get(number)));
					}
					//배열에 넣기
					int idx=0;
					while(!pq.isEmpty()) {
						Num num = pq.poll();
						map[i][idx++]= num.num;
						map[i][idx++]= num.cnt;
						if(idx>=100) break;
					}
					cCnt=Math.max(cCnt, idx);
				}
			}else {
				rCnt=0;
				for(int j=0;j<100;j++) {
					set.clear();
					pq.clear();
					
					for(int i=0;i<100;i++) {
						if(map[i][j]==0) continue;
						set.put(map[i][j], set.getOrDefault(map[i][j],0)+1);
					}
					//배열 초기화
					for(int i=0;i<100;i++) {
						map[i][j]=0;
					}
					//맵에 있는거 우선순위큐에 넣기
					for(int number:set.keySet()) {
						pq.add(new Num(number,set.get(number)));
					}
					//배열에 넣기
					int idx=0;
					while(!pq.isEmpty()) {
						Num num = pq.poll();
						map[idx++][j]= num.num;
						map[idx++][j]= num.cnt;
						if(idx>=100) break;
					}
					rCnt=Math.max(rCnt, idx);
				}
			}
			
//			for(int i=0;i<6;i++) {
//				for(int j=0;j<6;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			time++;
			if(time>=100) {
				time=-1;
				break;
			}
		}
		
		System.out.println(time);
	}
	
	static class Num implements Comparable<Num>{
		int num;
		int cnt;
		public Num(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		public int compareTo(Num o) {
			if(this.cnt==o.cnt) return this.num-o.num;
			return this.cnt-o.cnt;
		}
	}

}
