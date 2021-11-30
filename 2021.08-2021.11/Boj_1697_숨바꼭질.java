package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
	
		System.out.println(bfs(N,K));
		
	}
	
	static int bfs(int N,int K) {			//가장 빠른 시간 찾아야하니까 bfs
		boolean[] visited = new boolean[100001];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(N);
		visited[N] =true;
		int distance =0;		//시간 변수(답)
		
		while(!queue.isEmpty()) {
			int size = queue.size();		//현재시간에서 갈수 있는 곳 모두 방문해볼거니까 사이즈 생성  
			
			for(int s=0;s<size;s++) {		//현재 시간에서 갈 수 있는 곳 확인
				
				int num = queue.poll();		
				
				if(num==K) {				//동생 찾으면 나가기
					return distance;
				}
				if(num-1>=0 && !visited[num-1]) {		//1빼보고 방문 안한 곳이면 큐에 넣기(큐에서 대기하다가 나중에 갈거)
					queue.offer(num-1);
					visited[num-1] = true;
				}
				if(num+1<=100000 && !visited[num+1]) {	////1 더해보고 방문 안한 곳이면 큐에 넣기(큐에서 대기하다가 나중에 갈거)
					queue.offer(num+1);
					visited[num+1] = true;
				}
				if(2*num<=100000 && !visited[2*num]) {	//*2해보고 방문 안한 곳이면 큐에 넣기(큐에서 대기하다가 나중에 갈거)
					queue.offer(2*num);
					visited[2*num] = true;
				}
			}
			distance++;
		}
		return -1;
	}
	
}
