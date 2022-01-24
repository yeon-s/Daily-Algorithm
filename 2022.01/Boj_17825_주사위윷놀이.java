package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17825_주사위윷놀이 {

	static int max;
	static int[][] map = {{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
							{10,13,16,19,25,30,35,40},
							{20,22,24,25,30,35,40},
							{30,28,27,26,25,30,35,40}};
	static boolean[] arrive;
	static int[] index;
	static int[] road;
	static int[] command;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		command = new int[10];
		for(int i=0;i<10;i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		max=0;
		arrive = new boolean[4];	//각 말이 도착했는지
		index = new int[4];		//각 말이 몇번 인덱스인지
		road = new int[4];		//각 말이 있는 길이 어딘지
		dfs(0,0);
		
		System.out.println(max);
	}
	
	static void dfs(int cnt,int sum) {
		if(cnt==10) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(arrive[i]) {
				continue;
			}
			int roadNum = road[i];
			int current = index[i];
			
			int temp = current+command[cnt];
			
			if(roadNum==0) {
				if(temp>20) {
					arrive[i]=true;
				}else {
					if(temp==5) {
						road[i]=1;
						index[i]=0;
					}else if(temp==10) {
						road[i]=2;
						index[i]=0;
					}else if(temp==15) {
						road[i]=3;
						index[i]=0;
					}else {
						index[i]=temp;
					}
				}
			}else if(roadNum==1) {
				if(temp>7) {
					arrive[i]=true;
				}else {
					index[i]=temp;
				}
			}else if(roadNum==2) {
				if(temp>6) {
					arrive[i]=true;
				}else {
					index[i]=temp;
				}
			}else if(roadNum==3) {
				if(temp>7) {
					arrive[i]=true;
				}else {
					index[i]=temp;
				}
			}
			
			if(arrive[i]) {		//도착했다면 점수 없음
				dfs(cnt+1,sum);
				arrive[i]=false;		//돌아오면 도착한거 취소해주기
				
			}else {
				//말 겹치는지 확인
				boolean already=false;
				
				for(int j=0;j<4;j++) {
					if(i==j || arrive[j]) {		//나는 패스,도착한 말은 패스
						continue;
					}
					
					if(road[i]==road[j] && index[i]==index[j]) {
						already=true;
						break;
					}
					//길이 달라도 25,30,35,40에서 겹친다
					if( (map[road[i]][index[i]]==25 && map[road[j]][index[j]]==25) || 
							(index[i]!=0 && index[j]!=0 &&map[road[i]][index[i]]==30 && map[road[j]][index[j]]==30)|| 
							(map[road[i]][index[i]]==35 && map[road[j]][index[j]]==35)||
							(map[road[i]][index[i]]==40 && map[road[j]][index[j]]==40)) {
						already=true;
						break;
					}
				}
				
				if(already) {		//내가 다음가려는 곳에 다른 말있음
					//원래대로 돌려놔야지
					road[i]= roadNum;
					index[i]=current;
					continue;
				}
				dfs(cnt+1,sum+map[road[i]][index[i]]);
				//원래대로 돌려놓기
				road[i]= roadNum;
				index[i]=current;
			}
			
		}
		
	}

}
