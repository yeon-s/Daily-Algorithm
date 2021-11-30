package practice;

import java.util.Scanner;

public class Boj_1182_부분수열합 {

	static int N;
	static int S;
	static int[] arr;
	static boolean[] isSelected;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		isSelected = new boolean[N];
		result = 0;
		
		subset(0,0);		//부분조합으로 수열중에서 사용할 정수들 고르기
		if(S==0) {			//부분조합에서 모두 안고르게 되면 합이 0이 되는데  s가 0일때 포함되어버린다.
			System.out.println(result-1);		// 문제의 조건에서는 크기가 양수인 	부분수열이라고 명시했으므로 결과에서 1개를 뺴준다.
		}else {
			System.out.println(result);			
		}
	}

	static void subset(int cnt,int sum) {
		if(cnt == N) {			//음수도 있으므로 끝까지 완전 탐색
			if(sum==S) {		//합이 s가 되면
				result++;		//결과+1
			}
			return;
		}
		
		
		
		isSelected[cnt] = true;
		subset(cnt+1,sum+arr[cnt]);
		isSelected[cnt] = false;
		subset(cnt+1,sum);
		
	}
}
