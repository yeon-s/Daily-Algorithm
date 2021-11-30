package practice;

import java.util.Scanner;

public class Swea_5215_햄버거다이어트 {

	static int N;
	static int L;
	static food[] arr;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			arr = new food[N];
			for(int i=0;i<N;i++) {
				arr[i] = new food(sc.nextInt(), sc.nextInt());
			}
			//입력 끝
			max=0;
			subset(0,0,0);
			
			System.out.println("#"+tc+" "+max);
			
		}

	}

	static class food{
		int score;
		int cal;
		public food(int score, int cal) {
			super();
			this.score = score;
			this.cal = cal;
		}
		
	}
	
	static void subset(int cnt,int score,int cal ) {
		if(cal>L) {
			return;
		}
		
		if(cnt==N) {
			max = Math.max(max, score);
			return;
		}
		
		subset(cnt+1,score+arr[cnt].score,cal+arr[cnt].cal);
		
		subset(cnt+1,score,cal);
		
	}
}
