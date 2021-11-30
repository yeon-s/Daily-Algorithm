package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] input = new int[N];		//입력배열
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		//입력 끝
		
		int[] arr =new int[N];			//index-input배열 
		for(int i=0;i<N;i++) {			
			arr[i] = i-input[i];		//index-input이 작을수록 앞쪽으로감
		}

		int num=1;
		List<Integer> list = new ArrayList<Integer>();		//줄세울 어레이리스트(순서 반대로)
		for(int i=0;i<N;i++) {
			if(arr[i]==0) {									//0이면 맨 앞으로 가니까 리스트에 추가해서 맨뒤로
				list.add(num++);
			}else {
				list.add(list.size()-arr[i], num++);		//0이 아니면 끝에서 index-input으로 (반대니까)
			}
		}
		for(int i=N-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");				//반대로 출력
		}
	}

}
