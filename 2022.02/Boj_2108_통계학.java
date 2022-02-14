package practice;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_2108_통계학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] check = new int[8001];
		int sum=0;
		int max=-4001;
		int min = 4001;

		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			if(arr[i]<0) {
				check[Math.abs(arr[i])+4000]++;
			}else {
				check[arr[i]]++;
			}
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		
		int maxCnt=0;
		for(int i=0;i<8001;i++) {
			if(check[i]>maxCnt) {
				maxCnt=check[i];
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<8001;i++) {
			if(maxCnt==check[i]) {
				if(i>4000) {
					list.add((i-4000)*-1);
				}else {
					list.add(i);					
				}
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(Math.round((double)sum/(double)N));
		System.out.println(arr[N/2]);
		if(list.size()==1) {
			System.out.println(list.get(0));
		}else {
			Collections.sort(list);
			System.out.println(list.get(1));
		}
		System.out.println(max-min);
	}

}
