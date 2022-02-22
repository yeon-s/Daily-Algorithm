package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_16637_괄호추가하기 {

	static int N;
	static int[] arr;
	static int[] ch;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		arr = new int[(N+1)/2];
		ch = new int[(N-1)/2];
		
		String str = br.readLine();
		for(int i=0;i<N;i++) {
			if(i==0) {
				arr[0]=str.charAt(0)-'0';
				continue;
			}
			if(i%2==0) {
				arr[i/2]=str.charAt(i)-'0';
			}else {
				char c = str.charAt(i);
				int num=0;
				if(c=='+') {
					num=1;
				}else if(c=='-') {
					num=2;
				}else if(c=='*') {
					num=3;
				}
				ch[(i-1)/2]=num;
			}
		}
		//입력 끝
		
		if(N==1) {
			System.out.println(arr[0]);
			return;
		}
		
		max=Integer.MIN_VALUE;
		subset(0,0);
		System.out.println(max);
	}
	
	static void subset(int cnt,int sum) {
		if(cnt==(N+1)/2) {
			max= Math.max(max, sum);
			return;
		}
		
		if(cnt==0) {
			if(cnt+1<(N+1)/2) {
				subset(cnt+2,cal(arr[cnt],arr[cnt+1],ch[cnt]));				
			}
			
			subset(cnt+1,arr[cnt]);
		}else {
			if(cnt+1<(N+1)/2) {
				subset(cnt+2,cal(sum,cal(arr[cnt],arr[cnt+1],ch[cnt]),ch[cnt-1]));				
			}
			
			subset(cnt+1,cal(sum,arr[cnt],ch[cnt-1]));
		}
	}
	
	static int cal(int one,int two, int cha) {
		
		if(cha==1) {
			return one+two;
		}else if(cha==2) {
			return one-two;
		}else{
			return one*two;
		}
		
	}

}
