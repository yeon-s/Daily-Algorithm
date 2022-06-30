package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_16235_나무재테크 {

	static int N;
	static int[][] map,add;
	static ArrayList<Tree>[][] trees;
	static ArrayList<Tree> dead;
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];		//양분 저장 맵
		add = new int[N][N];		//양분 추가되는 양
		trees = new ArrayList[N][N];		//나무리스트 저장 맵
		dead = new ArrayList<>();		//죽은 나무 저장 리스트
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
				trees[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees[x-1][y-1].add(new Tree(x-1, y-1, z));
		}
		//입력  끝
		
		while(K-->0) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer+=trees[i][j].size();
			}
		}

		System.out.println(answer);
	}
	
	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=add[i][j];
			}
		}
	}
	
	static void fall() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int size = trees[i][j].size();
				
				for(int k=0;k<size;k++) {
					Tree t = trees[i][j].get(k);
					if(t.age%5==0) {		//번식
						for(int d=0;d<8;d++) {
							int nexti = i+di[d];
							int nextj = j+dj[d];
							
							if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) continue;
							
							trees[nexti][nextj].add(new Tree(nexti, nextj, 1));
						}
					}
				}
			}
		}
	}
	
	static void summer() {
		for(int i=0;i<dead.size();i++) {
			Tree t = dead.get(i);
			map[t.i][t.j]+= t.age/2;
		}
		dead.clear();
	}
	
	static void spring() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Collections.sort(trees[i][j]);
				ArrayList<Tree> temp = new ArrayList<>();
				int size = trees[i][j].size();
				
				for(int k=0;k<size;k++) {
					Tree t = trees[i][j].get(k);
					if(map[i][j]>=t.age) {		//나이만큼 양분 먹을 수 있으면
						map[i][j]-=t.age;
						t.age+=1;
						temp.add(t);
					}else {		//양분 못먹으면
						dead.add(new Tree(t.i, t.j, t.age));
					}
				}
				//양분 먹은 나무만 저장
				trees[i][j] = temp;
				
			}
		}
	}
	
	static class Tree implements Comparable<Tree>{
		int i;
		int j;
		int age;
		public Tree(int i,int j, int age) {
			this.i=i;
			this.j=j;
			this.age=age;
		}
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}

}
