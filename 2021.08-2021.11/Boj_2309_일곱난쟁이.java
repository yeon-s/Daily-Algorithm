package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj_2309_일곱난쟁이 {

	static int N=9,R=7;
	static boolean out;
	static List<Integer> list;
	static int[] arr;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[N];
		for(int i=0;i<9;i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		isSelected = new boolean[N];
		//입력 끝
		list = new ArrayList<Integer>();
		out = false;
		
		comb(0,0,0);
		
		Collections.sort(list);
		for(int num : list) {
			System.out.println(num);
		}

	}
	
	static void comb(int target, int cnt,int sum) {
		if(out) {
			return;
		}
		if(sum>100) {
			return;
		}
		if(cnt==R) {
			if(sum==100) {
				for(int i=0;i<N;i++) {
					if(isSelected[i]) {
						list.add(arr[i]);
					}
				}
				out=true;
				return;
			}
			return;
		}
		if(target==N) {
			return;
		}
		
		isSelected[target] = true;
		comb(target+1,cnt+1,sum+arr[target]);
		isSelected[target]= false;
		comb(target+1,cnt,sum);
	}
}
