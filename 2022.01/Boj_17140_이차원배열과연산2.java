package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_17140_이차원배열과연산2 {

	static int[][] arr;
	static List<Integer> list;
	static int iNum;
	static int jNum;
	static Map<Integer, Integer> map;
	static PriorityQueue<Ob> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝

		list = new ArrayList<>();
		map = new HashMap<>();
		
		int time = 0;
		boolean flag=true;
		while(true) {
			if(arr[r-1][c-1]==k) {
				break;
			}
			if(time>100) {
				flag=false;
				break;
				//-1출력
			}
			
			//행개수 열개수 비교
			iNum = findI();			//행크기
			jNum = findJ();			//열크기
			
			if(iNum>=jNum) {
				calR();
			}else {
				calC();
			}
			
			time++;
		}
		
		
		if(flag) {
			System.out.println(time);
		}else {
			System.out.println(-1);
		}
	}
	
	static int findI() {
		int max=0;
		for(int j=0;j<100;j++) {
			int num=0;
			for(int i=0;i<100;i++) {
				if(arr[i][j] !=0) {
					num++;
				}else {
					break;
				}
			}		
			if(num>max) {
				max= num;
			}
		}
		return max;
	}
	
	static int findJ() {
		int max=0;
		for(int j=0;j<100;j++) {
			int num=0;
			for(int i=0;i<100;i++) {
				if(arr[j][i] !=0) {
					num++;
				}else {
					break;
				}
			}		
			if(num>max) {
				max= num;
			}
		}
		return max;
	}
	
	
	static void calR() {
		
		for(int i=0;i<iNum;i++) {
			map.clear();
			for(int j=0;j<jNum;j++) {
				if(arr[i][j]==0) {
					continue;
				}
				map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
			}
			
			pq.clear();
			for(int key:map.keySet()) {
				pq.offer(new Ob(key, map.get(key)));
			}
			
			list.clear();
			while(!pq.isEmpty()) {
				Ob cur = pq.poll();
				list.add(cur.num);
				list.add(cur.count);
				if(list.size()>=100) {
					break;
				}
			}
			
			for(int j=0;j<100;j++) {
				if(j<list.size()) {
					arr[i][j] = list.get(j);					
				}else {
					arr[i][j]=0;
				}
			}
			
		}
	}
	
	
static void calC() {
		
		for(int j=0;j<jNum;j++) {
			map.clear();
			for(int i=0;i<iNum;i++) {
				if(arr[i][j]==0) {
					continue;
				}
				map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
			}
			
			pq.clear();
			for(int key:map.keySet()) {
				pq.offer(new Ob(key, map.get(key)));
			}
			
			list.clear();
			while(!pq.isEmpty()) {
				Ob cur = pq.poll();
				list.add(cur.num);
				list.add(cur.count);
				if(list.size()>=100) {
					break;
				}
			}
			
			for(int i=0;i<100;i++) {
				if(i<list.size()) {
					arr[i][j] = list.get(i);					
				}else {
					arr[i][j]=0;
				}
			}
			
		}
	}
	
	static class Ob implements Comparable<Ob>{
		int num;
		int count;
		public Ob(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
		@Override
		public int compareTo(Ob o) {
			if(this.count!=o.count) {
				return this.count-o.count;
			}else {
				return this.num-o.num;
			}
		}
		
	}

}
