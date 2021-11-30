package practice;

import java.util.Scanner;

public class Boj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		
		if(N%5==0) {
			answer = N/5;
		}else {
			boolean flag = false;
			
			for(int i=N/5;i>=0;i--) {
				if((N-(5*i))%3==0) {
					answer = i+((N-(5*i))/3);
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				answer=-1;				
			}
		}

		System.out.println(answer);
	}

}
