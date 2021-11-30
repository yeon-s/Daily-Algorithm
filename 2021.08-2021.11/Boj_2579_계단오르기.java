package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		
		int[][] D = new int[3][N+1];			//한걸음으로 갔을 때의 최대 점수와 두걸음으로 갔을 때의 최대점수를 저장할 이차원 배열  
		D[1][1] = arr[1];						//첫번째 계단까지의 최대 점수 초기화
		
		for(int i=2;i<=N;i++) {
			D[1][i]= Math.max(D[1][i-2], D[2][i-2])+arr[i];	//i번째 계단을 한걸음으로 가려면 i-2번째 계단에서 점프해서 올 수밖에 없으므로 i-2번째 계단에서의 최대점수에 i번째 계단점수를 더해준 점수가 i번째 계단 최대점수 
			D[2][i]= D[1][i-1]+arr[i];						//i번째 계단을 두번째걸음으로 도착하려면 i-1번째 계단에서 걸어와야만 하므로 i-1번째 계단을 한걸음으로 왔을때의 최대점수에 i번째 계단점수 더해주기
		}
		int result = Math.max(D[1][N], D[2][N]);			//N번째 계단을 한걸음으로 오거나 두번째 걸음으로 온 점수 중 높은점수를 결과로
		System.out.println(result);
		
		
		
		
		
		
		
		
	}

	static class Info{
		int score;
		int walk;
		int now;
		public Info(int score, int walk, int now) {
			super();
			this.score = score;
			this.walk = walk;
			this.now = now;
		}
		
		
	}
}
