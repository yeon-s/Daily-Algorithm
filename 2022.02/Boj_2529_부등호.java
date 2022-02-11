package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2529_부등호 {

	static int k;
	static int[] compare;
	static int[] result;
	static boolean[] isSelected;
	static long max;
	static long min;
	static StringBuilder sb;
	static String answerMin;
	static String answerMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
	
		compare = new int[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			if(st.nextToken().charAt(0)=='<') {
				compare[i]=-1;
			}else {
				compare[i]=1;
			}
		}
		
		result = new int[k+1];
		isSelected = new boolean[10];
		max=Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		answerMin="";
		answerMax="";
		
		perm(0);
		if(max==Long.MAX_VALUE) {
			answerMax = answerMin;
		}
		if(min==Long.MIN_VALUE) {
			answerMin=answerMax;
		}
		System.out.println(answerMax);
		System.out.println(answerMin);
	}
	
	static void perm(int cnt) {
		if(cnt==k+1) {
			sb=new StringBuilder();
			for(int i=0;i<=k;i++) {
				sb.append(result[i]);
			}
			
			long num = Long.parseLong(sb+"");

			if(num>max) {
				answerMax=(sb+"");
				max=num;
			}
			if(num<min) {
				answerMin=(sb+"");
				min=num;
			}
			return;
		}
		
		for(int i=0;i<=9;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			if(cnt==0) {
				isSelected[i]=true;
				result[cnt]=i;
				perm(cnt+1);
				isSelected[i]=false;
			}else {
				if(compare[cnt-1]==-1) {
					if(i<=result[cnt-1]) {
						continue;
					}
					isSelected[i]=true;
					result[cnt]=i;
					perm(cnt+1);
					isSelected[i]=false;	
				}else {
					if(i>=result[cnt-1]) {
						continue;
					}
					isSelected[i]=true;
					result[cnt]=i;
					perm(cnt+1);
					isSelected[i]=false;
				}
			}
			
		}
	}

}
