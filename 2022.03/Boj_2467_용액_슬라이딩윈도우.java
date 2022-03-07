package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2467_용액_슬라이딩윈도우 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		
		int sum = arr[0]+arr[1];
		int min = Math.abs(sum);
		int[] answer = new int[2];
		answer[0]=arr[0];
		answer[1]=arr[1];
		for(int i=1;i<N-1;i++) {
			sum+=arr[i+1];
			sum-=arr[i-1];
			if(Math.abs(sum)<min) {
				min=Math.abs(sum);
				answer[0]=arr[i];
				answer[1]=arr[i+1];
			}
		}
		
		Arrays.sort(answer);
		System.out.println(answer[0]+" "+answer[1]);
	}

}
