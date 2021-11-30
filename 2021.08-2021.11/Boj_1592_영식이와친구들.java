package practice;

import java.util.Scanner;

public class Boj_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr =new int[N];
		arr[0]=1;
		int index=0;
		int count =0;
		while(true) {
			if(arr[index]%2==1) {
				index += L;
				if(index>=N) {
					index = index-N;
				}
				arr[index]++;
				
			}else {
				index -=L;
				if(index<0) {
					index = index+N;
				}
				arr[index]++;
			}
			count++;
			if(arr[index]==M) {
				System.out.println(count);
				break;
			}
		}
	}

}
