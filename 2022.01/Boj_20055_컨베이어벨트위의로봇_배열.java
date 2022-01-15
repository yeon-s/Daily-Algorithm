package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_20055_컨베이어벨트위의로봇_배열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] list = new int[2*N];		//내구도
		boolean[] robot = new boolean[N];		//로봇 유무
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		
		int time =1;
		int cnt=0;
		
		while(true) {
			//1.벨트 회전
			int temp = list[(2*N)-1];
			for(int i=(2*N)-2;i>=0;i--) {
				list[i+1]=list[i];
			}
			list[0]=temp;
			
			boolean temp2 = robot[N-1];
			for(int i=N-2;i>=0;i--) {
				robot[i+1]=robot[i];
			}
			robot[0]=temp2;
			
			if(robot[N-1]) {		//내리는 위치 도착하면 로봇 빼기
				robot[N-1]=false;
			}
			//2.로봇이동
			for(int i=N-2;i>=0;i--) {
				if(robot[i+1]) {
					continue;
				}
				if(robot[i] && list[i+1]>0) {
					robot[i]=false;
					if(i+1 != N-1) {		//내리는 곳이 아니면
						robot[i+1]=true;						
					}
					list[i+1] -= 1;
					if(list[i+1]==0) {		//처음 if문 들어올때 내구도 0보다 큰애들만 들어오므로 새롭게 0되는애만 걸림
						cnt++;
					}
				}
			}
			//3.올리는 위치에 내구도 0아니면 로봇올리기
			if(list[0] !=0) {
				robot[0] = true;
				list[0] -=1;
				if(list[0]==0) {		//처음 if문 들어올때 내구도 0보다 큰애들만 들어오므로 새롭게 0되는애만 걸림
					cnt++;
				}
			}
			//4.
			if(cnt>=K) {
				break;
			}
			time++;
		}
		
		System.out.println(time);		

	}

}
