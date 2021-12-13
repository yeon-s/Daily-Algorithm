package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_16235_나무재테크2 {

	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] add = new int[N+1][N+1];
		int[][] map = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		PriorityQueue<Tree> pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		//입력 끝
		
		List<Tree> treeList = new ArrayList<>(); //살아있는 나무 담을 리스트
		List<Tree> deadTreeList = new ArrayList<>();		//죽은 나무 담을 리스트
		
		while(K-->0) {
			//Collections.sort(treeList);		//나이 어린 순 정렬
			deadTreeList.clear();			//죽은 나무 리스트 초기화
			treeList.clear();
			//봄
			while(!pq.isEmpty()) {
				Tree tree = pq.poll();
				if(map[tree.r][tree.c]>=tree.age) {			
					map[tree.r][tree.c] -= tree.age;
					treeList.add(new Tree(tree.r, tree.c, tree.age+1));
				}else {
					deadTreeList.add(new Tree(tree.r, tree.c, tree.age));
				}
			}
			//여름
			for(int i=0,size=deadTreeList.size();i<size;i++) {
				Tree tree = deadTreeList.get(i);
				map[tree.r][tree.c] += tree.age/2;
			}
			//가을
			
			for(int i=0,size=treeList.size();i<size;i++) {
				if(treeList.get(i).age%5==0) {
					Tree tree = treeList.get(i);
					int nowi = tree.r;
					int nowj = tree.c;
					for(int d=0;d<8;d++) {
						int nexti = nowi+di[d];
						int nextj = nowj+dj[d];
						if(nexti<1 || nextj<1 || nexti>N || nextj>N) {
							continue;
						}
						treeList.add(new Tree(nexti, nextj, 1));
					}
				}
			}
			for(int i=0,size=treeList.size();i<size;i++) {
				pq.add(treeList.get(i));
			}
			//겨울
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					map[i][j] += add[i][j];
				}
			}
		}
		
		System.out.println(treeList.size());

	}
	
	static class Tree implements Comparable<Tree>{
		int r;
		int c;
		int age;
		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
		
	}

}
