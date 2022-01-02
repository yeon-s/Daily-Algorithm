package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10819_차이를최대로 {

	static int N;
	static boolean[] isSelected;
	static int[] arr;
	static int max;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		isSelected = new boolean[N];
		max=0;
		result = new int[N];
		
		perm(0);
		System.out.println(max);
		
	}
	
	static void perm(int target) {
		if(target==N) {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=Math.abs(result[i]-result[i+1]);
			}
			max= Math.max(sum, max);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i]=true;
			result[target] = arr[i];
			perm(target+1);
			isSelected[i]=false;
			result[target]=0;
		}
	}

}
